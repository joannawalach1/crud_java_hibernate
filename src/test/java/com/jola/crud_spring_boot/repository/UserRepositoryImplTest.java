package com.jola.crud_spring_boot.repository;

import com.jola.crud_spring_boot.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    public void addNew() {
        User user = new User("user1@op.pl", "password1", "Anna", "Nowak");
        userRepositoryImpl.save(user);
        assertNotNull(user);
        assertEquals("Anna", user.getFirstName());
    }

    @Test
    void saveAll() {
        List<User> users = new ArrayList<User>();
        User user = new User("user1@op.pl", "password1", "Anna", "Nowak");
        users.add(user);
        assertEquals(1, users.size());
        assertTrue(users.contains(user));
    }

    @Test
    void findById() {
        User user = new User("user1@op.pl", "password1", "Anna", "Nowak");
        userRepositoryImpl.save(user);
        int id = user.getId();
        User foundUser = userRepositoryImpl.findById(id);

        assertNotNull(foundUser);
        assertEquals("Anna", user.getFirstName());
    }

    @Test
    void findAll() {
        List<User> users =
    }

    @Test
    void count() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void testDeleteAll() {
    }
}