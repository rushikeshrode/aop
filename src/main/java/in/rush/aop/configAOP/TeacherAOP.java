package in.rush.aop.configAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TeacherAOP {

    // executes between the method-call. method needs an explicit calling : pjp.proceed()

    @Around("execution(* in.rush.aop.controller.TeacherController.*(..))")
    public String logAround(ProceedingJoinPoint proceedingJoinPoint)  {

        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("TeacherAOP.class :: RUNNING... 🌐 " + methodName);

        try {
//            int tryingError = 3/0;
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            return "Error while executing ❌ : " + methodName;
        }
        return "TeacherAOP.class :: Method executed SUCCESS 🌐 " + methodName;
    }

}
