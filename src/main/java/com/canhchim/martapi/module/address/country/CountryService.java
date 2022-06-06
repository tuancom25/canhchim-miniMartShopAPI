package com.canhchim.martapi.module.address.country;

import com.canhchim.martapi.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    public Country findById(Integer id){
        return countryRepository.findById(1).orElse(null);
    }
}
