package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:10、
 * @description 部门实体类
 * @className Department
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_department")
public class Department {
    @Id
    private int departmentId;
    @Transient
    private List<User> userList;
    @Transient
    private List<Applicant> applicantList;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "leader_name")
    private String departmentLeaderName;
    @Column(name = "department_address")
    private String departmentAddress;
    @Column(name = "create_date")
    private String departmentCreateDate;
    @Column(name = "update_date")
    private String departmentUpdateDate;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "status")
    private int departmentStatus;
    @Column(name = "version")
    private String departmentVersion;
    @Column(name = "parent_id")
    private int departmentParentId;
    @Column(name = "creator")
    private String departmentCreator;
    @Column(name = "update_person")
    private String departmentUpdatePerson;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLeaderName() {
        return departmentLeaderName;
    }

    public void setDepartmentLeaderName(String departmentLeaderName) {
        this.departmentLeaderName = departmentLeaderName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCreateDate() {
        return departmentCreateDate;
    }

    public void setDepartmentCreateDate(String departmentCreateDate) {
        this.departmentCreateDate = departmentCreateDate;
    }

    public String getDepartmentUpdateDate() {
        return departmentUpdateDate;
    }

    public void setDepartmentUpdateDate(String departmentUpdateDate) {
        this.departmentUpdateDate = departmentUpdateDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(int departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public String getDepartmentVersion() {
        return departmentVersion;
    }

    public void setDepartmentVersion(String departmentVersion) {
        this.departmentVersion = departmentVersion;
    }

    public int getDepartmentParentId() {
        return departmentParentId;
    }

    public void setDepartmentParentId(int departmentParentId) {
        this.departmentParentId = departmentParentId;
    }

    public String getDepartmentCreator() {
        return departmentCreator;
    }

    public void setDepartmentCreator(String departmentCreator) {
        this.departmentCreator = departmentCreator;
    }

    public String getDepartmentUpdatePerson() {
        return departmentUpdatePerson;
    }

    public void setDepartmentUpdatePerson(String departmentUpdatePerson) {
        this.departmentUpdatePerson = departmentUpdatePerson;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<Applicant> applicantList) {
        this.applicantList = applicantList;
    }
}
