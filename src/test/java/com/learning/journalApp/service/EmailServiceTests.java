package com.learning.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    EmailService emailService;

    @Test
    void testSendEmail(){
        emailService.sendEmail("vm8943369648@gmail.com","Test mail JournalApp", "Hi, Hope you're doing well!");
    }

}
