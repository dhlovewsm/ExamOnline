
package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Company;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/31 20:27
 * @className CompanyService
 * @packageName com.examonline.service
 * @description 公司业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface CompanyService extends BaseService<Company> {

    public boolean ifExistsCompany(Company requestCompany);
}
