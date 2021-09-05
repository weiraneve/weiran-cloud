package com.weiran.missionplanning.biz.jna.common;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：  geojson 坐标位置替换（纬经---> 经纬）
 * @Author: aoxiaoqin@weiran.com
 * @Date: 2021/7/8 15:24
 **/
public class CoordinatesUtil {

    /**
     *  替换位置
     * @param jsonArray
     * @return
     */
    public static JSONArray jsonArray(JSONArray jsonArray){
        Double one = jsonArray.getDouble(0);
        jsonArray.set(0,jsonArray.getDouble(1));
        jsonArray.set(1,one);
        return jsonArray;
    }

    /**
     *  返回新的坐标集合
     * @param coordinates
     * @return
     */
    public static  List<List<JSONArray>> getNewCoordinates(JSONArray coordinates) {
        List<List<JSONArray>> coordinatesList = new ArrayList<>();
        for (int n = 0; n < coordinates.size(); n++) {
            List<JSONArray> arrays = new ArrayList<>();
            JSONArray list = coordinates.getJSONArray(n);
            for (int z = 0; z < list.size(); z++) {
                JSONArray newJsonArray = list.getJSONArray(z);
                arrays.add(jsonArray(newJsonArray));
            }
            coordinatesList.add(arrays);
        }
        return coordinatesList;
    }
}
