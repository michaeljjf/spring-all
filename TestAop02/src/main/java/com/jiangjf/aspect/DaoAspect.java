package com.jiangjf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect// 切点注解
@Component// 对象管理注解
@Order(2)// 多个Aspect时，指定执行顺序
public class DaoAspect {

    /**
     * 对于相同的切点表达式，可以定义一个公共的切点
     */
    @Pointcut("execution(* com.jiangjf.dao.*.*(..))")
    public void pointCut() {

    }

    /**
     * 前置通知：在切点方法之前执行
     * @param joinPoint
     */
//    @Before("execution(* com.jiangjf.dao.UserDao.*(..))")
    @Before("pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("DaoAspect methodBefore invoke ...");
//        Object[] args = joinPoint.getArgs();
//        System.out.println("getTarget：" + joinPoint.getTarget().getClass().getSimpleName());
//        System.out.println("args：" + Arrays.toString(args));
    }

    /**
     * 后置通知、最终通知：切点方法无论是否异常，都会执行的方法
     * 类似try catch里的finally
     */
    @After("pointCut()")
    public void methodAfter() {
        System.out.println("DaoAspect methodAfter invoke ...");
    }

    /**
     * 返回通知：在切点方法返回结果之后增强的功能
     * 切点方法无异常时执行
     * returning 用于指定接收返回值的变量名
     * @param joinPoint
     * @param res
     */
    @AfterReturning(value = "pointCut()", returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("DaoAspect methodAfterReturning invoke ...");
//        System.out.println(res);
    }

    /**
     * 异常通知：切点方法出现异常才执行
     * throwing 用于指定接收异常的变量名
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void methodAfterThrowing(Exception exception) {
        System.out.println("DaoAspect methodAfterThrowing invoke ...");
        System.out.println(exception.getMessage());
    }

    /**
     * 环绕通知：切点方法之前和之后都进行的功能增强
     * 参数列表需要带上一个特殊的形参：
     * ProceedingJoinPoint 代表我们的切点
     * 通过ProceedingJoinPoint手动控制切点方法的执行位置
     * 环绕通知的返回值必须是Object，把切点方法的返回结果向上返回
     */
    @Around("pointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("DaoAspect methodAroundA invoke ...");
        Object object = proceedingJoinPoint.proceed();// 切点方法执行
        System.out.println("DaoAspect methodAroundB invoke ...");
        return object;
    }

}
