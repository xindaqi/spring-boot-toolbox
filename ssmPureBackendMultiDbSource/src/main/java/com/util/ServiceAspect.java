package com.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component 
@Aspect 
@Order(-1)
public class ServiceAspect{
    /**
     * Set cut point, using another data source path.
     */
    @Pointcut("execution(* com.anotherdatasource.service.bigdata.*.*(..))")
    // @Pointcut("execution(* com.datasource.service.admin.*.*(..))")
    public void aspect(){
        System.out.format("aspect function\n");
    }

    /**
     * Before entering cut method, switch data source.
     * @param joinPoint
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        String funcName = joinPoint.getSignature().getName();
        System.out.format("Aspect of function: "+funcName+"\n");
        System.out.format("before another data source\n");
        DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_ANOTHER);
    }

    /**
     * After exit cut point, close data source.
     * @param joinPoint
     */
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.format("after another data source\n");
        DynamicDataSource.clearCustomerType();
    }

    /**
     * Exception processing when dispatcher running.
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut="aspect()", throwing="ex") 
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        System.out.format("use another data source\n");
        DynamicDataSource.clearCustomerType();
    }
}