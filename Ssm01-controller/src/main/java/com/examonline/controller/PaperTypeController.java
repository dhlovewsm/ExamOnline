package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.Bank;
import com.examonline.entity.PaperType;
import com.examonline.service.BankService;
import com.examonline.service.PaperService;
import com.examonline.service.PaperTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/1 10:57
 * @decription 试卷类型controller，包含基础的增删改查接口
 * @className PaperTypeController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/paperType")
public class PaperTypeController {
    @Autowired
    private PaperTypeService paperTypeService;
    @Autowired
    private BankService bankService;
    @Autowired
    private PaperService paperService;

    /**
     * @description 获取所有试卷类型名称
     * @param typeId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getTypeName",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getTypeNameById(int typeId) throws Exception{
        PaperType type = paperTypeService.queryById(typeId);
        if (type == null){
            throw new Exception("不存在此类型");
        }else {
            return type.getTypeName();
        }
    }

    /**
     * @description 获取所有题库和试卷类型
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getBanksAndPaperType",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getBanksAndPaperType() throws Exception{
        List<Bank> banks = bankService.queryAll();
        List<PaperType> types = paperTypeService.queryAll();
        if (banks == null || types == null){
            throw new Exception("数据为空");
        }else {
            JSONObject json = new JSONObject();
            json.put("banks",JSONObject.toJSON(banks));
            json.put("types",JSONObject.toJSON(types));
            return json.toJSONString();
        }
    }

    /**
     * @description 将数据库中所有paper以type分类并返回
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getPapers",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getPapers() throws Exception{
        List<PaperType> paperTypes = paperTypeService.queryAll();
        if (paperTypes == null){
            throw new Exception("数据库不存在试卷类型");
        }else {
            for (PaperType paperType : paperTypes){
                paperType.setPaperList(paperService.queryPapersByTypeId(paperType.getTypeId()));
            }
        }
        JSONObject json = new JSONObject();
        json.put("papers",JSONObject.toJSON(paperTypes));
        return json.toJSONString();
    }
}
