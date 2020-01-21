package com.cathay.homework.IService;

import com.cathay.homework.entity.Department;
import com.cathay.homework.model.DepartmentRequest;

public interface IDepartmentService {

    public void createDepartment (Department pojo) throws Exception;

    public void updateDepartment (Long departmentId, DepartmentRequest departmentRequest) throws Exception;

    public void deleteDepartment (Long departmentId) throws Exception;
}
