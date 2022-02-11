package com.example.seller.support;

import com.example.seller.annotation.Cache;
import com.example.seller.annotation.CachePut;
import com.example.seller.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CacheImpl {

    @Autowired
    private CacheClient cacheClient;

    @Pointcut("@annotation(com.example.seller.annotation.Cache)")
    public void cacheMethod() {
    }

    @Pointcut("@annotation(com.example.seller.annotation.CachePut)")
    public void cachePutMethod() {
    }

    @Around("cacheMethod()")
    public Object aroundCache(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint == null) {
            return null;
        }
        Object value = cacheClient.getValue(getKey(joinPoint));
        if (value != null) {
            return value;
        }
        //执行当前被aop代理的方法
        Object proceed = joinPoint.proceed();//value 返回值
        System.out.println(proceed+"aaaaaaaaaaaaaaaaaa");
        /*从切面值入点获取植入点方法*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*获取切入点方法*/
        Method method = signature.getMethod();
        /*获取方法上的值*/
        Cache cache = method.getAnnotation(Cache.class);
        if (proceed == null) {
            proceed = new User();
        }
        cacheClient.putValue(getKey(joinPoint), proceed, cache.expire());
        return proceed;
    }

    @Around("cachePutMethod()")
    public Object aroundCachePut(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint == null) {
            return null;
        }
        Object proceed = joinPoint.proceed();
        /*从切面值入点获取植入点方法*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*获取切入点方法*/
        Method method = signature.getMethod();
        /*获取方法上的值*/
        CachePut cachePut = method.getAnnotation(CachePut.class);
        if (cachePut != null) {
            cacheClient.putValue(getKey(joinPoint), proceed, cachePut.expire());
        }
        return proceed;
    }


    /**
     * 根据参数生成cachekey
     *
     * @param joinPoint
     * @return
     */
    private String getKey(ProceedingJoinPoint joinPoint) {
        String clazzName = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        String result = clazzName + "_" + method;
        if (joinPoint.getArgs() == null) {
            return result;
        }
        for (Object key : joinPoint.getArgs()) {
            if (key != null) {
                result += "_" + key.toString();
            }
        }
        return result;
    }

}
