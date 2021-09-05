package com.weiran.studentmanager.util;

/**
 * @ClassName SnGenerateUtil.java
 * @Description 随机生成学号
 */
public class SnGenerateUtil {
    //学生学号
    public static String generateSn(int classesId){
        String sn = "";
        sn = "S" + classesId + System.currentTimeMillis();
        return sn;
    }
    //老师工号
    public static String generateTeacherSn(int classesId){
        String sn = "";
        sn = "T" + classesId + System.currentTimeMillis();
        return sn;
    }
}
