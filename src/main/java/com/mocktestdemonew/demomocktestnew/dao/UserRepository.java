package com.mocktestdemonew.demomocktestnew.dao;

import com.mocktestdemonew.demomocktestnew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
