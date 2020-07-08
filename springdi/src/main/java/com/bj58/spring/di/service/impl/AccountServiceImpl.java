package com.bj58.spring.di.service.impl;

import com.bj58.spring.di.dao.IAccountDao;
import com.bj58.spring.di.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service
public class AccountServiceImpl implements IAccountService {

       @Autowired
       private IAccountDao accountDao;

       public void saveAccount(int num){
              System.out.print(num);
       }
       public static void main(String[] args){
              IAccountService accountService = new AccountServiceImpl();
              IAccountService serviceProxy = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                      accountService.getClass().getInterfaces(), new InvocationHandler() {
                             @Override
                             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                                    Object value = method.invoke( accountService, (Integer) args[0]* 2 );
                                 return value;
                             }
                      });
              serviceProxy.saveAccount(1000);


       }
}

