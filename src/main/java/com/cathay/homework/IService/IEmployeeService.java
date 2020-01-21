package com.cathay.homework.IService;

import java.util.List;

import com.cathay.homework.entity.Employee;
import com.cathay.homework.model.EmployeeDept;
import com.cathay.homework.model.EmployeeRequest;

public interface IEmployeeService {

    public void addEmployee(Employee pojo) throws Exception;

    public void updateEmployee (Long employeeId, EmployeeRequest pojo) throws Exception;

    public void deleteEmployee (Long employeeId) throws Exception;

    public List<EmployeeDept> findEmployeeByConditions (String name, Long id, Integer age, String departmentName, Integer page, Integer pageSize) throws Exception;
}
