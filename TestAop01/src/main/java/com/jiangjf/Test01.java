package com.jiangjf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {
    public static void main(String[] args) {
        Dinner dinner = new Person("张三");
        // 被代理对象的类加载器
        ClassLoader loader = dinner.getClass().getClassLoader();
        // 被代理对象所实现的所有接口
        Class[] interfaces = dinner.getClass().getInterfaces();
        // 执行处理器对象，专门用于定义增强的规则
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;// 原有方法的返回值
                if (method.getName().equals("eat")) {
                    // 增强eat方法
                    System.out.println("饭前洗手");
                    obj = method.invoke(dinner, args);
                    System.out.println("饭后收拾");
                } else {
                    obj = method.invoke(dinner, args);
                }
                return obj;
            }
        };
        Dinner dinnerProxy = (Dinner)Proxy.newProxyInstance(loader, interfaces, handler);
        dinnerProxy.eat("包子");
    }
}

class Person implements Dinner {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "在家里吃" + foodName);
    }

    @Override
    public void drink() {
        System.out.println("喝茶");
    }
}

class Student implements Dinner {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "在食堂吃" + foodName);
    }

    @Override
    public void drink() {
        System.out.println("喝饮料");
    }
}

interface Dinner {
    void eat(String foodName);
    void drink();
}