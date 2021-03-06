package com.cristian.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    ArrayList<Company> findByName(String name);
}

