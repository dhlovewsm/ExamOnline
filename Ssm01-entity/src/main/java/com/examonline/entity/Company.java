package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.net.UnknownServiceException;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:02
 * @description 公司实体类
 * @className Company
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_company")
public class Company {
    @Id
    private int companyId;
    @Transient
    private List<Department> departmentList;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_fax")
    private String companyFax;
    @Column(name = "company_tax")
    private String companyTax;
    @Column(name = "company_website")
    private String companyWebsite;
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "group_id")
    private int companyGroupId;
    @Column(name = "company_address")
    private String companyAddress;
    @Column(name = "create_date")
    private String companyCreateDate;
    @Column(name = "update_date")
    private String companyUpdateDate;
    @Column(name = "legal_person")
    private String companyLegalPerson;
    @Column(name = "version")
    private String companyVersion;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyTax() {
        return companyTax;
    }

    public void setCompanyTax(String companyTax) {
        this.companyTax = companyTax;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public int getCompanyGroupId() {
        return companyGroupId;
    }

    public void setCompanyGroupId(int companyGroupId) {
        this.companyGroupId = companyGroupId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyCreateDate() {
        return companyCreateDate;
    }

    public void setCompanyCreateDate(String companyCreateDate) {
        this.companyCreateDate = companyCreateDate;
    }

    public String getCompanyUpdateDate() {
        return companyUpdateDate;
    }

    public void setCompanyUpdateDate(String companyUpdateDate) {
        this.companyUpdateDate = companyUpdateDate;
    }

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson;
    }

    public String getCompanyVersion() {
        return companyVersion;
    }

    public void setCompanyVersion(String companyVersion) {
        this.companyVersion = companyVersion;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
