package com.marcus.ss.ssdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-12-14 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private long customer_id;

    private String mobile;

    private String customer_name;

    private String password;

    private String email;

    private String address;

    private Timestamp create_time;

    private Timestamp update_time;
}
