package com.learn.dynamic.sbmybatis.controller;

import com.learn.dynamic.sbmybatis.entity.Customer;
import com.learn.dynamic.sbmybatis.service.CustomerService;
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
    private CustomerService customerService;

    @GetMapping("all1")
    public List<Customer> getAllCustomer1() {
        return customerService.getAllCustomerFromPrimary();
    }

    @GetMapping("all2")
    public List<Customer> getAllCustomer2() {
        return customerService.getAllCustomerFromSecondary();
    }
}
