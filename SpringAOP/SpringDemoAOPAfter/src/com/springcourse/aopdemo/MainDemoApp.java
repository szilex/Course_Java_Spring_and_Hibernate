package com.springcourse.aopdemo;

import com.springcourse.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;

        try {
            boolean throwException = false;
            accounts = accountDAO.findAccounts(throwException);
            accounts.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Caught exception in main");
        }

        context.close();

    }
}
