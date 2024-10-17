package com.learning.journalApp.service;

import com.learning.journalApp.entity.User;
import com.learning.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFindByUserName(){
        assertNotNull(userRepository.findByUserName("admin"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "admin",
            "vijay"
    })
    public void testFindByUserNames(String name){
        assertNotNull(userRepository.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,4,6",
            "3,6,10"
    })
    public void testCsvSource(int a, int b, int expected){
        assertEquals(expected,a+b);
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testArgumentsSource(User user){
        assertTrue(userService.saveNewUser(user));
    }
}
