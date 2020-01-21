package com.cathay.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cathay.homework.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.departmentName = ?1")
    Department findByDepartmentName(String departmentName);
}
