package com.examonline.dao.mapper;

import com.examonline.common.base.BaseMapper;
import com.examonline.entity.Applicant;

import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/04
 * @author donghao
 * @description 应聘人员实体类对应mapper接口
 * @className ApplicantMapper
 * @packageName com.examonline.dao.mapper
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ApplicantMapper extends BaseMapper<Applicant> {

    /**
     * @description 遍历数据库所有应聘者
     * @return
     */
    public List<Applicant> getAll();

    /**
     * @description 通过应聘部门获取applicant列表
     * @param departmentId
     * @return list
     */
    public List<Applicant> queryApplicantsByDepartmentId(Integer departmentId);
}
