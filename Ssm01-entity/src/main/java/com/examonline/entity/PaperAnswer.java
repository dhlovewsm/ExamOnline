package com.examonline.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Blob;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/23 14:35
 * @description 应聘者考卷答案的实体类
 * @className PaperAnswer
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

@Table(name = "t_paper_answer")
public class PaperAnswer {
    @Id
    private int paperAnswerId;
    @Column(name = "applicant_exam_id")
    private int applicantExamId;
    @Column(name = "question_id")
    private String questionId;
    @Transient
    private Question question;
    @Column(name = "user_answer")
    private String paperUserAnswer;
    @Column(name = "question_score")
    private int questionScore;
    @Column(name = "create_date")
    private String paperAnswerCreateDate;
    @Column(name = "update_date")
    private String paperAnswerUpdateDate;
    @Column(name = "version")
    private String paperAnswerVersion;
    @Column(name = "status")
    private int paperAnswerStatus;
    @Column(name = "update_person")
    private String paperAnswerUpdatePerson;
    @Column(name = "answer_picture")
    private String paperAnswerPicture;

    public int getPaperAnswerId() {
        return paperAnswerId;
    }

    public void setPaperAnswerId(int paperAnswerId) {
        this.paperAnswerId = paperAnswerId;
    }

    public int getApplicantExamId() {
        return applicantExamId;
    }

    public void setApplicantExamId(int applicantExamId) {
        this.applicantExamId = applicantExamId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPaperUserAnswer() {
        return paperUserAnswer;
    }

    public void setPaperUserAnswer(String paperUserAnswer) {
        this.paperUserAnswer = paperUserAnswer;
    }

    public String getPaperAnswerCreateDate() {
        return paperAnswerCreateDate;
    }

    public void setPaperAnswerCreateDate(String paperAnswerCreateDate) {
        this.paperAnswerCreateDate = paperAnswerCreateDate;
    }

    public String getPaperAnswerUpdateDate() {
        return paperAnswerUpdateDate;
    }

    public void setPaperAnswerUpdateDate(String paperAnswerUpdateDate) {
        this.paperAnswerUpdateDate = paperAnswerUpdateDate;
    }

    public String getPaperAnswerVersion() {
        return paperAnswerVersion;
    }

    public void setPaperAnswerVersion(String paperAnswerVersion) {
        this.paperAnswerVersion = paperAnswerVersion;
    }

    public int getPaperAnswerStatus() {
        return paperAnswerStatus;
    }

    public void setPaperAnswerStatus(int paperAnswerStatus) {
        this.paperAnswerStatus = paperAnswerStatus;
    }

    public String getPaperAnswerUpdatePerson() {
        return paperAnswerUpdatePerson;
    }

    public void setPaperAnswerUpdatePerson(String paperAnswerUpdatePerson) {
        this.paperAnswerUpdatePerson = paperAnswerUpdatePerson;
    }
    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getPaperAnswerPicture() {
        return paperAnswerPicture;
    }

    public void setPaperAnswerPicture(String paperAnswerPicture) {
        this.paperAnswerPicture = paperAnswerPicture;
    }
}
