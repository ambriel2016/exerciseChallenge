package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... strings) throws Exception{
        Company company1;
        company1 = new Company(1, "Arrow Electronics", "Centennial", "20,100.00");
        companyRepository.save(company1);

        Company company2 = new Company(2, "Ball Corporation", "Broomfield", "18,000.00");
        companyRepository.save(company2);

        Company company3 = new Company(3, "Cherwell Software", "Colorado Springs", "250");
        companyRepository.save(company3);

        Company company4 = new Company(4, "DigitalGlobe", "Westminster", "300");
        companyRepository.save(company4);

        Company company5 = new Company(5, "elope, Inc", "Colorado Springs", "55");
        companyRepository.save(company5);
    }
}