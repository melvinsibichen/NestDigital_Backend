package com.example.NestDigitalBackend.controller;

import com.example.NestDigitalBackend.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao empdao;
@GetMapping("/")
    public String HomeRoute()
    {
    return "welcome to nest app";
    }
}

