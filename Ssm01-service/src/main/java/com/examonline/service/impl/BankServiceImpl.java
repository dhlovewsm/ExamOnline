package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.BankMapper;
import com.examonline.entity.Bank;
import com.examonline.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @version V1.0
 * @description 题库业务接口实现类
 * @author donghao
 * @date 2019/3/26 10:17
 * @className BankServiceImpl
 * @packageName com.examonline.service.impl
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("bankService")
public class BankServiceImpl extends BaseServiceImpl<Bank>
        implements BankService {
    @Autowired
    private BankMapper bankMapper;

    /**
     * @description 用于添加,判断是否存在
     * @param bank
     * @return
     */
    @Override
    public boolean ifExistsBank(Bank bank){
        Bank bank1 = bankMapper.selectByPrimaryKey(bank.getBankId());
        if (bank1 != null){
            return true;
        }else {
            return false;
        }
    }

}
