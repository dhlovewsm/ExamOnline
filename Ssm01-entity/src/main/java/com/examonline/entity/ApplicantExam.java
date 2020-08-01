package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 13:44
 * @description 应聘人员考试表对应的实体类
 * @className ApplicantExam
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_applicant_exam")
public class ApplicantExam {
    /**
     * @description 应聘者考试表ID，主键，自增
     */
    @Id
    private int applicantExamId;
    /**
     * @description 应聘者ID，外键
     */
    @Column(name = "applicant_id")
    private String applicantId;
    /**
     * @description 考试ID，外键
     */
    @Column(name = "exam_id")
    private String examId;
    /**
     * @description 应聘者考试开始日期
     */
    @Column(name = "start_date")
    private String applicantExamStartDate;
    /**
     * @description 应聘者考试截止日期
     */
    @Column(name = "end_date")
    private String applicantExamEndDate;
    /**
     * @description 应聘者考试得分，阅卷后使用
     */
    @Column(name = "score")
    private int applicantExamScore;
    /**
     * @description 应聘者考试的标签，
     */
    @Column(name = "exam_label")
    private String applicantExamLabel;
    @Transient
    private Applicant applicant;
    @Transient
    private Exam exam;
    @Column(name = "create_date")
    private String applicantExamCreateDate;
    @Column(name = "update_date")
    private String applicantExamUpdateDate;
    @Column(name = "creator")
    private String applicantExamCreator;
    @Column(name = "status")
    private int applicantExamStatus;
    @Column(name = "version")
    private String applicantExamVersion;
    @Column(name = "update_person")
    private String applicantExamUpdatePerson;

    public int getApplicantExamId() {
        return applicantExamId;
    }

    public void setApplicantExamId(int applicantExamId) {
        this.applicantExamId = applicantExamId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getApplicantExamStartDate() {
        return applicantExamStartDate;
    }

    public void setApplicantExamStartDate(String applicantExamStartDate) {
        this.applicantExamStartDate = applicantExamStartDate;
    }

    public String getApplicantExamEndDate() {
        return applicantExamEndDate;
    }

    public void setApplicantExamEndDate(String applicantExamEndDate) {
        this.applicantExamEndDate = applicantExamEndDate;
    }

    public int getApplicantExamScore() {
        return applicantExamScore;
    }

    public void setApplicantExamScore(int applicantExamScore) {
        this.applicantExamScore = applicantExamScore;
    }

    public String getApplicantExamLabel() {
        return applicantExamLabel;
    }

    public void setApplicantExamLabel(String applicantExamLabel) {
        this.applicantExamLabel = applicantExamLabel;
    }

    public String getApplicantExamCreateDate() {
        return applicantExamCreateDate;
    }

    public void setApplicantExamCreateDate(String applicantExamCreateDate) {
        this.applicantExamCreateDate = applicantExamCreateDate;
    }

    public String getApplicantExamUpdateDate() {
        return applicantExamUpdateDate;
    }

    public void setApplicantExamUpdateDate(String applicantExamUpdateDate) {
        this.applicantExamUpdateDate = applicantExamUpdateDate;
    }

    public String getApplicantExamCreator() {
        return applicantExamCreator;
    }

    public void setApplicantExamCreator(String applicantExamCreator) {
        this.applicantExamCreator = applicantExamCreator;
    }

    public int getApplicantExamStatus() {
        return applicantExamStatus;
    }

    public void setApplicantExamStatus(int applicantExamStatus) {
        this.applicantExamStatus = applicantExamStatus;
    }

    public String getApplicantExamVersion() {
        return applicantExamVersion;
    }

    public void setApplicantExamVersion(String applicantExamVersion) {
        this.applicantExamVersion = applicantExamVersion;
    }

    public String getApplicantExamUpdatePerson() {
        return applicantExamUpdatePerson;
    }

    public void setApplicantExamUpdatePerson(String applicantExamUpdatePerson) {
        this.applicantExamUpdatePerson = applicantExamUpdatePerson;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
