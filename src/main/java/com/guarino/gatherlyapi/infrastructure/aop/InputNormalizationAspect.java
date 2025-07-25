package com.guarino.gatherlyapi.infrastructure.aop;

import com.guarino.gatherlyapi.infrastructure.web.validation.NormalizeEmail;
import com.guarino.gatherlyapi.infrastructure.web.validation.TrimString;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class InputNormalizationAspect {

    private static final Logger logger = LoggerFactory.getLogger(InputNormalizationAspect.class);

    @Pointcut("within(com.guarino.gatherlyapi.infrastructure.web.controller..*)")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void normalizeRequestInputs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg != null) {
                processObject(arg);
            }
        }
    }

    private void processObject(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(String.class)) {
                try {
                    field.setAccessible(true);
                    String originalValue = (String) field.get(obj);
                    if (originalValue != null) {
                        String processedValue = originalValue;

                        if (field.isAnnotationPresent(TrimString.class)) {
                            processedValue = processedValue.trim();
                        }

                        if (field.isAnnotationPresent(NormalizeEmail.class)) {
                            processedValue = processedValue.toLowerCase();
                        }
                        field.set(obj, processedValue);
                    }
                } catch (IllegalAccessException e) {
                    logger.error("Error during input normalization", e);
                }
            }
        }
    }
}