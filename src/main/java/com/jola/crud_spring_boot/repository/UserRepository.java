package com.jola.crud_spring_boot.repository;

import com.jola.crud_spring_boot.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
