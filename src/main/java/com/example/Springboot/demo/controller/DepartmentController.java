package com.example.Springboot.demo.controller;

import com.example.Springboot.demo.entity.Department;
import com.example.Springboot.demo.error.DepartmentNotFoundException;
import com.example.Springboot.demo.error.FieldEmptyException;
import com.example.Springboot.demo.error.NameNotFoundException;
import com.example.Springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    private Department saveDepartment(@Valid @RequestBody Department department) throws FieldEmptyException {
        logger.info("inside saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    private List<Department> fetchDepartments() {
        logger.info("inside fetchDepartments");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/department/{id}")
    private Department fetchDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException {
        logger.info("inside fetchDepartmentById");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("department/{id}")
    private String deleteDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException {
        logger.info("inside deleteDepartmentById");
        departmentService.deleteDepartmentById(departmentId);
        return "department successfully deleted";
    }

    @PutMapping("department/{id}")
    private Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        logger.info("inside updateDepartmentById");
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/department/name/{name}")
    private Department getDepartmentByDepartmentName(@PathVariable("name") String departmentName)
    throws NameNotFoundException {
        logger.info("inside getDepartmentByDepartmentName");
        return departmentService.getDepartmentByDepartmentName(departmentName);
    }
}
