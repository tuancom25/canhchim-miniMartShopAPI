/**
 * @Author: Duong Ngo Nam Anh
 */

package com.canhchim.martapi.module.function;

import com.canhchim.martapi.entity.Function;

import java.util.List;

public interface IFunctionService {
    /**
     * Tìm tất cả các Function
     * @return
     */
    List<Function> findAll();

    /**
     * Tìm danh sách tên Function theo danh sách Id
     * @param ids
     * @return
     */
    List<String> findFunction_nameById(List<Integer> ids);
}
