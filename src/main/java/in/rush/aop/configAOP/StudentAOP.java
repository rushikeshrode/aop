package in.rush.aop.configAOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class StudentAOP {

    // executes before every method calls in StudentController
    @Before("execution(* in.rush.aop.controller.StudentController.*(..))")
    public void logBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("StudentAOP.class :: Method called 🔄 " + methodName);
    }

    // executes after every method calls in StudentController
    // acts like finally block: executes irrespective of method success/failure
    @After("execution(* in.rush.aop.controller.StudentController.*(..))")
    public void logAfter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("StudentAOP.class :: Method executed 📢 " + methodName);
    }

    // executes after successful run of : retrieveStudentById()
    @AfterReturning("execution(* in.rush.aop.controller.StudentController.retrieveStudentById(..))")
    public void logAfterMethodSuccess(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("StudentAOP.class :: Method executed SUCCESS ✅ " + methodName);
    }

    // executes only after method throws exception. method : deleteStudentById()
    @AfterThrowing("execution(* in.rush.aop.controller.StudentController.deleteStudentById(..))")
    public void logAfterMethodThrowsError(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("StudentAOP.class :: Method executed FAILED 📛 " + methodName);
    }

}
