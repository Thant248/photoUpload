package com.example.exclefile.model.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.exclefile.model.enitty.Employee;

public interface EmployeeReposiotry extends JpaRepositoryImplementation<Employee, Integer>{
}