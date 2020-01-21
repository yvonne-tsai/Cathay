package com.cathay.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.homework.entity.Department;
import com.cathay.homework.exception.ApiErrorException;
import com.cathay.homework.service.DepartmentService;
import com.cathay.homework.model.DepartmentRequest;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        try {
            Department department = new Department(departmentRequest.getDepartmentName());
            departmentService.createDepartment(department);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(
        @PathVariable(name = "departmentId") Long departmentId,
        @RequestBody DepartmentRequest departmentRequest) {
        try {
            departmentService.updateDepartment(departmentId, departmentRequest);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDepartment(
        @PathVariable(name = "departmentId") Long departmentId) {
        try {
            departmentService.deleteDepartment(departmentId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiErrorException(e.getMessage());
        }
    }
}
