package com.example.Springboot.demo.service;

import com.example.Springboot.demo.entity.Department;
import com.example.Springboot.demo.error.DepartmentNotFoundException;
import com.example.Springboot.demo.error.FieldEmptyException;
import com.example.Springboot.demo.error.NameNotFoundException;
import com.example.Springboot.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) throws FieldEmptyException {
        if (Objects.isNull(department) || "".equalsIgnoreCase(department.getDepartName())
                || "".equalsIgnoreCase(department.getDepartmentCode())
                || "".equalsIgnoreCase(department.getDepartmentAddress())
                || Objects.isNull(department.getDepartName()) || Objects.isNull(department.getDepartmentCode())
                || Objects.isNull(department.getDepartmentAddress())
        ) {
            throw new FieldEmptyException("Some Fields are empty");
        }
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department dptDb = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartName()) && !"".equalsIgnoreCase(department.getDepartName())) {
            dptDb.setDepartName(department.getDepartName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dptDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dptDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(dptDb);
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName) throws NameNotFoundException {

        Department department = departmentRepository.findByDepartNameIgnoreCase(departmentName);
        if (Objects.isNull(department)) {
            throw new NameNotFoundException("Name Not Found in the records");
        }
        return department;
    }
}
