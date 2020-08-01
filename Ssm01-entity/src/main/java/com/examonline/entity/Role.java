package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/22 17:50
 * @description 角色表实体类
 * @className Role
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_role")
public class Role {

    @Id
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String roleDescription;
    @Column(name = "status")
    private int roleStatus;
    @Column(name = "create_date")
    private String roleCreateDate;
    @Column(name = "update_date")
    private String roleUpdateDate;
    @Column(name = "creator")
    private String roleCreator;
    @Column(name = "company_id")
    private int roleCompanyId;
    @Column(name = "update_person")
    private String roleUpdatePerson;
    @Column(name = "version")
    private String roleVersion;

    public int getRoleCompanyId() {
        return roleCompanyId;
    }

    public int getRoleId() {
        return roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(int roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleCreateDate() {
        return roleCreateDate;
    }

    public void setRoleCreateDate(String roleCreateDate) {
        this.roleCreateDate = roleCreateDate;
    }

    public String getRoleUpdateDate() {
        return roleUpdateDate;
    }

    public void setRoleUpdateDate(String roleUpdateDate) {
        this.roleUpdateDate = roleUpdateDate;
    }

    public String getRoleCreator() {
        return roleCreator;
    }

    public void setRoleCreator(String roleCreator) {
        this.roleCreator = roleCreator;
    }

    public void setRoleCompanyId(int roleCompanyId) {
        this.roleCompanyId = roleCompanyId;
    }

    public String getRoleUpdatePerson() {
        return roleUpdatePerson;
    }

    public void setRoleUpdatePerson(String roleUpdatePerson) {
        this.roleUpdatePerson = roleUpdatePerson;
    }

    public String getRoleVersion() {
        return roleVersion;
    }

    public void setRoleVersion(String roleVersion) {
        this.roleVersion = roleVersion;
    }

}
