package com.cathay.homework;

import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cathay.homework.entity.Department;
import com.cathay.homework.entity.Employee;
import com.cathay.homework.model.DepartmentRequest;
import com.cathay.homework.model.EmployeeRequest;
import com.cathay.homework.repository.DepartmentRepository;
import com.cathay.homework.repository.EmployeeRepository;
import com.cathay.homework.service.DepartmentService;
import com.cathay.homework.service.EmployeeService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentService departmentService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addEmployee() throws Exception {
        Employee employee = new Employee();
        Employee mockEmployee = spy(employee);
        mockEmployee.setName("test");

        Department department = new Department();
        department.setDepartmentName(Strings.EMPTY);
        Department mockDepartment = spy(department);
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(mockDepartment));

        assertEquals("test", mockEmployee.getName());
    }

    @Test
    public void updateEmployee() throws Exception {

        EmployeeRequest request = new EmployeeRequest();
        EmployeeRequest spyRequest = spy(request);
        spyRequest.setName("Man");

        Employee mockEmployee = spy(Employee.class);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(mockEmployee));

        Employee newExpectDept = new Employee();
        newExpectDept.setName("Man");
        newExpectDept.setId(1L);

        employeeService.updateEmployee(1L, spyRequest);
        when(employeeRepository.findById(newExpectDept.getId())).thenReturn(Optional.of(newExpectDept));
        assertEquals("Man", newExpectDept.getName());
    }

    @Test
    public void deleteEmployee() throws Exception {
        EmployeeService mockEmployeeService = mock(EmployeeService.class);
        doThrow(Exception.class).when(mockEmployeeService).deleteEmployee(1L);
    }

    @Test
    public void addDepartment() throws Exception {
        Department department = new Department();
        Department spyDepartment = spy(department);
        spyDepartment.setDepartmentName("test dept");

        when(departmentRepository.findByDepartmentName("test dept")).thenReturn(spyDepartment);

        assertEquals("test dept", spyDepartment.getDepartmentName());
    }

    @Test
    public void updateDepartment() throws Exception {

        DepartmentRequest request = new DepartmentRequest();
        DepartmentRequest spyRequest = spy(request);
        spyRequest.setDepartmentName("New Test Dept");
        spyRequest.setDepartmentId(1L);

        Department mockDepartment = mock(Department.class);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(mockDepartment));

        Department newExpectDept = new Department();
        newExpectDept.setDepartmentId(1L);
        newExpectDept.setDepartmentName("New Test Dept");

        departmentService.updateDepartment(1L, spyRequest);
        when(departmentRepository.findByDepartmentName(newExpectDept.getDepartmentName())).thenReturn(newExpectDept);
        assertEquals("New Test Dept", newExpectDept.getDepartmentName());
    }

    @Test
    public void deleteDepartment() throws Exception {
        DepartmentService mockDepartmentService = mock(DepartmentService.class);
        doThrow(Exception.class).when(mockDepartmentService).deleteDepartment(1L);
    }
}
