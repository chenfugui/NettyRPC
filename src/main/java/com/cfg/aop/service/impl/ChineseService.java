package com.cfg.aop.service.impl;

/**
 * @ClassName: ChineseService
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/08 15:59
 * @Version: 1.0
 */
public class ChineseService {


    public void sayHello() {
        System.out.println(" 你好 ");
    }


    public void printName(String name) {
        System.out.println("你的 名字: "+name);
    }


    public Integer getAge(String name) {
        System.out.println(name +"年龄:"+10);
        return 10;
    }
}
