package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @version 1.0
 * @author donghao
 * @date 2019/3/23 15:12
 * @description 应聘者简历实体类
 * @className Resume
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_resume")
public class Resume {
    @Id
    private int resumeId;
    @Column(name = "resume_picture")
    private String resumePictureUrl;
    @Column(name = "resume_married")
    private int resumeMarried;
    @Column(name = "resume_school")
    private String resumeSchool;
    @Column(name = "resume_disease")
    private String resumeDisease;
    @Column(name = "resume_qq")
    private String resumeQQ;
    @Column(name = "resume_major")
    private String resumeMajor;
    @Column(name = "resume_political")
    private String resumePolitical;
    @Column(name = "domicile_place")
    private String resumeDomicilePlace;
    @Column(name = "update_date")
    private String resumeUpdateDate;
    @Column(name = "create_date")
    private String resumeCreateDate;
    @Column(name = "resume_education")
    private String resumeEducation;
    @Column(name = "resume_identity")
    private String resumeIdentity;
    @Column(name = "resume_nation")
    private String resumeNation;
    @Column(name = "application_source")
    private String resumeApplicationSource;
    @Column(name = "current_salary")
    private BigDecimal resumeCurrentSalary;
    @Column(name = "resume_position")
    private String resumePosition;
    @Column(name = "expected_salary")
    private BigDecimal resumeExpectedSalary;
    @Column(name = "resume_birth")
    private Date resumeBirth;
    @Column(name = "resume_address")
    private String resumeAddress;
    @Column(name = "resume_skill")
    private String resumeSkill;
    @Column(name = "career_plan")
    private String resumeCareerPlan;
    @Column(name = "certificate")
    private String resumeCertificate;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "resume_portrait")
    private byte resumePortrait;
    @Column(name = "resume_linkman")
    private String resumeLinkMan;
    @Column(name = "linkman_phone")
    private String resumeLinkManPhone;
    @Column(name = "study_info")
    private String resumeStudyInfo;
    @Column(name = "version")
    private String resumeVersion;
    @Column(name = "work_info")
    private String resumeWorkInfo;
    @Column(name = "family_info")
    private String resumeFamilyInfo;
    @Column(name = "update_person")
    private String resumeUpdatePerson;
    @Column(name = "status")
    private int resumeStatus;
    @Column(name = "applicant_id")
    private String applicantId;

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getResumeMarried() {
        return resumeMarried;
    }

    public void setResumeMarried(int resumeMarried) {
        this.resumeMarried = resumeMarried;
    }

    public String getResumeDisease() {
        return resumeDisease;
    }

    public void setResumeDisease(String resumeDisease) {
        this.resumeDisease = resumeDisease;
    }

    public String getResumeQQ() {
        return resumeQQ;
    }

    public void setResumeQQ(String resumeQQ) {
        this.resumeQQ = resumeQQ;
    }

    public String getResumeMajor() {
        return resumeMajor;
    }

    public void setResumeMajor(String resumeMajor) {
        this.resumeMajor = resumeMajor;
    }

    public String getResumeDomicilePlace() {
        return resumeDomicilePlace;
    }

    public void setResumeDomicilePlace(String resumeDomicilePlace) {
        this.resumeDomicilePlace = resumeDomicilePlace;
    }

    public String getResumeUpdateDate() {
        return resumeUpdateDate;
    }

    public void setResumeUpdateDate(String resumeUpdateDate) {
        this.resumeUpdateDate = resumeUpdateDate;
    }

    public String getResumeCreateDate() {
        return resumeCreateDate;
    }

    public void setResumeCreateDate(String resumeCreateDate) {
        this.resumeCreateDate = resumeCreateDate;
    }

    public String getResumeEducation() {
        return resumeEducation;
    }

    public void setResumeEducation(String resumeEducation) {
        this.resumeEducation = resumeEducation;
    }

    public String getResumeIdentity() {
        return resumeIdentity;
    }

    public void setResumeIdentity(String resumeIdentity) {
        this.resumeIdentity = resumeIdentity;
    }

    public String getResumeNation() {
        return resumeNation;
    }

    public void setResumeNation(String resumeNation) {
        this.resumeNation = resumeNation;
    }

    public String getResumeApplicationSource() {
        return resumeApplicationSource;
    }

    public void setResumeApplicationSource(String resumeApplicationSource) {
        this.resumeApplicationSource = resumeApplicationSource;
    }

    public BigDecimal getResumeCurrentSalary() {
        return resumeCurrentSalary;
    }

    public void setResumeCurrentSalary(BigDecimal resumeCurrentSalary) {
        this.resumeCurrentSalary = resumeCurrentSalary;
    }

    public BigDecimal getResumeExpectedSalary() {
        return resumeExpectedSalary;
    }

    public void setResumeExpectedSalary(BigDecimal resumeExpectedSalary) {
        this.resumeExpectedSalary = resumeExpectedSalary;
    }

    public Date getResumeBirth() {
        return resumeBirth;
    }

    public void setResumeBirth(Date resumeBirth) {
        this.resumeBirth = resumeBirth;
    }

    public String getResumeAddress() {
        return resumeAddress;
    }

    public void setResumeAddress(String resumeAddress) {
        this.resumeAddress = resumeAddress;
    }

    public String getResumeSkill() {
        return resumeSkill;
    }

    public void setResumeSkill(String resumeSkill) {
        this.resumeSkill = resumeSkill;
    }

    public String getResumeCareerPlan() {
        return resumeCareerPlan;
    }

    public void setResumeCareerPlan(String resumeCareerPlan) {
        this.resumeCareerPlan = resumeCareerPlan;
    }

    public String getResumeCertificate() {
        return resumeCertificate;
    }

    public void setResumeCertificate(String resumeCertificate) {
        this.resumeCertificate = resumeCertificate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public byte getResumePortrait() {
        return resumePortrait;
    }

    public void setResumePortrait(byte resumePortrait) {
        this.resumePortrait = resumePortrait;
    }

    public String getResumeLinkMan() {
        return resumeLinkMan;
    }

    public void setResumeLinkMan(String resumeLinkMan) {
        this.resumeLinkMan = resumeLinkMan;
    }

    public String getResumeLinkManPhone() {
        return resumeLinkManPhone;
    }

    public void setResumeLinkManPhone(String resumeLinkManPhone) {
        this.resumeLinkManPhone = resumeLinkManPhone;
    }

    public String getResumeStudyInfo() {
        return resumeStudyInfo;
    }

    public void setResumeStudyInfo(String resumeStudyInfo) {
        this.resumeStudyInfo = resumeStudyInfo;
    }

    public String getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(String resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

    public String getResumeWorkInfo() {
        return resumeWorkInfo;
    }

    public void setResumeWorkInfo(String resumeWorkInfo) {
        this.resumeWorkInfo = resumeWorkInfo;
    }

    public String getResumeFamilyInfo() {
        return resumeFamilyInfo;
    }

    public void setResumeFamilyInfo(String resumeFamilyInfo) {
        this.resumeFamilyInfo = resumeFamilyInfo;
    }

    public String getResumeUpdatePerson() {
        return resumeUpdatePerson;
    }

    public void setResumeUpdatePerson(String resumeUpdatePerson) {
        this.resumeUpdatePerson = resumeUpdatePerson;
    }

    public int getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(int resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getResumePictureUrl() {
        return resumePictureUrl;
    }

    public void setResumePictureUrl(String resumePictureUrl) {
        this.resumePictureUrl = resumePictureUrl;
    }

    public String getResumePolitical() {
        return resumePolitical;
    }

    public void setResumePolitical(String resumePolitical) {
        this.resumePolitical = resumePolitical;
    }

    public String getResumePosition() {
        return resumePosition;
    }

    public void setResumePosition(String resumePosition) {
        this.resumePosition = resumePosition;
    }

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool;
    }
}
