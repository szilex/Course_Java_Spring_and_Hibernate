package com.springcourse.aopdemo.dao;

import com.springcourse.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String code;

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": adding account");
        System.out.println("Name: " + account.getName());
        System.out.println("Level: " + account.getLevel());
    }

    public String getName() {
        System.out.println("Account DAO getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("Account DAO setName");
        this.name = name;
    }

    public String getCode() {
        System.out.println("Account DAO getCode");
        return code;
    }

    public void setCode(String code) {
        System.out.println("Account DAO setCode");
        this.code = code;
    }
}
