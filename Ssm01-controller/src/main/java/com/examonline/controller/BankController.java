package com.examonline.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.Bank;
import com.examonline.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @version V1.0
 * @description 题库Controller，包含题库的基础增删改查接口
 * @author donghao
 * @date 2019/3/26 10:22
 * @className BankController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@RequestMapping("/bank")
@Controller
public class BankController {
    @Autowired
    private BankService bankService;

    /**
     * @description 添加新题库
     * @param requestBank
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addBank",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String addBank(Bank requestBank) throws Exception{
        if (bankService.ifExistsBank(requestBank)){
            throw new Exception("该题库已存在");
        }else {
            System.out.println(requestBank.getBankName());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            requestBank.setBankCreateDate((String)df.format(new Date()));
            bankService.save(requestBank);
            return "success";
        }
    }

    /**
     * @description 获取题库列表，通过json格式传输
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/getBanks",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String getBanks(Integer startPage,Integer pageSize) throws Exception{
        PageHelper.startPage(startPage,pageSize);
        List<Bank> banks = bankService.queryAll();
        PageInfo<Bank> pageInfo = new PageInfo<>(banks);
        JSONObject json = new JSONObject();
        json.put("banks",JSONObject.toJSON(pageInfo));
        return json.toJSONString();
    }

    /**
     * @description 删除一个或多个题库
     * @param idArray
     * @return success
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deleteBanks",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String deleteBanks(String idArray) throws Exception{
        System.out.println(idArray);
        List<Integer> list = JSONArray.parseArray(idArray,int.class);
        System.out.println(list);
        if (list == null){
            throw new Exception("对象为空");
        }
        for (Integer bankId : list){
            bankService.deleteById(bankId);
        }
        return "success";
    }

    /**
     * @description 更新题库
     * @param requestBank
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/updateBank",method = RequestMethod.PUT,produces={"application/json;charset=utf-8"} )
    @ResponseBody
    public String updateBank(Bank requestBank)throws Exception{
        int bankId = requestBank.getBankId();
        System.out.println(requestBank.getBankName());
        System.out.println(bankId);
        Bank bank = bankService.queryById(bankId);
        String bankName = requestBank.getBankName();
        int bankStatus = requestBank.getBankStatus();
        String bankDescription = requestBank.getBankDescription();
        if (bank == null ){
            throw new Exception("该记录不存在");
        }else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            bank.setBankUpdateDate((String)df.format(new Date()));
            bank.setBankName(bankName);
            bank.setBankStatus(bankStatus);
            bank.setBankDescription(bankDescription);
            bankService.update(bank);
            return "success";
        }
    }

}
