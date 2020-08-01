package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.lang.String;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 13:24
 * @description 系统用户实体类
 * @className User
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_account")
    private String userAccount;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_number")
    private String userNumber;
    @Column(name = "user_identity")
    private String userIdentity;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "create_date")
    private String userCreateDate;
    @Column(name = "update_date")
    private String userUpdateDate;
    @Column(name = "creator")
    private String userCreator;
    @Column(name = "version")
    private String userVersion;
    @Column(name = "status")
    private int userStatus;
    @Column(name = "update_person")
    private String userUpdatePerson;
    @Transient
    private Department department;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public String getUserCreator() {
        return userCreator;
    }

    public String getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public void setUserCreator(String userCreator) {
        this.userCreator = userCreator;
    }

    public void setUserUpdateDate(String userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public String getUserUpdatePerson() {
        return userUpdatePerson;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public void setUserUpdatePerson(String userUpdatePerson) {
        this.userUpdatePerson = userUpdatePerson;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
