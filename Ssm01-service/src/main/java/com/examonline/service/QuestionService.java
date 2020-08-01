package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Question;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/27 11:44
 * @className QuestionService
 * @packageName com.examonline.service
 * @description 试题业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface QuestionService extends BaseService<Question> {

    /**
     * @description 用于更新,将请求的Question进行转换
     * @param requestQuestion
     * @return
     * @throws Exception
     */
    public Question getRequestQuestion(Question requestQuestion) throws Exception ;

    /**
     * @description 用于添加,判断是否存在
     * @param question
     * @return
     */
    public boolean ifExistsQuestion(Question question) throws Exception;

    /**
     * @description 根据条件过滤获取试题
     * @param bankId
     * @param typeId
     * @param difficulty
     * @return
     */
    public List<Question> filtQuestions(int bankId,int typeId,int difficulty);


}
