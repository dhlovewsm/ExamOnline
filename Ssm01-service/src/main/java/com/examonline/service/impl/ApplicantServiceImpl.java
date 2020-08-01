package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.ApplicantMapper;
import com.examonline.entity.Applicant;
import com.examonline.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @date 2019/04/03
 * @author donghao
 * @className ApplicantServiceImpl
 * @packageName com.examonline.service.impl
 * @description 应聘者业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("applicantService")
public class ApplicantServiceImpl extends BaseServiceImpl<Applicant>
        implements ApplicantService {
    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public Applicant getApplicantByApplicantAccount(String applicantAccount){
        Example example = new Example(Applicant.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantAccount",applicantAccount);
        List<Applicant> applicants = applicantMapper.selectByExample(example);
        if (applicants.size() == 0){
            return null;
        }
        return applicants.get(0);
    }

    /**
     * @description 用于添加,判断是否存在
     * @param applicant
     * @return
     */
    @Override
    public boolean ifExistsApplicant(Applicant applicant) throws Exception {
        String applicantAccount = applicant.getApplicantAccount();
        if (applicantAccount == null){
            throw new Exception("参数为空");
        }else {
            Applicant applicant1 = getApplicantByApplicantAccount(applicantAccount);
            if (applicant1 != null){
                return true;
            }else {
                return false;
            }
        }
    }

    /**
     * @description 用于更新,将请求的Applicant对象进行转换
     * @param requestApplicant
     * @return
     */
    @Override
    public Applicant getRequestApplicant(Applicant requestApplicant){
        String applicantAccount = requestApplicant.getApplicantAccount();
        Applicant applicant = getApplicantByApplicantAccount(applicantAccount);
        applicant.setApplicantPassword(requestApplicant.getApplicantPassword());
        applicant.setApplicantName(requestApplicant.getApplicantName());
        applicant.setApplicantPhone(requestApplicant.getApplicantPhone());
        applicant.setApplicantSex(requestApplicant.getApplicantSex());
        applicant.setApplicantEmail(requestApplicant.getApplicantEmail());
        applicant.setApplicantCreateDate(requestApplicant.getApplicantCreateDate());
        applicant.setApplicantUpdateDate(requestApplicant.getApplicantUpdateDate());
        applicant.setApplicantCreator(requestApplicant.getApplicantCreator());
        applicant.setApplicantVersion(requestApplicant.getApplicantVersion());
        applicant.setApplicantStatus(requestApplicant.getApplicantStatus());
        applicant.setApplicantUpdatePerson(requestApplicant.getApplicantUpdatePerson());
        return applicant;
    }

    @Override
    public List<Applicant> queryApplicantsByDepartmentId(Integer departmentId){
        return applicantMapper.queryApplicantsByDepartmentId(departmentId);
    }

    @Override
    public List<Applicant> getAll(){
        return applicantMapper.getAll();
    }

}