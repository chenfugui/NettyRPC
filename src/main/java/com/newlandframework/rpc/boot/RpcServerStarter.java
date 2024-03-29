/**
 * Copyright (C) 2016 Newland Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.newlandframework.rpc.boot;

import com.newlandframework.rpc.model.MessageKeyVal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tangjie<https://github.com/tang-jie>
 * @filename:RpcServerStarter.java
 * @description:RpcServerStarter功能模块
 * @blogs http://www.cnblogs.com/jietang/
 * @since 2016/10/7
 */
public class RpcServerStarter {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-server.xml");
        //启用注解配置
       /* AnnotationConfigApplicationContext  ctxx = new AnnotationConfigApplicationContext();
        ctxx.scan("com.newlandframework.rpc");
        ctxx.refresh();
        MessageKeyVal kv2=(MessageKeyVal) ctxx.getBean("messageKeyVal");
        System.out.println(String.valueOf(kv2.getAge()));

        MessageKeyVal kv3= ctxx.getBean(MessageKeyVal.class);


        System.out.println(String.valueOf(kv3.getAge()));*/
    }
}

