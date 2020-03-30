package at.aau.aspect;

import org.apache.commons.logging.impl.Log4JLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


 @Aspect
 @Component
 public class CustomerCRUDAspect {

    @Pointcut("execution(public * at.aau.dao.ICustomerDao.*(..))")
    private void anyDaoOperation() {}

    @Before("anyDaoOperation()")
    public void getFindAllAdvice(JoinPoint joinPoint){
        System.out.println("--------- START: "  +joinPoint.getSignature().getName());
    }

    @After("anyDaoOperation()")
    public void getAllAdvice(JoinPoint joinPoint){
        System.out.println("--------- END: "  +joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* at.aau.dao.ICustomerDao.*(..))", throwing="ex")
    public void doRecoveryActions(JoinPoint joinPoint,Exception ex) {
        System.err.println("--------- ERROR: "+ ex.getClass().getCanonicalName() +
                " at "+ joinPoint.getSignature());
    }

    @Around("execution(* at.aau.presenter.UIPresenter.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("--------- EXECUTION TIME: "+(end-start)+" milliseconds " +pjp.toShortString());
        return retVal;
    }
 }

