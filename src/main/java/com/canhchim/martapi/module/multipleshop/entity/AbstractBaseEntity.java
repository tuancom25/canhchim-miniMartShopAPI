package com.canhchim.martapi.module.multipleshop.entity;

import com.canhchim.martapi.module.multipleshop.listener.ShopListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FilterDef(name = "shopFilter", parameters = {@ParamDef(name = "shopId", type = "integer")})
@Filter(name = "shopFilter", condition = "shop_id = :shopId")
@EntityListeners(ShopListener.class)
public class AbstractBaseEntity implements IShopAware, Serializable {
    private static final long serialVersionUID = 1L;

    //    @Size(max = 30)
    @Column(name = "shop_id")
    private Integer shopId;

    public AbstractBaseEntity(Integer shopId) {
        this.shopId = shopId;
    }
}
