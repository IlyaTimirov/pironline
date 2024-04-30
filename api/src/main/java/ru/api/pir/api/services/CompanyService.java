package ru.api.pir.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.api.pir.api.dto.CompanyDto;
import ru.api.pir.api.exceptions.CompanyNotFoundException;
import ru.api.pir.api.models.Company;
import ru.api.pir.api.repositories.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void save(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setInn(companyDto.getInn());
        companyRepository.save(company);
    }

    public Company findByName(String name){
        return companyRepository.findByName(name).orElseThrow(CompanyNotFoundException::new);
    }
}
