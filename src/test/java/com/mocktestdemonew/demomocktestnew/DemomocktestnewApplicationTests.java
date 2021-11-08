package com.mocktestdemonew.demomocktestnew;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import com.mocktestdemonew.demomocktestnew.dao.UserRepository;
import com.mocktestdemonew.demomocktestnew.model.User;
import com.mocktestdemonew.demomocktestnew.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith( SpringRunner.class )
@SpringBootTest
public class DemomocktestnewApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@org.junit.Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(101, "Akash", "Asst HR")).collect(Collectors.toList()));
		assertEquals(1, service.getAllUsers().size());
	}

	@org.junit.Test
	public void addUserTest()
	{
		User user = new User(501,"Arthi","Accountant");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));
	}

	@org.junit.Test
	public void deleUser()
	{
		User user = new User(501, "Arthi","Accountant");
		service.deleteUserById(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}


}
