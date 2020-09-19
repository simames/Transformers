package com.aequilibrium.transformer.service.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@Aspect
public class AuditLog {
    private static final Logger logger = LoggerFactory.getLogger(AuditLog.class);

    @Around(value = "execution(* com.aequilibrium.transformer.service.logic.*.*(..))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        long duration;

        String methodName = pjp.getSignature().getName();
        String className = pjp.getSignature().getDeclaringTypeName();
        String argsString = createArgsString(pjp.getArgs());

        Throwable retThrowable = null;
        Object retValue = null;
        String retValString = "";

        try {
            retValue = pjp.proceed();
            retValString = createReturnValueString(retValue);
            duration = System.currentTimeMillis() - start;
        } catch (Throwable throwable) {
            duration = System.currentTimeMillis() - start;
            retThrowable = throwable;
        }

        String methodFullName = className.concat(".").concat(methodName);
        String log = format("invoking transformer method: %s, args: %s, duration: %sms", methodFullName, argsString, duration);
        if (retThrowable == null) {
            if (retValString != null && !retValString.trim().isEmpty()) {
                log = format(log + "|result is: %s", retValString);
            }

            logger.info(log);
            return retValue;
        } else {
            logger.error(format(log + "|throws an exception: %s", retThrowable), retThrowable);
            throw retThrowable;
        }
    }

    private String createArgsString(Object[] args) {
        String argsString = "";
        if (args.length > 0) {
            for (Object arg : args) {
                if (arg != null)
                    argsString += "," + arg.getClass().getSimpleName() + ":" + arg.toString();
                else
                    argsString += ",null";
            }
            argsString = argsString.substring(1);
        }

        return argsString;
    }

    private String createReturnValueString(Object retVal) {
        String retValString = "";
        if (retVal != null) {
            retValString = retVal.getClass().getSimpleName();
            retValString += ":" + retVal.toString();
        }

        return retValString;
    }
}