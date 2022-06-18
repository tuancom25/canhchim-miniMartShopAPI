package com.canhchim.martapi.module.multipleshop.listener;

import com.canhchim.martapi.module.multipleshop.entity.IShopAware;
import com.canhchim.martapi.module.multipleshop.util.ShopContext;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ShopListener {
    @PreUpdate
    @PreRemove
    @PrePersist
    public void setShop(IShopAware entity) {
        final Integer shopId = ShopContext.getShopId();
        entity.setShopId(shopId);
    }
}
