package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.PaperQuestionMapper;
import com.examonline.entity.PaperAnswer;
import com.examonline.entity.PaperQuestion;
import com.examonline.service.ExceptionService;
import com.examonline.service.PaperQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/1 13:52
 * @className PaperQuestionServiceImpl
 * @packageName com.examonline.service.impl
 * @description 试卷试题业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("paperQuestionService")
public class PaperQuestionServiceImpl extends BaseServiceImpl<PaperQuestion>
        implements PaperQuestionService,ExceptionService {
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    /**
     * @description 显示试卷
     * @param paperId
     * @return
     */
    @Override
    public List<PaperQuestion> showPaper(String paperId) {
        Example example = new Example(PaperQuestion.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paperId",paperId);
        List<PaperQuestion> list = paperQuestionMapper.selectByExample(example);
        return list;
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("PaperQuestionServiceImpl捕捉到异常");
    }
}
