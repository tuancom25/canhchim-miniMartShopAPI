package com.canhchim.martapi.module.role;

import java.util.List;

public interface IRelEmployeesFunctionService {
    List<String> findFunctionNamesByEmployee_Id(Integer employeeId);
}
