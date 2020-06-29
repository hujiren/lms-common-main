package com.apl.lms.common.manage.aop;

import com.apl.lib.constants.CommonAplConstants;
import com.apl.lib.datasource.DataSourceContextHolder;
import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lib.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;


@Aspect
@Component
@Slf4j
public class DatasourceAop {


    @Autowired
    RedisTemplate redisTemplate;

    @Pointcut("execution(public * com.apl.lms.common.manage.controller.*.* (..))")
    public void datasourceAop() {
    }

    @Around("datasourceAop()")
    public Object doInvoke(ProceedingJoinPoint pjp) throws Throwable {

        Object proceed = null;
        try {
            String token = CommonContextHolder.getHeader(CommonAplConstants.TOKEN_FLAG);
            if(StringUtil.isEmpty(token)){
                Map<String, String[]> urlParams = CommonContextHolder.getRequest().getParameterMap();
                String[] arr = urlParams.get("token");
                if(arr.length>0)

                    token = arr[0];
            }
            SecurityUser securityUser = CommonContextHolder.getSecurityUser(redisTemplate, token);

            CommonContextHolder.securityUserContextHolder.set(securityUser);

            DataSourceContextHolder.set(securityUser.getTenantGroup(), securityUser.getInnerOrgCode(), securityUser.getInnerOrgId());

            Object[] args = pjp.getArgs();
            proceed = pjp.proceed(args);

        } catch (Throwable e) {
            //log.error(this.getClass().getName()+".doInvoke "+ e.getMessage());
            //throw new AplException(ExceptionEnum.SYSTEM_ERROR);
            throw e;
        } finally {
            CommonContextHolder.securityUserContextHolder.remove();
            CommonContextHolder.tokenContextHolder.remove();
            DataSourceContextHolder.clear();
        }

        return proceed;
    }


}
