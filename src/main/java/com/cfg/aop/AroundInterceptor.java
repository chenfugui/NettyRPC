package com.cfg.aop;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @ClassName: AroundInterceptor
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 15:01
 * @Version: 1.0
 */
public class AroundInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().getName()+" 调用前");
        Object res=invocation.proceed();
        System.out.println(invocation.getMethod().getName()+" 调用后");
        return res;
    }
}
