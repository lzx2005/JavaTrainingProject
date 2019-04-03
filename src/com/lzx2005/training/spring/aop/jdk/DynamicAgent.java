package com.lzx2005.training.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hzlizx on 2019/4/3
 */
public class DynamicAgent {

    static class MyHanlder implements InvocationHandler{
        private Object proxy;

        public MyHanlder(Object proxy) {
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }

    public static Object agent(Class interfaceClazz, Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, new MyHanlder(proxy));
    }
}
