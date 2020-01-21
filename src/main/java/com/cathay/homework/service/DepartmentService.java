package com.cathay.homework.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathay.homework.IService.IDepartmentService;
import com.cathay.homework.entity.Department;
import com.cathay.homework.model.DepartmentRequest;
import com.cathay.homework.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void createDepartment (Department pojo) throws Exception {
        Department department = departmentRepository.findByDepartmentName(pojo.getDepartmentName());
        if (department != null) {
            throw new Exception("Department name has already existed.");
        }
        departmentRepository.save(pojo);
    }

    public void updateDepartment (Long departmentId, DepartmentRequest departmentRequest) throws Exception {
        if (departmentRequest.getDepartmentName() == null || departmentRequest.getDepartmentName().isEmpty()) {
            throw new Exception("Please enter the department name");
        }
        // check department ID is valid or not
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new Exception("Invalid department ID, can't find the department");
        }
        if (departmentRequest.getDepartmentName().equals(department.get().getDepartmentName())) {
            throw new Exception("Duplicate department name, please change another one.");
        }
        department.get().setDepartmentName(departmentRequest.getDepartmentName());
        departmentRepository.save(department.get());
    }

    public void deleteDepartment (Long departmentId) throws Exception {
        // check department ID is valid or not
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new Exception("Invalid department ID, can't find the department");
        }
        departmentRepository.deleteById(departmentId);
    }
}
