package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 13:29
 * @description 权限实体类
 * @className Menu
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_menu")
public class Menu {
    @Id
    private int menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "update_date")
    private String menuUpdateDate;
    @Column(name = "create_date")
    private String menuCreateDate;
    @Column(name = "creator")
    private String menuCreator;
    @Column(name = "status")
    private int menuStatus;
    @Column(name = "version")
    private String menuVersion;
    @Column(name = "update_person")
    private String menuUpdatePerson;
    @Column(name = "parent_id")
    private int menuParentId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUpdateDate() {
        return menuUpdateDate;
    }

    public void setMenuUpdateDate(String menuUpdateDate) {
        this.menuUpdateDate = menuUpdateDate;
    }

    public String getMenuCreateDate() {
        return menuCreateDate;
    }

    public void setMenuCreateDate(String menuCreateDate) {
        this.menuCreateDate = menuCreateDate;
    }

    public String getMenuCreator() {
        return menuCreator;
    }

    public void setMenuCreator(String menuCreator) {
        this.menuCreator = menuCreator;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuVersion() {
        return menuVersion;
    }

    public void setMenuVersion(String menuVersion) {
        this.menuVersion = menuVersion;
    }

    public String getMenuUpdatePerson() {
        return menuUpdatePerson;
    }

    public void setMenuUpdatePerson(String menuUpdatePerson) {
        this.menuUpdatePerson = menuUpdatePerson;
    }

    public int getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(int menuParentId) {
        this.menuParentId = menuParentId;
    }
}
