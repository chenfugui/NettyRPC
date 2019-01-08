package com.cfg.aop.service.impl;

import com.cfg.aop.service.PeopleService;

/**
 * @ClassName: EnglishService
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 14:58
 * @Version: 1.0
 */
public class EnglishService implements PeopleService {
    @Override
    public void sayHello() {
        System.out.println("say hello ");
    }

    @Override
    public void printName(String name) {
        System.out.println("your name: "+name);
    }

    @Override
    public Integer getAge(String name) {
        System.out.println(name +"age:"+10);
        return 10;
    }
}
