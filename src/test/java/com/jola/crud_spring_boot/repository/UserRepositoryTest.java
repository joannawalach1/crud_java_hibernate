package com.jola.crud_spring_boot.repository;

import com.jola.crud_spring_boot.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addNew() {
        User user = new User("user1@op.pl", "password1", "Anna", "Nowak");
        userRepository.save(user);
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
        User user = new User("user2@op.pl", "password1", "Anna", "Nowak");
        userRepository.save(user);
        int id = user.getId();
        Optional<User> foundUser = userRepository.findById(id);

        assertNotNull(foundUser);
        assertEquals("Anna", foundUser.get().getFirstName());
    }

    @Test
    void findAll() {
        Iterable<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.spliterator().estimateSize() == 0, "Lista użytkowników nie powinna być pusta");
        assertTrue(users.iterator().hasNext(), "Lista użytkowników powinna zawierać przynajmniej jeden element");
    }

    @Test
    void count() {
        userRepository.save(new User("user3@op.pl", "password3", "Anna", "Nowak"));
        userRepository.save(new User("user4@op.pl", "password4", "Jan", "Kowalski"));
        long count = userRepository.count();
        assertEquals(2, count);
    }

    @Test
    void deleteById() {
        User save = userRepository.save(new User("use5@op.pl", "password3", "Anna", "Nowak"));
        int userId = save.getId();
        userRepository.deleteById(userId);
        assertFalse(userRepository.findById(userId).isPresent());
    }

    @Test
    void deleteAll() {
        userRepository.deleteAll();
        assertEquals(0, userRepository.count());
    }
}