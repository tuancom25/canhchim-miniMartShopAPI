package com.canhchim.martapi.module.role;

import java.util.List;

public interface IRelUsersFunctionService {
    List<String> findFunctionNamesByUser_Id(Long userId);
}
