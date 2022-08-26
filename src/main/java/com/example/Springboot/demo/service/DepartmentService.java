package com.example.Springboot.demo.service;

import com.example.Springboot.demo.entity.Department;
import com.example.Springboot.demo.error.DepartmentNotFoundException;
import com.example.Springboot.demo.error.FieldEmptyException;
import com.example.Springboot.demo.error.NameNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department) throws FieldEmptyException;

    List<Department> fetchDepartments();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByDepartmentName(String departmentName) throws NameNotFoundException;
}
