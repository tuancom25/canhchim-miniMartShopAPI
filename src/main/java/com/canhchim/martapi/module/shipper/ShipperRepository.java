package com.canhchim.martapi.module.shipper;

import com.canhchim.martapi.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}