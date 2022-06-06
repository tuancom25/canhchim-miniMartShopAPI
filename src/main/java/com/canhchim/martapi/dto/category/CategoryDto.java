package com.canhchim.martapi.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {
    private Integer id;
    private String name;
    private Integer categoryParent;
    private Integer categoryGroupId;
    private String comment;
    private String imageLink;
    private Integer shopId;

}
