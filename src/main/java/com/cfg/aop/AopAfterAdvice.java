package com.cfg.aop;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName: AopAfterAdvice
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 16:00
 * @Version: 1.0
 */
public class AopAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("returnValue: "+ String.valueOf(returnValue) +" methodname: "+method.getName()+" parameters:"+args+" targetName:"+target.getClass().getName());
    }
}
