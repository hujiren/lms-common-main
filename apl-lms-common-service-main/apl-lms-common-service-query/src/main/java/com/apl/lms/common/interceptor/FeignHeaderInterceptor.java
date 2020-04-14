package com.apl.lms.common.interceptor;

import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import com.apl.lib.utils.StringUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String token = CommonContextHolder.tokenContextHolder.get();
        if(StringUtil.isEmpty(token)) {
            token = CommonContextHolder.getHeader("token");
        }
        if(!StringUtil.isEmpty(token)) {
            template.header("token", token); //header添加token
        }

        SecurityUser securityUser = CommonContextHolder.getSecurityUser();
        if(securityUser!=null) {
            template.header("tenantGroup", securityUser.getTenantGroup());
            template.header("orgCode", securityUser.getInnerOrgCode());
        }
    }
}
