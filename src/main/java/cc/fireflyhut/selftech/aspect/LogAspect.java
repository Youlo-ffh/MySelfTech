package cc.fireflyhut.selftech.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // 定义一个方法取代切入点表达式
    @Pointcut("execution(* cc.fireflyhut.selftech.component.CommonBean.onlyAMethod(..))")
    public void pointCut() {}

    // 改写以下通知的切入点表达式为切入点表达式的方法名
    @Before("pointCut()")
    public void before() {
        System.out.println("Advice method before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("Advice method after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("Advice method afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("Advice method afterThrowing...");
    }

}
