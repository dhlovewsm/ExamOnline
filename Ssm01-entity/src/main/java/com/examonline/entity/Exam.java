package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 15:51
 * @decripiton 考试表对应的实体类
 * @className Exam
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_exam")
public class Exam {
    @Id
    private String examId;
    @Column(name = "exam_name")
    private String examName;
    @Column(name = "start_date")
    private String examStartDate;
    @Column(name = "end_date")
    private String examEndDate;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "status")
    private int examStatus;
    @Column(name = "exam_time")
    private int examTimeLength;
    @Column(name = "paper_id")
    private String paperId;
    @Transient
    private Company company;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "version")
    private String examVersion;
    @Column(name = "create_date")
    private String examCreateDate;
    @Column(name = "update_date")
    private String examUpdateDate;
    @Column(name = "creator")
    private String examCreator;
    @Column(name = "update_person")
    private String examUpdatePerson;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamStartDate() {
        return examStartDate;
    }

    public void setExamStartDate(String examStartDate) {
        this.examStartDate = examStartDate;
    }

    public String getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(String examEndDate) {
        this.examEndDate = examEndDate;
    }


    public int getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(int examStatus) {
        this.examStatus = examStatus;
    }

    public int getExamTimeLength() {
        return examTimeLength;
    }

    public void setExamTimeLength(int examTimeLength) {
        this.examTimeLength = examTimeLength;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getExamVersion() {
        return examVersion;
    }

    public void setExamVersion(String examVersion) {
        this.examVersion = examVersion;
    }

    public String getExamCreateDate() {
        return examCreateDate;
    }

    public void setExamCreateDate(String examCreateDate) {
        this.examCreateDate = examCreateDate;
    }

    public String getExamUpdateDate() {
        return examUpdateDate;
    }

    public void setExamUpdateDate(String examUpdateDate) {
        this.examUpdateDate = examUpdateDate;
    }

    public String getExamCreator() {
        return examCreator;
    }

    public void setExamCreator(String examCreator) {
        this.examCreator = examCreator;
    }

    public String getExamUpdatePerson() {
        return examUpdatePerson;
    }

    public void setExamUpdatePerson(String examUpdatePerson) {
        this.examUpdatePerson = examUpdatePerson;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
