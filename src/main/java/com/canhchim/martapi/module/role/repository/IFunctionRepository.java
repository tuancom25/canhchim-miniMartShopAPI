package com.canhchim.martapi.module.role.repository;

import com.canhchim.martapi.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFunctionRepository extends JpaRepository<Function, Integer> {
}