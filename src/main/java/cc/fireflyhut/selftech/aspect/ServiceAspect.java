package cc.fireflyhut.selftech.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class ServiceAspect {

    @Pointcut("execution(* cc.fireflyhut.selftech.service.CommonService+.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Advice before...");
        // 获得目标方法参数列表
        List<Object> argList =  Arrays.asList(joinPoint.getArgs());
        // 获得方法签名
        Signature methodSignature = joinPoint.getSignature();
        // 获得方法名
        String methodName = methodSignature.getName();

        System.out.println("方法签名：" + methodSignature);
        System.out.println("方法名：" + methodName);
        System.out.println("参数列表：" + argList);
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Advice after...");
    }

    /**
     * 1. 要在@AfterReturning注解中加入returning属性
     * 2. 返回值要用Object类型接收
     * 3. 参数名字和returning属性的值要一致
     * */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("Advice afterReturning...");
        System.out.println("返回结果：" + result);
    }

    /**
     * 1. 要在@AfterThrowing注解中加入throwing属性
     * 2. 异常信息要用Throwable类型接收
     * 3. 参数名字和throwing属性值要一致
     * */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(Throwable exception) {
        System.out.println("Advice afterThrowing...");
        System.out.println("异常信息：" + exception.getMessage());
    }
}
