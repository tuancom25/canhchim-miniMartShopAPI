package com.canhchim.martapi.module.company.controller;

import com.canhchim.martapi.dto.ResponseDto;
import com.canhchim.martapi.dto.company.CompanyDto;
import com.canhchim.martapi.module.company.service.CompanyService;
import com.canhchim.martapi.util.PermissionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final PermissionUtil permissionUtil;
    ResponseDto responseDto = new ResponseDto();
    // Get all company
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "50") int size) {
        responseDto.setData(companyService.findAll(page, size));
        return ResponseEntity.ok(responseDto);
    }
    // Get company by id
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {
        responseDto.setData(companyService.findById(id));
        return ResponseEntity.ok(responseDto);
    }
    // Get company by shop id
    @GetMapping("/findByShopId/{id}")
    public ResponseEntity<?> findByShopId(@PathVariable("id") Integer id) throws Exception {
        responseDto.setData(companyService.findByShopId(id));
        return ResponseEntity.ok(responseDto);
    }
    // Create company
    @PostMapping("/create")
    public ResponseEntity<?> create(HttpServletRequest request,@Valid @RequestBody CompanyDto companyDto) {
        companyDto.setId(null);
        permissionUtil.getShopId(request);
        companyDto.setShopId(permissionUtil.getShopId(request));
        responseDto.setData(companyService.create(companyDto));
        return ResponseEntity.ok(responseDto);
    }
    // Update company
    @PutMapping("/update/")
    public ResponseEntity<?> update(HttpServletRequest request,@Valid @RequestBody CompanyDto companyDto) throws IOException {
        permissionUtil.acceptAction(request, "Company", "shop.id","id", companyDto.getId());
        companyDto.setShopId(permissionUtil.getShopId(request));
        responseDto.setData(companyService.update(companyDto));
        return ResponseEntity.ok(responseDto);
    }
    // Delete company
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(HttpServletRequest request,@Valid @RequestBody CompanyDto companyDto) throws IOException {
        permissionUtil.acceptAction(request, "Company", "shop.id","id", companyDto.getId());

        companyService.delete(companyDto.getId());
        return ResponseEntity.ok().build();
    }
}
