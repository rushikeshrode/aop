package in.rush.aop.configAOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TeacherAOP {

    // executes between the method-call. method needs an explicit calling & handling.
    // calling : proceedingJoinPoint.proceed(); @Around advice does not return the result of proceed().
    // handling : Return the actual response

    @Around("execution(* in.rush.aop.controller.TeacherController.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint)  {

        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("TeacherAOP.class :: RUNNING... 🔄 {}", methodName);

        Object response;
        try {
            response = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error("Error while executing ❌ : {}", methodName);
            return null;
        }
        log.info("TeacherAOP.class :: Method executed SUCCESS ✅ {}", methodName);
        return response;
    }

}
