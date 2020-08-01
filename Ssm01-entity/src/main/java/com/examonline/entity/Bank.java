package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @version V1.0
 * @description 题库实体类
 * @author donghao
 * @date 2019/3/23 13:57
 * @className Bank
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_bank")
public class Bank {
    @Id
    private int bankId;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "creator")
    private String bankCreator;
    @Column(name = "update_date")
    private String bankUpdateDate;
    @Column(name = "create_date")
    private String bankCreateDate;
    @Column(name = "description")
    private String bankDescription;
    @Column(name = "status")
    private int bankStatus;
    @Column(name = "version")
    private String bankVersion;
    @Column(name = "update_person")
    private String bankUpdatePerson;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCreator() {
        return bankCreator;
    }

    public void setBankCreator(String bankCreator) {
        this.bankCreator = bankCreator;
    }

    public String getBankUpdateDate() {
        return bankUpdateDate;
    }

    public void setBankUpdateDate(String bankUpdateDate) {
        this.bankUpdateDate = bankUpdateDate;
    }

    public String getBankCreateDate() {
        return bankCreateDate;
    }

    public void setBankCreateDate(String bankCreateDate) {
        this.bankCreateDate = bankCreateDate;
    }

    public String getBankDescription() {
        return bankDescription;
    }

    public void setBankDescription(String bankDescription) {
        this.bankDescription = bankDescription;
    }

    public int getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(int bankStatus) {
        this.bankStatus = bankStatus;
    }

    public String getBankVersion() {
        return bankVersion;
    }

    public void setBankVersion(String bankVersion) {
        this.bankVersion = bankVersion;
    }

    public String getBankUpdatePerson() {
        return bankUpdatePerson;
    }

    public void setBankUpdatePerson(String bankUpdatePerson) {
        this.bankUpdatePerson = bankUpdatePerson;
    }
}
