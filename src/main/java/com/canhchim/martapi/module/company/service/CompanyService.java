package com.canhchim.martapi.module.company.service;

import com.canhchim.martapi.dto.company.CompanyDto;
import com.canhchim.martapi.entity.Company;
import com.canhchim.martapi.module.categories.convert.Convert;
import com.canhchim.martapi.module.company.repository.CompanyRepository;
import com.canhchim.martapi.util.MessageConstants;
import com.canhchim.martapi.util.MessagesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final Convert convert;
    private final MessagesUtils messagesUtils;

    // Get all company
    public List<CompanyDto> findAll(int page, int size) {
        List<Company> companyList = companyRepository.findAllCompany(PageRequest.of(page,size)).toList();
        return companyList.stream().map(convert::convertCompanyToDto).collect(Collectors.toList());
    }
    // Get company by id
    public CompanyDto findById(Integer id) throws Exception {
        Optional<Company> OptionalCompany = companyRepository.findById(id);
        if (!OptionalCompany.isPresent()) {
            throw new Exception(messagesUtils.getMessage(MessageConstants.COMPANY_NOT_FOUND));
        }
        return convert.convertCompanyToDto(OptionalCompany.get());
    }
    public  Company findCompanyById(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }
    // Get all company by shop id
    public List<CompanyDto> findByShopId(Integer shopId) {
        List<Company> companyList = companyRepository.findByShopId(shopId);
        return companyList.stream().map(convert::convertCompanyToDto).collect(Collectors.toList());
    }
    // Create company
    public CompanyDto create(CompanyDto companyDto) {
        Company company = convert.convertCompanyDtoToEntity(companyDto);
        companyRepository.save(company);
        return convert.convertCompanyToDto(company);
    }
    // Update company
    public CompanyDto update(CompanyDto companyDto)  {
        Company oldCompany = findCompanyById(companyDto.getId());
        oldCompany =  companyRepository.save(convert.convertCompanyDtoToEntity(companyDto));

        return companyDto;
    }

    // Delete company
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }
}
