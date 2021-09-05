package com.weiran.common.utils;

import java.text.DecimalFormat;

/**
 * discription:
 */
public class WorkChangeUtil {

    /**
     * 转换作业总时长
     * @param workDuration
     * @return
     */
    public static String changeDuration(Long workDuration) {
        DecimalFormat df = new DecimalFormat("######0.00");
        //分
        double min = workDuration / 60.0;
        //小时
        double hour = min / 60.0;
        return df.format(hour);
    }

    /**
     * 转换作业总里程
     * @param workMileage
     * @return
     */
    public static String changeMileage(Long workMileage) {
        DecimalFormat df = new DecimalFormat("######0.00");
        double km = workMileage / 1000.0;
        return df.format(km);
    }
}
