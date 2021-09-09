//package com.weiran.missionplanning.api.config;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * discription:
// */
//@Aspect
//@Component
//@Slf4j
//public class WebLogAspect {
//
//    private ThreadLocal<Long> startTime=new ThreadLocal<>();
//
//    //
//    @Pointcut("execution(public * com.weiran.jouavcloudmissionplanning.api.controller..*.*(..))")
//    public void webLog(){
//
//    }
//
//    @Before(value = "webLog()")
//    public void doBefore(JoinPoint point){
//        startTime.set(System.currentTimeMillis());
//
//        log.info("WebLogAspect.doBefore............");
//        ServletRequestAttributes attributes=
//                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if(attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            String ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//            log.info("IP : "+ ip);
//            log.info("URL : " + request.getRequestURL().toString());
//            log.info("HTTP_METHOD : " +request.getMethod());
//            log.info("CLASS_NAME : " + point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
//            log.info("ARGS : " + Arrays.toString(point.getArgs()));
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = authentication.getName();
//            log.info("USER : " + username);
//        }
//    }
//
//
//    @AfterReturning(value = "webLog()",returning = "ret")
//    public void doAferReturning(Object ret){
//        log.info("WebLogAspect.doAfterReturning.............");
//        log.info("Resp : " + JSON.toJSONString(ret));
//        log.info("Spend Time : " + (System.currentTimeMillis()-startTime.get()));
//    }
//}
