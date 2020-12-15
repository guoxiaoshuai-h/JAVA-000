package com.learn.dynamic.sbmybatis.datasource.aop;

import com.learn.dynamic.sbmybatis.datasource.DynamicDataSource;
import com.learn.dynamic.sbmybatis.util.DataSourceConst;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-12-14 13:53
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.learn.dynamic.sbmybatis.datasource.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        DynamicDataSource.setDataSource(DataSourceConst.secondary.name());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
