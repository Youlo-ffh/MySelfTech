package cc.fireflyhut.selftech.aspect;

import cc.fireflyhut.selftech.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ControllerAspect {

    /**
     * 增强模式的Around通知，它通过自定义的注解来匹配切入点
     * */
//    @Around(value = "@annotation(myAnnotation)")  // 注意这里的属性值要定义和方法参数一样的名字
//    public Object aroundByEnhance(ProceedingJoinPoint joinPoint, MyAnnotation myAnnotation) throws Throwable {
//        // 我们可以通过注解实例来获取到注解属性的值
//        System.out.println("Around..MyAnnotation..something：" + myAnnotation.something());
//        System.out.println("Around..Target Class：" + joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("Around..Target Class Name：" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println("Around..Target Method：" + joinPoint.getSignature());
//        System.out.println("Around..Target Method Name：" + joinPoint.getSignature().getName());
//        return joinPoint.proceed();
//    }

    // 常规使用方法增加一下内容

    /**
     * 通过切入点表达式定义切点
     * */
    @Pointcut(value = "execution(* cc.fireflyhut.selftech.controller.CommonController.*(..))")
    public void pointCut() {}

    /**
     * 常规模式的Around通知，它通过切入点表达式匹配目标方法
     * */
    @Around(value = "pointCut()")
    public Object arountByCommon(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Arount..Common..");
//        System.out.println("Around..Target Class：" + joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("Around..Target Class Name：" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println("Around..Target Method：" + joinPoint.getSignature());
//        System.out.println("Around..Target Method Name：" + joinPoint.getSignature().getName());

        //System.out.println("方法参数：" + Arrays.asList(joinPoint.getArgs()));

        return joinPoint.proceed();
    }

}
