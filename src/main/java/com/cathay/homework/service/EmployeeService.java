package com.cathay.homework.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cathay.homework.IService.IEmployeeService;
import com.cathay.homework.entity.Department;
import com.cathay.homework.entity.Employee;
import com.cathay.homework.model.EmployeeDept;
import com.cathay.homework.model.EmployeeRequest;
import com.cathay.homework.repository.DepartmentRepository;
import com.cathay.homework.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addEmployee (Employee pojo) throws Exception {
        if (pojo.getName() == null || pojo.getName().isEmpty()) {
            throw new Exception("Please enter the name");
        }
        // check department ID is valid or not
        Optional<Department> department = departmentRepository.findById(pojo.getDepartmentId());
        if (!department.isPresent()) {
            throw new Exception("Invalid department ID");
        }

        employeeRepository.save(pojo);
    }

    public void updateEmployee (Long employeeId, EmployeeRequest pojo) throws Exception {
        if (employeeId == null) {
            throw new Exception("Please enter the emplyee ID");
        }
        // check employee ID is valid or not
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new Exception("Invalid employee ID, can't find the employee");
        }

        if (pojo.getDepartmentId() != null && !pojo.getDepartmentId().equals(employee.get().getDepartmentId())) {
            employee.get().setDepartmentId(pojo.getDepartmentId());
        }
        if (pojo.getName() != null && !pojo.getName().equals(employee.get().getName())) {
            employee.get().setName(pojo.getName());
        }
        if (pojo.getSex() != null && !pojo.getSex().equals(employee.get().getSex())) {
            employee.get().setSex(pojo.getSex());
        }
        if (pojo.getTelephone() != null && !pojo.getTelephone().equals(employee.get().getTelephone())) {
            employee.get().setTelephone(pojo.getTelephone());
        }
        if (pojo.getAddress() != null && !pojo.getAddress().equals(employee.get().getAddress())) {
            employee.get().setAddress(pojo.getAddress());
        }
        if (pojo.getAge() != null && employee.get().getAge() != pojo.getAge()) {
            employee.get().setAge(pojo.getAge());
        }
        employee.get().setUpdateTime(new Timestamp(Instant.now().toEpochMilli()));
        employeeRepository.save(employee.get());
    }

    public void deleteEmployee (Long employeeId) throws Exception {
        // check employee ID is valid or not
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (!employee.isPresent()) {
            throw new Exception("Invalid employee ID, can't find the employee");
        }
        employeeRepository.deleteById(employeeId);
    }

    public List<EmployeeDept> findEmployeeByConditions (String name, Long id, Integer age, String departmentName, Integer page, Integer pageSize) throws Exception {
        if(pageSize > 10) {
            throw new Exception("The maximum of page size is 10");
        }
        Pageable paging = PageRequest.of(page, pageSize, Sort.by("id"));
        Page<EmployeeDept> result = employeeRepository.findEmployeeByConditions(name, id, age, departmentName, paging);
        return result.getContent();
    }
}
