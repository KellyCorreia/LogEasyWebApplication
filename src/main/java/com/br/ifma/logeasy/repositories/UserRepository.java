package com.br.ifma.logeasy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.ifma.logeasy.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);
}
