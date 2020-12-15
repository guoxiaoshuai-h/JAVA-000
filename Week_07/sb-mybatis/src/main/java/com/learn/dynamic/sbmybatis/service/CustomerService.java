package com.learn.dynamic.sbmybatis.service;

import com.learn.dynamic.sbmybatis.datasource.CurDataSource;
import com.learn.dynamic.sbmybatis.entity.Customer;
import com.learn.dynamic.sbmybatis.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-12-14 14:18
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getAllCustomerFromPrimary() {
        return customerMapper.findAll();
    }

    @CurDataSource
    public List<Customer> getAllCustomerFromSecondary() {
        return customerMapper.findAll();
    }
}
