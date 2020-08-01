package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.BankMapper;
import com.examonline.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @className BankService
 * @packageName com.examonline.service
 * @author donghao
 * @date 2019/3/26 10:17
 * @description 题库业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface BankService extends BaseService<Bank> {

    /**
     * @description 用于添加,判断是否存在
     * @param bank
     * @return
     */
    public boolean ifExistsBank(Bank bank);

}
