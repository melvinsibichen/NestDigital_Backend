package com.example.NestDigitalBackend.dao;

import com.example.NestDigitalBackend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
