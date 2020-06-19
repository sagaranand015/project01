package com.ipsoft.demo.repositories;

import com.ipsoft.demo.models.Employees;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends PagingAndSortingRepository<Employees, String> {



}
