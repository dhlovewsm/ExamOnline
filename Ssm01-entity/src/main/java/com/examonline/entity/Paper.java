package com.examonline.entity;

import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:27
 * @description 试卷实体类
 * @className Paper
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_paper")
public class Paper {
    @Id
    private String paperId;
    @Column(name = "paper_name")
    private String paperName;
    @Column(name = "type_id")
    private int paperTypeId;
    @Transient
    private PaperType type;
    @Transient
    private Company company;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "difficulty")
    private int paperDifficulty;
    @Column(name = "status")
    private int paperStatus;
    @Column(name = "version")
    private String paperVersion;
    @Column(name = "create_date")
    private String paperCreateDate;
    @Column(name = "update_date")
    private String paperUpdateDate;
    @Column(name = "creator")
    private String paperCreator;
    @Column(name = "total_score")
    private int paperTotalScore;
    @Column(name = "description")
    private String paperDescription;
    @Column(name = "update_person")
    private String paperUpdatePerson;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(int paperTypeId) {
        this.paperTypeId = paperTypeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(int paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public int getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(int paperStatus) {
        this.paperStatus = paperStatus;
    }

    public String getPaperVersion() {
        return paperVersion;
    }

    public void setPaperVersion(String paperVersion) {
        this.paperVersion = paperVersion;
    }

    public String getPaperCreateDate() {
        return paperCreateDate;
    }

    public void setPaperCreateDate(String paperCreateDate) {
        this.paperCreateDate = paperCreateDate;
    }

    public String getPaperUpdateDate() {
        return paperUpdateDate;
    }

    public void setPaperUpdateDate(String paperUpdateDate) {
        this.paperUpdateDate = paperUpdateDate;
    }

    public String getPaperCreator() {
        return paperCreator;
    }

    public void setPaperCreator(String paperCreator) {
        this.paperCreator = paperCreator;
    }

    public int getPaperTotalScore() {
        return paperTotalScore;
    }

    public void setPaperTotalScore(int paperTotalScore) {
        this.paperTotalScore = paperTotalScore;
    }

    public String getPaperDescription() {
        return paperDescription;
    }

    public void setPaperDescription(String paperDescription) {
        this.paperDescription = paperDescription;
    }

    public String getPaperUpdatePerson() {
        return paperUpdatePerson;
    }

    public void setPaperUpdatePerson(String paperUpdatePerson) {
        this.paperUpdatePerson = paperUpdatePerson;
    }

    public PaperType getType() {
        return type;
    }

    public void setType(PaperType type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
