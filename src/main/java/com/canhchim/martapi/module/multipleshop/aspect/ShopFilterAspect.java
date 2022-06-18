package com.canhchim.martapi.module.multipleshop.aspect;

import com.canhchim.martapi.module.multipleshop.util.ShopContext;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;

@Aspect
public class ShopFilterAspect {
    @Pointcut("execution (* org.hibernate.internal.SessionFactoryImpl.SessionBuilderImpl.openSession(..))")
    public void openSession() {
    }

    @AfterReturning(pointcut = "openSession()", returning = "session")
    public void afterOpenSession(Object session) {
        if (session != null && Session.class.isInstance(session)) {
            Integer shopId = ShopContext.getShopId();
            System.out.println(String.format("openSession %d", ShopContext.getShopId()));
            if (shopId != null) {
                System.out.println(shopId);
                org.hibernate.Filter filter = ((Session) session).enableFilter("shopFilter");
                filter.setParameter("shopId", shopId);
            }
        }
    }
}
