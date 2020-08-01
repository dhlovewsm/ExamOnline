package com.examonline.entity;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/2 10:07
 * @description 试卷参数实体类，数据库中不存在，仅仅作中介传参使用
 * @className PaperParameter
 * @packageName com.examonline.entity
 * @copyright(C) www.bosssoft.com.cn
 */

public class PaperParameter {
    private int paperTypeId;
    private int paperDifficulty;
    private String paperName;
    private String idArray;
    private int easyNum;
    private int mediumNum;
    private int difficultNum;
    private int typeId;
    private int questionScore;
    private int companyId;
    public int getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(int paperTypeId) {
        this.paperTypeId = paperTypeId;
    }

    public int getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(int paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getIdArray() {
        return idArray;
    }

    public void setIdArray(String idArray) {
        this.idArray = idArray;
    }

    public int getEasyNum() {
        return easyNum;
    }

    public void setEasyNum(int easyNum) {
        this.easyNum = easyNum;
    }

    public int getMediumNum() {
        return mediumNum;
    }

    public void setMediumNum(int mediumNum) {
        this.mediumNum = mediumNum;
    }

    public int getDifficultNum() {
        return difficultNum;
    }

    public void setDifficultNum(int difficultNum) {
        this.difficultNum = difficultNum;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

}
