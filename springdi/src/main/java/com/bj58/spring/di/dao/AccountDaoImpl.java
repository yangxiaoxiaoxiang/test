package com.bj58.spring.di.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements  IAccountDao{

       public void save(){
           System.out.print("accountDaoImpl save success");
       }
}
