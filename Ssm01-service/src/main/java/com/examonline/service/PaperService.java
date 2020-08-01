package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Paper;
import com.examonline.entity.PaperAnswer;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/27 14:13
 * @className PaperService
 * @packageName com.examonline.service
 * @description 试卷业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface PaperService extends BaseService<Paper> {

    /**
     * @description 用于添加,判断是否存在
     * @param paper
     * @return
     */
    public boolean ifExistsPaper(Paper paper);

    /**
     * 转换对象
     * @description 用于更新，将请求的paper进行转换
     * @param requestPaper
     * @return
     * @throws Exception
     */
    public Paper getRequestPaper(Paper requestPaper) throws Exception ;

    public List<Paper> queryPapersByType(String typeName)throws Exception;

    public List<Paper> queryPapersByTypeId(int paperTypeId);

    /**
     * 组卷
     * @description 组卷算法
     * @param idArray
     * @param easyNum
     * @param mediumNum
     * @param difficultNum
     * @param typeId
     */
    public void createPaper(String paperId,String idArray, int easyNum,int mediumNum, int difficultNum,
                            int typeId,int questionScore);

    /**
     * 自动阅卷
     * @description 选择题自动纠正试卷
     * @param paperAnswer
     */
    public void correctQuestion(PaperAnswer paperAnswer);
}
