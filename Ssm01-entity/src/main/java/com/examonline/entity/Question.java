package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:47
 * @description 试题实体类
 * @className Question
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_question")
public class Question {
    @Id
    private String questionId;
    @Column(name = "bank_id")
    private int bankId;
    @Column(name = "type_id")
    private int typeId;
    @Transient
    private Company company;
    @Transient
    private Bank bank;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "difficulty")
    private int questionDifficulty;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "options")
    private String questionOption;
    @Column(name = "answer")
    private String questionAnswer;
    @Column(name = "creator")
    private String questionCreator;
    @Column(name = "update_date")
    private String questionUpdateDate;
    @Column(name = "create_date")
    private String questionCreateDate;
    @Column(name = "status")
    private int questionStatus;
    @Column(name = "version")
    private String questionVersion;
    @Column(name = "update_person")
    private String questionUpdatePerson;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionCreator() {
        return questionCreator;
    }

    public void setQuestionCreator(String questionCreator) {
        this.questionCreator = questionCreator;
    }

    public String getQuestionUpdateDate() {
        return questionUpdateDate;
    }

    public void setQuestionUpdateDate(String questionUpdateDate) {
        this.questionUpdateDate = questionUpdateDate;
    }

    public String getQuestionCreateDate() {
        return questionCreateDate;
    }

    public void setQuestionCreateDate(String questionCreateDate) {
        this.questionCreateDate = questionCreateDate;
    }

    public int getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(int questionStatus) {
        this.questionStatus = questionStatus;
    }

    public String getQuestionVersion() {
        return questionVersion;
    }

    public void setQuestionVersion(String questionVersion) {
        this.questionVersion = questionVersion;
    }

    public String getQuestionUpdatePerson() {
        return questionUpdatePerson;
    }

    public void setQuestionUpdatePerson(String questionUpdatePerson) {
        this.questionUpdatePerson = questionUpdatePerson;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
