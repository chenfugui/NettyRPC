package com.cfg.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName: AopBeforeAdvice
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 15:57
 * @Version: 1.0
 */
public class AopBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("methodbeforAdvice methodname: "+method.getName()+" parameters:"+args+" targetName:"+target.getClass().getName());
    }
}
