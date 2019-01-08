package com.cfg.aop.service;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: CglibProxyMethodInterceptor
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/08 15:55
 * @Version: 1.0
 */
public class CglibProxyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglibproxy befor run print");
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println("cglibproxy after run print");
        return result;
    }
}
