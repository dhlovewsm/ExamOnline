
package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.PaperAnswer;
import com.examonline.service.PaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @version V1.0
 * @author Administrator
 * @date 2019/4/9 11:47
 * @className PaperAnswerController
 * @packageName com.examonline.controller
 * @description 试题答案controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/paperAnswer")
public class PaperAnswerController {

    @Autowired
    private PaperAnswerService paperAnswerService;

    /**
     * 阅卷官阅卷使用，更新主观题的分数
     * @param paperAnswerArray
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "updatePaperAnswer",method = RequestMethod.PUT,produces = {"appilcation/json;charset=utf-8"})
    public String updatePaperAnswer(String paperAnswerArray) throws Exception{
        if (paperAnswerArray == null){
            throw new Exception("参数为空");
        }else {
            List<PaperAnswer> paperAnswers = JSONObject.parseArray(paperAnswerArray,PaperAnswer.class);
            for (PaperAnswer paperAnswer : paperAnswers){
                paperAnswerService.update(paperAnswer);
            }
            return "success";
        }
    }
}
