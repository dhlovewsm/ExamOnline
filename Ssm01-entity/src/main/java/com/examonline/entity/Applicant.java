package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 13:35
 * @descripiton 应聘人员的实体类
 * @className Applicant
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_applicant")
public class Applicant {
    /**
     * @descripiton 应聘者ID，主键
     */
    @Id
    private String applicantId;
    /**
     * @description 应聘者用户名，登陆使用
     */
    @Column(name = "applicant_account")
    private String applicantAccount;
    /**
     * @description 应聘者密码，登陆使用
     */
    @Column(name = "password")
    private String applicantPassword;
    /**
     * @description 应聘者姓名
     */
    @Column(name = "applicant_name")
    private String applicantName;
    /**
     * @description 应聘者手机号码
     */
    @Column(name = "applicant_phone")
    private String applicantPhone;
    /**
     * @description 应聘者性别
     */
    @Column(name = "applicant_sex")
    private String applicantSex;
    /**
     * @description 应聘者邮箱，注册使用
     */
    @Column(name = "applicant_email")
    private String applicantEmail;
    /**
     * @description 应聘者状态，0或1
     */
    @Column(name = "status")
    private int applicantStatus;
    /**
     * @description 应聘者信息最近更新日期
     */
    @Column(name = "update_date")
    private String applicantUpdateDate;
    /**
     * @description 应聘者添加者，后台留作备用
     */
    @Column(name = "creator")
    private String applicantCreator;
    /**
     * @description 应聘者注册或后台添加日期
     */
    @Column(name = "create_date")
    private String applicantCreateDate;
    /**
     * @description 应聘者乐观锁版本，留作备用
     */
    @Column(name = "version")
    private String applicantVersion;
    /**
     * @descripiton 应聘者信息修改人，后台修改留作备用
     */
    @Column(name = "update_person")
    private String applicantUpdatePerson;


    /**
     * @description 应聘者所有属性的get和set方法
     * @return
     */


    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantAccount() {
        return applicantAccount;
    }

    public void setApplicantAccount(String applicantAccount) {
        this.applicantAccount = applicantAccount;
    }

    public String getApplicantPassword() {
        return applicantPassword;
    }

    public void setApplicantPassword(String applicantPassword) {
        this.applicantPassword = applicantPassword;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantSex() {
        return applicantSex;
    }

    public void setApplicantSex(String applicantSex) {
        this.applicantSex = applicantSex;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public int getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(int applicantStatus) {
        this.applicantStatus = applicantStatus;
    }

    public String getApplicantUpdateDate() {
        return applicantUpdateDate;
    }

    public void setApplicantUpdateDate(String applicantUpdateDate) {
        this.applicantUpdateDate = applicantUpdateDate;
    }

    public String getApplicantCreator() {
        return applicantCreator;
    }

    public void setApplicantCreator(String applicantCreator) {
        this.applicantCreator = applicantCreator;
    }

    public String getApplicantCreateDate() {
        return applicantCreateDate;
    }

    public void setApplicantCreateDate(String applicantCreateDate) {
        this.applicantCreateDate = applicantCreateDate;
    }

    public String getApplicantVersion() {
        return applicantVersion;
    }

    public void setApplicantVersion(String applicantVersion) {
        this.applicantVersion = applicantVersion;
    }

    public String getApplicantUpdatePerson() {
        return applicantUpdatePerson;
    }

    public void setApplicantUpdatePerson(String applicantUpdatePerson) {
        this.applicantUpdatePerson = applicantUpdatePerson;
    }
}
