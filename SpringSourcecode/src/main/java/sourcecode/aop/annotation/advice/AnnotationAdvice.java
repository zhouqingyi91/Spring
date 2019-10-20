package sourcecode.aop.annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAdvice {

    public static final String POINTCUT = "execution(* sourcecode.aop.target.UserServiceImpl.*(..))";

    @Around(POINTCUT)
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知---前置通知");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("环绕通知---异常抛出配置");
            e.printStackTrace();
        }
        System.out.println("环绕通知---后置通知");
    }

    @Before(POINTCUT)
    public void before() {
        System.out.println("前置通知...");
    }

    @After(POINTCUT)
    public void after() {
        System.out.println("最终通知...");
    }



}
