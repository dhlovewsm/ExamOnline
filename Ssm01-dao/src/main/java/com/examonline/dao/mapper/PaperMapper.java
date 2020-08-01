package com.examonline.dao.mapper;

import com.examonline.common.base.BaseMapper;
import com.examonline.entity.Paper;
import com.examonline.entity.Question;

import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/04
 * @author donghao
 * @description 试卷对应的mapper接口
 * @className PaperMapper
 * @packageName com.examonline.dao.mapper
 * @copyright(C) www.bosssoft.com.cn
 */

public interface PaperMapper extends BaseMapper<Paper> {
    /**
     * @description 通过类型获取paper列表
     * @param typeName
     * @return
     */
    public List<Paper> queryPapersByType(String typeName);
}
