package com.cfg.aop.service;

/**
 * @ClassName: PeopleService
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 14:55
 * @Version: 1.0
 */
public interface PeopleService {

    public void sayHello();

    public void printName(String name);

    public Integer getAge(String name);
}
