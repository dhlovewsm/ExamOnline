
package com.examonline.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.*;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/10 9:28
 * @className Base64Util
 * @packageName com.examonline.common.util
 */

public class Base64Util {

    public String GetImageStr(String imgPath)
    {
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    //base64字符串转化成图片
    public boolean GenerateImage(String imgStr,String targetPath)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null){
            //图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(targetPath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void toFile(String base64Code,String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

}
