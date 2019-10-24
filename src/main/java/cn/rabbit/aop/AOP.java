package cn.rabbit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component      //加入 IOC 容器
@Aspect     //  指定一个类为切面类
public class AOP {

    //使用@Pointcut这个注解，来指定切入点表达式，在用到的地方中，直接引用就行了！
    //注意引用的时候需要带上括号
    @Pointcut("execution(* cn.rabbit.dao.*.*(..))")     //指定切入点表达式
    public void pt() {

    }


    //前置通知: 目标方法之前执行
    @Before("pt()")
    public void begin() {
        System.out.println("开启事务");
    }

    //后置通知：目标方法之后执行（始终执行）
    @After("pt()")
    public void  close() {
        System.out.println("关闭事务");
    }

    // 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    // 异常通知： 当目标方法执行异常时候执行此关注点代码
    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("afterThrowing()");
    }

    // 环绕通知：环绕目标方式执行, 教程 how2j 使用的就是环绕通知
    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        //ProceedingJoinPoint类： 是 aspectj 包下的
        System.out.println("环绕前....");
        pjp.proceed();       // 执行目标方法
        System.out.println("环绕后....");
    }
}
