package com.cfg.aop.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: JdkDynamicProxyInvocationHandler
 * @Description: jdk动态代理
 * @Author: Administrator
 * @CreateDate: 2019/01/08 15:13
 * @Version: 1.0
 */
public class JdkDynamicProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public JdkDynamicProxyInvocationHandler(Object target){
        this.target=target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befor run print");
        Object result=method.invoke(this.target,args);
        System.out.println("after run print");
        return result;
    }
}
