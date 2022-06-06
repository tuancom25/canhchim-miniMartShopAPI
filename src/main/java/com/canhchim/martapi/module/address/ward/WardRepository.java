package com.canhchim.martapi.module.address.ward;

import com.canhchim.martapi.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward, Integer> {
}