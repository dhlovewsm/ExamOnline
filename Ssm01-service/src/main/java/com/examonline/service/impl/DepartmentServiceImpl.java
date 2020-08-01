package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.DepartmentMapper;
import com.examonline.entity.Department;
import com.examonline.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/31 20:33
 * @className DepartmentServiceImpl
 * @packageName com.examonline.service.impl
 * @description 部门业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department>
        implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean ifExistsDepartment(Department requestDepartment){
        int departmentId = requestDepartment.getDepartmentId();
        Department department = departmentMapper.selectByPrimaryKey(departmentId);
        if (department != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Department> queryDepartmentsByCompanyId(int companyId) {
        Example example = new Example(Department.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("companyId",companyId);
        List<Department> departments = departmentMapper.selectByExample(example);
        return departments;
    }
}
