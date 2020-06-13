package com.springcourse.aopdemo;

import com.springcourse.aopdemo.dao.AccountDAO;
import com.springcourse.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        Account account = new Account();
        account.setName("John Doe");
        account.setLevel("SECURE");
        accountDAO.addAccount(account, true);
        accountDAO.setName("John Wick");
        accountDAO.setCode("1241");

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addMember();
        membershipDAO.randomMethod();

        context.close();

    }
}
