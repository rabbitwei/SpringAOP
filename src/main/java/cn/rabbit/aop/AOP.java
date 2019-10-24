package cn.rabbit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class AOP {
    public void begin() {
        System.out.println("开启事务");
    }

    public void close() {
        System.out.println("关闭事务");
    }

    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing()");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        //ProceedingJoinPoint类： 是 aspectj 包下的
        System.out.println("环绕前....");
        pjp.proceed();       // 执行目标方法
        System.out.println("环绕后....");
    }
}
