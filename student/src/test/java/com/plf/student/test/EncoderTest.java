package com.plf.student.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:t_spring/test.xml")
public class EncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test1() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }
}
