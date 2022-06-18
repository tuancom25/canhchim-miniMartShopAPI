package com.canhchim.martapi.module.multipleshop.interceptor;

import com.canhchim.martapi.module.multipleshop.util.ShopContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class ShopInterceptor implements WebRequestInterceptor {
    public static final String X_SHOP_ID = "X-SHOP-ID";

    @Override
    public void preHandle(WebRequest request) {
        Object objShopId = request.getAttribute("X-SHOP-ID", RequestAttributes.SCOPE_REQUEST);
        if (objShopId != null) {
            Integer shopId = Integer.valueOf(objShopId.toString());
            System.out.println(String.format("Interceptor %d", shopId));
            ShopContext.setShopId(shopId);
        }
    }

    @Override
    public void postHandle(@NonNull WebRequest request, ModelMap model) {
        ShopContext.clear();
    }

    @Override
    public void afterCompletion(@NonNull WebRequest request, Exception ex) {
        // NOOP
    }
}
