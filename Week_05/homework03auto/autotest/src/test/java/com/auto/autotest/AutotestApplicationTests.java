package com.auto.autotest;

import com.auto.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AutotestApplicationTests {

    @Autowired
    private StudentService service;

    @Test
    void contextLoads() {
        service.say();
    }

}
