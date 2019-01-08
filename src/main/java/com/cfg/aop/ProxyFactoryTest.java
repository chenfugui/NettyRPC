package com.cfg.aop;

import com.cfg.aop.service.CglibProxyMethodInterceptor;
import com.cfg.aop.service.GuavaJdkProxyHandler;
import com.cfg.aop.service.JdkDynamicProxyInvocationHandler;
import com.cfg.aop.service.PeopleService;
import com.cfg.aop.service.impl.ChineseService;
import com.cfg.aop.service.impl.EnglishService;
import com.google.common.reflect.Reflection;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyFactoryTest
 * @Description: 描述
 * @Author: Administrator
 * @CreateDate: 2019/01/04 15:06
 * @Version: 1.0
 */
public class ProxyFactoryTest {

    //spring aop代理对象
    @Test
    public void classProxy(){

        //代理对象未指定接口，使用CGLIB生成代理对象
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new MyTarget());
        factory.addAdvice(new AroundInterceptor());
        MyTarget targetProxy = (MyTarget)factory.getProxy();
        targetProxy.printName();
        System.out.println(targetProxy.getClass().getName());
    }
    //spring aop代理对象
    @Test
    public void interfaceProxy(){
        //代理对象指定接口PeopleService,默认拦截所有方法，目标类为实现该接口的EnglishService,使用jdk生成代理类
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{ PeopleService.class });
        proxyFactory.setTarget(new EnglishService());
        proxyFactory.addAdvice(new AroundInterceptor());
        PeopleService peopleService = (PeopleService) proxyFactory.getProxy();
        peopleService.printName("jack");
        System.out.println(peopleService.getClass().getName());
        peopleService.sayHello();
    }
    //spring aop代理对象
    @Test
    public void interfaceNameMathProxy(){
        //代理对象指定接口PeopleService，拦截指定方法,目标类为实现该接口的EnglishService,使用jdk生成代理类
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{ PeopleService.class });
        proxyFactory.setTarget(new EnglishService());
        //拦截printName方法
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("printName");
        advisor.setAdvice(new AroundInterceptor());
        proxyFactory.addAdvisor(advisor);
        //拦截sayHello方法
        NameMatchMethodPointcutAdvisor advisor2 = new NameMatchMethodPointcutAdvisor();
        advisor2.setMappedName("sayHello");
        advisor2.setAdvice(new AroundInterceptor());
        proxyFactory.addAdvisor(advisor2);
        //获取代理对象
        PeopleService peopleService = (PeopleService) proxyFactory.getProxy();

        peopleService.printName("jack");
        System.out.println(peopleService.getClass().getName());
        peopleService.sayHello();
    }
    //spring aop代理对象
    @Test
    public void MethodBeforOrAfterProxy(){
        //代理对象指定接口PeopleService,默认拦截所有方法，目标类为实现该接口的EnglishService,使用jdk生成代理类
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{ PeopleService.class });
        proxyFactory.setTarget(new EnglishService());
        //befor advice(advice就是自己要插入执行的代码)
        proxyFactory.addAdvice(new AopBeforeAdvice());
        //after advice (方法执行结束后运行的代码)
        proxyFactory.addAdvice(new AopAfterAdvice());
        PeopleService peopleService = (PeopleService) proxyFactory.getProxy();
        peopleService.printName("jack");
        System.out.println(peopleService.getClass().getName());
        peopleService.getAge("Bluce");
    }
    //jdk动态代理
    @Test
    public void jdkProxy(){
        //jdk的动态代理
        PeopleService englishService = new EnglishService();
        JdkDynamicProxyInvocationHandler proxyHandler=new JdkDynamicProxyInvocationHandler(englishService);
        //PeopleService peopleService = (PeopleService) Proxy.newProxyInstance(this.getClass().getClassLoader(), EnglishService.class.getInterfaces(),proxyHandler);
        PeopleService peopleService = (PeopleService) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[] { PeopleService.class },proxyHandler);
        Integer age=peopleService.getAge("jack");
        System.out.println("age====: "+age);
    }
    //guava封装的jdk动态代理
    @Test
    public void guavaJdkProxy(){
        PeopleService englishService = new EnglishService();
        GuavaJdkProxyHandler guavaProxyHandler=new GuavaJdkProxyHandler(englishService);
        PeopleService peopleService=Reflection.newProxy(PeopleService.class,guavaProxyHandler);
        Integer age = peopleService.getAge("jack");
        System.out.println("age====: "+age);
    }
    //cglib动态代理
    @Test
    public void cglibProxy(){
        ChineseService chineseService = new ChineseService();
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(ChineseService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibProxyMethodInterceptor());
        // 创建代理对象
        ChineseService proxy= (ChineseService)enhancer.create();
        // 通过代理对象调用目标方法
        Integer age = proxy.getAge("jack");
        System.out.println("age====: "+age);
    }
}
