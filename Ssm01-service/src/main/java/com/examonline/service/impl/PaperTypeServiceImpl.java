package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.entity.PaperType;
import com.examonline.service.ExceptionService;
import com.examonline.service.PaperTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/1 10:57
 * @className PaperTypeServiceImpl
 * @packageName com.examonline.service.impl
 * @description 试卷类型业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("paperTypeService")
public class PaperTypeServiceImpl extends BaseServiceImpl<PaperType>
        implements PaperTypeService,ExceptionService {
    @Override
    public void catchException() throws Exception {
        throw new Exception("PaperTypeServiceImpl捕捉到异常");
    }
}
