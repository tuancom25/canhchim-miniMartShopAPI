package com.canhchim.martapi.module.address.country;

import com.canhchim.martapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}