package com.canhchim.martapi.module.multipleshop.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ShopContext {

    private ShopContext() {}

    private static final InheritableThreadLocal<Integer> currentShop = new InheritableThreadLocal<>();

    public static void setShopId(Integer shopId) {
        log.debug("Setting shopId to " + shopId);
        System.out.println(String.format("Setting shopId to %d", shopId));
        currentShop.set(shopId);
        System.out.println(String.format("Get shopId = %d", currentShop.get()));
    }

    public static Integer getShopId() {
        return currentShop.get();
    }

    public static void clear(){
        currentShop.remove();
    }
}