package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:41
 * @description 试卷类型对应的实体类
 * @className PaperType
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_paper_type")
public class PaperType {
    @Id
    private int typeId;
    @Column(name = "type_name")
    @Transient
    private List<Paper> paperList;
    private String typeName;
    @Column(name = "creator")
    private String paperTypeCreator;
    @Column(name = "create_date")
    private String paperTypeCreateDate;
    @Column(name = "update_date")
    private String paperTypeUpdateDate;
    @Column(name = "status")
    private int paperTypeStatus;
    @Column(name = "version")
    private String paperTypeVersion;
    @Column(name = "update_person")
    private String paperTypeUpdatePerson;

    public int getTypeId() {
        return typeId;
    }

    public void setTyperId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPaperTypeCreator() {
        return paperTypeCreator;
    }

    public void setPaperTypeCreator(String paperTypeCreator) {
        this.paperTypeCreator = paperTypeCreator;
    }

    public String getPaperTypeCreateDate() {
        return paperTypeCreateDate;
    }

    public void setPaperTypeCreateDate(String paperTypeCreateDate) {
        this.paperTypeCreateDate = paperTypeCreateDate;
    }

    public String getPaperTypeUpdateDate() {
        return paperTypeUpdateDate;
    }

    public void setPaperTypeUpdateDate(String paperTypeUpdateDate) {
        this.paperTypeUpdateDate = paperTypeUpdateDate;
    }

    public int getPaperTypeStatus() {
        return paperTypeStatus;
    }

    public void setPaperTypeStatus(int paperTypeStatus) {
        this.paperTypeStatus = paperTypeStatus;
    }

    public String getPaperTypeVersion() {
        return paperTypeVersion;
    }

    public void setPaperTypeVersion(String paperTypeVersion) {
        this.paperTypeVersion = paperTypeVersion;
    }

    public String getPaperTypeUpdatePerson() {
        return paperTypeUpdatePerson;
    }

    public void setPaperTypeUpdatePerson(String paperTypeUpdatePerson) {
        this.paperTypeUpdatePerson = paperTypeUpdatePerson;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }
}
