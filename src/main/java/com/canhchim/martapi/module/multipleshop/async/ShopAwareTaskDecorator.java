package com.canhchim.martapi.module.multipleshop.async;

import com.canhchim.martapi.module.multipleshop.util.ShopContext;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;

public class ShopAwareTaskDecorator implements TaskDecorator {

    @Override
    @NonNull
    public Runnable decorate(@NonNull Runnable runnable) {
        Integer shopId = ShopContext.getShopId();
        return () -> {
            try {
                ShopContext.setShopId(shopId);
                runnable.run();
            } finally {
                ShopContext.setShopId(null);
            }
        };
    }
}