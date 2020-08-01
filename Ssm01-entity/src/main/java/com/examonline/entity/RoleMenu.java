package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 13:24
 * @description 角色权限表实体类
 * @className RoleMenu
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_role_menu")
public class RoleMenu {
    @Id
    private int roleMenuId;
    @Column(name = "menu_id")
    private int menuId;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "create_date")
    private String roleMenuCreateDate;
    @Column(name = "update_date")
    private String roleMenuUpdateDate;
    @Column(name = "creator")
    private String roleMenuCreator;
    @Column(name = "status")
    private int roleMenuStatus;
    @Column(name = "update_person")
    private String roleMenuUpdatePerson;
    @Column(name = "version")
    private String roleMenuVersion;

    public int getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(int roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleMenuCreateDate() {
        return roleMenuCreateDate;
    }

    public void setRoleMenuCreateDate(String roleMenuCreateDate) {
        this.roleMenuCreateDate = roleMenuCreateDate;
    }

    public String getRoleMenuUpdateDate() {
        return roleMenuUpdateDate;
    }

    public void setRoleMenuUpdateDate(String roleMenuUpdateDate) {
        this.roleMenuUpdateDate = roleMenuUpdateDate;
    }

    public String getRoleMenuCreator() {
        return roleMenuCreator;
    }

    public void setRoleMenuCreator(String roleMenuCreator) {
        this.roleMenuCreator = roleMenuCreator;
    }

    public int getRoleMenuStatus() {
        return roleMenuStatus;
    }

    public void setRoleMenuStatus(int roleMenuStatus) {
        this.roleMenuStatus = roleMenuStatus;
    }

    public String getRoleMenuUpdatePerson() {
        return roleMenuUpdatePerson;
    }

    public void setRoleMenuUpdatePerson(String roleMenuUpdatePerson) {
        this.roleMenuUpdatePerson = roleMenuUpdatePerson;
    }

    public String getRoleMenuVersion() {
        return roleMenuVersion;
    }

    public void setRoleMenuVersion(String roleMenuVersion) {
        this.roleMenuVersion = roleMenuVersion;
    }
}
