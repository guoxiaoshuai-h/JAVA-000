package com.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 14:54
 */
@Configuration
@EnableConfigurationProperties(Student.class)
@ConditionalOnClass(StudentService.class)
@ConditionalOnProperty(prefix = "spring.student", value = "enabled", matchIfMissing = true)
public class StudentServiceAutoConfiguration {

    @Autowired
    private Student student;

    @Bean
    @ConditionalOnMissingBean(StudentService.class)
    public StudentService studentService() {
        return new StudentService(student);
    }
}
