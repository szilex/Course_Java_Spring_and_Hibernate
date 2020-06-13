package com.springcourse.aopdemo.dao;

import com.springcourse.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": adding account");
        System.out.println("Name: " + account.getName());
        System.out.println("Level: " + account.getLevel());
    }
}
