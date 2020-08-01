package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/22 16:52
 * @decription 系统用户角色表实体类
 * @className UserRole
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_user_role")
public class UserRole {
    @Id
    private int userRoleId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "create_date")
    private String userRoleCreateDate;
    @Column(name = "update_date")
    private String userRoleUpdateDate;
    @Column(name = "creator")
    private String userRoleCreator;
    @Column(name = "status")
    private int userRoleStatus;
    @Column(name = "version")
    private String userRoleVersion;
    @Column(name = "update_person")
    private String userRoleUpdatePerson;

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserRoleCreateDate() {
        return userRoleCreateDate;
    }

    public void setUserRoleCreateDate(String userRoleCreateDate) {
        this.userRoleCreateDate = userRoleCreateDate;
    }

    public String getUserRoleUpdateDate() {
        return userRoleUpdateDate;
    }

    public void setUserRoleUpdateDate(String userRoleUpdateDate) {
        this.userRoleUpdateDate = userRoleUpdateDate;
    }

    public String getUserRoleCreator() {
        return userRoleCreator;
    }

    public void setUserRoleCreator(String userRoleCreator) {
        this.userRoleCreator = userRoleCreator;
    }

    public int getUserRoleStatus() {
        return userRoleStatus;
    }

    public void setUserRoleStatus(int userRoleStatus) {
        this.userRoleStatus = userRoleStatus;
    }

    public String getUserRoleVersion() {
        return userRoleVersion;
    }

    public void setUserRoleVersion(String userRoleVersion) {
        this.userRoleVersion = userRoleVersion;
    }

    public String getUserRoleUpdatePerson() {
        return userRoleUpdatePerson;
    }

    public void setUserRoleUpdatePerson(String userRoleUpdatePerson) {
        this.userRoleUpdatePerson = userRoleUpdatePerson;
    }
}
