package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:19
 * @descripiton 总公司实体类
 * @className Group
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_group")
public class Group {
    @Id
    private int groupId;
    @Column(name = "group_tax")
    private String groupTax;
    @Column(name = "group_email")
    private String groupEmail;
    @Column(name = "group_fax")
    private String groupFax;
    @Column(name = "group_website")
    private String groupWebsite;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_address")
    private String groupAddress;
    @Column(name = "legal_person")
    private String groupLegalPerson;
    @Column(name = "create_date")
    private String groupCreateDate;
    @Column(name = "update_date")
    private String groupUpdateDate;
    @Column(name = "status")
    private int groupStatus;
    @Column(name = "version")
    private String groupVersion;
    @Column(name = "creator")
    private String groupCreator;
    @Column(name = "update_person")
    private String groupUpdatePerson;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupTax() {
        return groupTax;
    }

    public void setGroupTax(String groupTax) {
        this.groupTax = groupTax;
    }

    public String getGroupEmail() {
        return groupEmail;
    }

    public void setGroupEmail(String groupEmail) {
        this.groupEmail = groupEmail;
    }

    public String getGroupFax() {
        return groupFax;
    }

    public void setGroupFax(String groupFax) {
        this.groupFax = groupFax;
    }

    public String getGroupWebsite() {
        return groupWebsite;
    }

    public void setGroupWebsite(String groupWebsite) {
        this.groupWebsite = groupWebsite;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAddress() {
        return groupAddress;
    }

    public void setGroupAddress(String groupAddress) {
        this.groupAddress = groupAddress;
    }

    public String getGroupLegalPerson() {
        return groupLegalPerson;
    }

    public void setGroupLegalPerson(String groupLegalPerson) {
        this.groupLegalPerson = groupLegalPerson;
    }

    public String getGroupCreateDate() {
        return groupCreateDate;
    }

    public void setGroupCreateDate(String groupCreateDate) {
        this.groupCreateDate = groupCreateDate;
    }

    public String getGroupUpdateDate() {
        return groupUpdateDate;
    }

    public void setGroupUpdateDate(String groupUpdateDate) {
        this.groupUpdateDate = groupUpdateDate;
    }

    public int getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(int groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getGroupVersion() {
        return groupVersion;
    }

    public void setGroupVersion(String groupVersion) {
        this.groupVersion = groupVersion;
    }

    public String getGroupCreator() {
        return groupCreator;
    }

    public void setGroupCreator(String groupCreator) {
        this.groupCreator = groupCreator;
    }

    public String getGroupUpdatePerson() {
        return groupUpdatePerson;
    }

    public void setGroupUpdatePerson(String groupUpdatePerson) {
        this.groupUpdatePerson = groupUpdatePerson;
    }
}
