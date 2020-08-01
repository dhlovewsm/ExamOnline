package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.CompanyMapper;
import com.examonline.entity.Company;
import com.examonline.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/31 20:27
 * @className CompanyServiceImpl
 * @packageName com.examonline.service.impl
 * @description 公司业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<Company>
        implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public boolean ifExistsCompany(Company requestCompany){
        int companyId = requestCompany.getCompanyId();
        Company company = companyMapper.selectByPrimaryKey(companyId);
        if (company != null){
            return true;
        }else {
            return false;
        }
    }
}
