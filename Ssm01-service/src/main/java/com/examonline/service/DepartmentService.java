
package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Department;
import com.examonline.entity.User;

import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/31 20:33
 * @className DepartmentService
 * @packageName com.examonline.service
 * @description 部门业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface DepartmentService extends BaseService<Department> {

    /**
     * @description 判断是否存在部门
     * @param requestDepartment
     * @return
     */
    public boolean ifExistsDepartment(Department requestDepartment);

    public List<Department> queryDepartmentsByCompanyId(int companyId);
}
