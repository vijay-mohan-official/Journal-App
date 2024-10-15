package com.learning.journalApp.service;

import com.learning.journalApp.entity.User;
import com.learning.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.mockito.Mockito.when;

//@SpringBootTest annotation will be used if we are playing with Application Context
public class UserDetailsServiceImplTests {

    //@Autowired will be used if we are playing with Application Context
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    //Use @MockBean when playing with Application Context
    @Mock
    private UserRepository userRepository;

    //Need to initialize all mocks as we are no longer playing with Application Context
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUserNameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("vijay").password("vijay").roles(Collections.singletonList("USER")).build());
        UserDetails userDetails = userDetailsService.loadUserByUsername("vijay");
        Assertions.assertNotNull(userDetails);
    }

}
