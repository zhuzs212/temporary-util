package com.zzs.temporaryutil.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    // 1. 前置通知（Before）
    @Before("execution(* com.zzs.temporaryutil.service.*.*(..))")
    public void logBefore(JoinPoint jp) {
        System.out.println("[AOP] 前置通知: " + jp.getSignature());
        System.out.println("[AOP] 参数: " + Arrays.toString(jp.getArgs()));
    }

    // 2. 后置返回通知（AfterReturning）
    @AfterReturning(pointcut = "execution(* com.zzs.temporaryutil.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint jp, Object result) {
        System.out.println("[AOP] 返回通知: " + jp.getSignature() + " 返回值 = " + result);
    }

    // 3. 异常通知（AfterThrowing）
    @AfterThrowing(pointcut = "execution(* com.zzs.temporaryutil.service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("[AOP] 异常通知: " + jp.getSignature() + " 抛出异常: " + ex);
    }

    // 4. 后置最终通知（After）——无论成功或异常都会执行
    @After("execution(* com.zzs.temporaryutil.service.*.*(..))")
    public void logAfter(JoinPoint jp) {
        System.out.println("[AOP] 最终通知: " + jp.getSignature());
    }

    // 5. 环绕通知（Around）——最强大，可控制方法是否执行、返回值等
    @Around("execution(* com.zzs.temporaryutil.service.UserService.getUser(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AOP] 环绕前: " + pjp.getSignature());
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();   // 执行目标方法

        long time = System.currentTimeMillis() - start;
        System.out.println("[AOP] 环绕后: " + pjp.getSignature() + " 耗时 " + time + "ms");
        return result;
    }
}