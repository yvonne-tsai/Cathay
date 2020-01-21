package com.cathay.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.homework.entity.Employee;
import com.cathay.homework.exception.ApiErrorException;
import com.cathay.homework.model.EmployeeDept;
import com.cathay.homework.model.EmployeeRequest;
import com.cathay.homework.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            Employee employee = new Employee();
            employee.setName(employeeRequest.getName());
            employee.setAddress(employeeRequest.getAddress());
            employee.setAge(employeeRequest.getAge());
            employee.setSex(employeeRequest.getSex());
            employee.setTelephone(employeeRequest.getTelephone());
            employee.setDepartmentId(employeeRequest.getDepartmentId());
            employeeService.addEmployee(employee);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PATCH)
    public ResponseEntity updateEmployee(
        @PathVariable(name = "employeeId") Long employeeId,
        @RequestBody EmployeeRequest employeeRequest) {
        try {
            employeeService.updateEmployee(employeeId, employeeRequest);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(
        @PathVariable(name = "employeeId") Long employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Employee> findEmployees(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "age", required = false) Integer age,
        @RequestParam(value = "departmentName", required = false) String departmentName,
        @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        try {
            List<EmployeeDept> list = employeeService.findEmployeeByConditions(name, id, age, departmentName, page, pageSize);
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
    }
}
