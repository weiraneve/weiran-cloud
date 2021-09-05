package com.weiran.missionplanning.biz.jna.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * discription:时间格式
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/9 17:55
 */
public class TimeFormat {
    /**
     * GMT(格林威治标准时间)转换当前北京时间
     *
     * @param GMT 毫秒
     * @return
     */
    public static String stampToString(Long GMT) {
        // TODO 应该是加上时区，但与播放器时间不匹配，所以加了时区的两倍
        long lt = GMT+16*3600000;
        String res = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            res = simpleDateFormat.format(lt);
        }catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }

    public static Date stampToDate(Long GMT) {
        long lt = GMT+16*3600000;
        Date date = null;
        String res = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            res = simpleDateFormat.format(lt);
            date = simpleDateFormat.parse(res);
        }catch (Exception e){
            e.printStackTrace();
        }

        return date;
    }
}
