package com.marcus.ss.ssdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-12-14 14:21
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("all1")
    public List<Customer> getAllCustomer1() {
        return customerMapper.findAll();
    }

}
