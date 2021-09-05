package com.weiran.studentmanager.util;


import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @ClassName Encrypt.java
 * @Description md5加密
 */
public class Encrypt {
    public static String md5(String src){ //静态方法
        //采用MD5处理
        try{ MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(src.getBytes()); //加密处理
            //将加密结果output利用Base64转成字符串输出
            String ret = Base64.encodeBase64String(output);
            return ret;
        }catch(Exception e){
            return "";
        }
    }
}
