package com.canhchim.martapi.module.shipper;

import com.canhchim.martapi.entity.ShipCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipCompanyRepository extends JpaRepository<ShipCompany, Integer> {
}