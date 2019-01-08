package com.cfg.aop.service;

import com.google.common.reflect.AbstractInvocationHandler;

import java.lang.reflect.Method;

/**
 * @ClassName: GuavaJdkProxyHandler
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/08 15:42
 * @Version: 1.0
 */
public class GuavaJdkProxyHandler extends AbstractInvocationHandler {

    private Object target;

    public GuavaJdkProxyHandler(Object target){
        this.target=target;
    }

    @Override
    protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("guava jdkproxy befor run print");
        Object result=method.invoke(this.target,args);
        System.out.println("guava jdkproxy after run print");
        return result;
    }
}
