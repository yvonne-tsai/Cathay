package com.cathay.homework.model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDept implements Serializable {

    private Long id;

    private String name;

    private Long departmentId;

    private String sex;

    private String telephone;

    private String address;

    private Integer age;

    private Date createTime;

    private Date updateTime;

    private String departmentName;

    public EmployeeDept(Long id, String name, Long departmentId, String sex, String telephone, String address, Integer age, Date createTime, Date updateTime,
        String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.sex = sex;
        this.telephone = telephone;
        this.address = address;
        this.age = age;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
