package com.springcourse.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember() {

        System.out.println(getClass() + ": adding account");
        return true;
    }
}
