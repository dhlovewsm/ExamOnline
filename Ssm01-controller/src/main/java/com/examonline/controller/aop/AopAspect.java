package com.examonline.controller.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/9 17:47
 * @className AopAspect
 * @packageName com.examonline.controller.aop
 * @description 切面，捕获异常
 * @copyright(C) www.bosssoft.com.cn
 */

@Component
@Aspect
public class AopAspect {
    
    private Logger logger = LoggerFactory.getLogger(AopAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")//连接点是@RequestMapping注解的方法
    private void webPointcut() {}

    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")//切点在webpointCut()
    public void handleThrowing(JoinPoint joinPoint, Exception e) {//controller类抛出的异常在这边捕获
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //开始打log
        logger.info("异常:" + e.getMessage());
        logger.info("异常所在类：" + className);
        logger.info("异常所在方法：" + methodName);
        logger.info("异常中的参数：");
        logger.info(methodName);
        for (int i = 0; i < args.length; i++) {
            logger.info(args[i].toString());
        }
    }


    @Before("execution(* com.examonline.controller.*.*(..))")
    public void beforeProcess(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //在项目中最好记录当前操作的时间和用户
        logger.info("操作所在类：" + className);
        logger.info("操作所在方法：" + methodName);
        logger.info("操作中的参数：");
        for (int i = 0; i < args.length; i++) {
            logger.info(args[i].toString());
        }
    }

    @AfterReturning(value = "execution(* com.examonline.controller.*.*(..)))", returning = "returnVal")
    public void returnProcess(JoinPoint joinPoint, Object returnVal) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Class targetClass = null;
        String operationName = "";
        try {
            targetClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs != null && clazzs.length == args.length&&
                        method.getAnnotation(ArchivesLog.class)!=null) {
                    //这块是取出我们注解ArchiveLog中的值,一遍在日志时明确这个操作的名称
                    operationName = method.getAnnotation(ArchivesLog.class).operationName();
                    break;
                }
            }
        }
        logger.info("操作名称：" + operationName);
        logger.info("方法正常返回的值：" + returnVal);
    }
}
