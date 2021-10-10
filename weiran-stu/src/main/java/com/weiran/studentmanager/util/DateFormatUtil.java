package com.weiran.studentmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateFormatUtil.java
 * @Description 时间格式化
 */
public class DateFormatUtil {
    public static String getFormatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
