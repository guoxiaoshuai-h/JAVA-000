package com.learn.dynamic.sbmybatis.mapper;

import com.learn.dynamic.sbmybatis.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-12-14 14:15
 */
@Mapper
public interface CustomerMapper {

    @Select("select * from customer")
    List<Customer> findAll();
}
