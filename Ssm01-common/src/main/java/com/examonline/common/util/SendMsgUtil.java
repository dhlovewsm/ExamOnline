package com.examonline.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @version V1.0
 * @date 2019/04/03
 * @className SendMsgUtil
 * @packageName com.examonline.common.util
 * @description 调用短信接口类,用于发送短信
 * @author donghao
 * @copyright(C) www.bosssoft.com.cn
 */
public class SendMsgUtil {
    Logger logger = LoggerFactory.getLogger(SendEmailUtil.class);
    //把手机号码和随机验证码传递过来
    public int sendCode(String phoneNumber, String code) throws Exception {

        String str_code = URLEncoder.encode("#code#=" + code, "UTF-8");
        //包装好URL对象，将接口地址包装在此对象中
        URL url = new URL("http://v.juhe.cn/sms/send?mobile=" + phoneNumber +
                "&tpl_id=141166&tpl_value=" + str_code + "&key=4f5c13dd5c877f24a3d1ee5f8137f239");
        /* 短信模板id和 短信应用接口的key */
        //打开连接，得到连接对象
        URLConnection connection = url.openConnection();
        //向服务器发送连接请求
        connection.connect();
        //获得服务器响应的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String lineDate = null;
        while((lineDate = bufferedReader.readLine()) != null) {
            buffer.append(lineDate);
        }
        bufferedReader.close();
        if(buffer.toString().indexOf("\"error_code\":0")>=0 ) {
            logger.info("发送成功");
            return 1;
        }
        logger.error("发送失败");
        return -1;
    }

}