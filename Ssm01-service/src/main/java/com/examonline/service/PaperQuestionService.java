package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.PaperQuestion;

import java.util.List;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/1 13:52
 * @className PaperQuestionService
 * @packageName com.examonline.service
 * @description 试卷试题业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface PaperQuestionService extends BaseService<PaperQuestion> {

    /**
     * @description 显示试卷
     * @param paperId
     * @return
     */
    public List<PaperQuestion> showPaper(String paperId) ;
}
