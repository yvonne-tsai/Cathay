package com.cathay.homework.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cathay.homework.entity.Employee;
import com.cathay.homework.model.EmployeeDept;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
//    @Query("SELECT new com.cathay.homework.model.EmployeeDept(e.id, e.name, e.departmentId, e.sex, e.telephone, e.address, e.age, e.createTime, e.updateTime, d.departmentName) FROM Employee e "
//        + "LEFT JOIN Department d ON e.departmentId = d.departmentId "
//        + "WHERE (:name is null or e.name = :name) and (:id is null or e.id = :id) "
//        + "and (:age is null or e.age = :age) and (:departmentName is null or d.departmentName = :departmentName)")
//    List<EmployeeDept> findEmployeeByConditions(@Param("name") String name, @Param("id") Long id, @Param("age") Integer age, @Param("departmentName") String departmentName);

    @Query("SELECT new com.cathay.homework.model.EmployeeDept(e.id, e.name, e.departmentId, e.sex, e.telephone, e.address, e.age, e.createTime, e.updateTime, d.departmentName) FROM Employee e "
        + "LEFT JOIN Department d ON e.departmentId = d.departmentId "
        + "WHERE (:name is null or e.name = :name) and (:id is null or e.id = :id) "
        + "and (:age is null or e.age = :age) and (:departmentName is null or d.departmentName = :departmentName)")
    Page<EmployeeDept> findEmployeeByConditions(@Param("name") String name, @Param("id") Long id, @Param("age") Integer age, @Param("departmentName") String departmentName, Pageable pageable);
}
