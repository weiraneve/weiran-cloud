package com.weiran.missionplanning.biz.jna.common;

/**
 * discription:飞行状态
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/22 13:16
 */
public class FlightState {

    /**
     * 飞机飞行状态
     * @param state
     * @return
     */
    public  String getFlightState(int state){
        String flightState = "";
        if (state == 0){
            flightState =  "地面测试";
        }
        if (state == 1){
            flightState =  "飞前检查";
        }
        if (state == 2){
            flightState =  "姿态辅助";
        }
        if (state == 3){
            flightState =  "悬停辅助";
        }
        if (state == 4){
            flightState =  "离地";
        }
        if (state == 5){
            flightState =  "爬升";
        }
        if (state == 6){
            flightState =  "加速";
        }
        if (state == 7){
            flightState =  "垂转平";
        }
        if (state == 8){
            flightState =  "飞行";
        }if (state == 9){
            flightState =  "降落";
        }
        if (state == 10){
            flightState =  "减速";
        }
        if (state == 11){
            flightState =  "平转垂";
        }
        if (state == 12){
            flightState =  "末端悬停";
        }
        if (state == 13){
            flightState =  "末端下降";
        }
        if (state == 14){
            flightState =  "迫降";
        }
        if (state == 15){
            flightState =  "AHRS迫降";
        }
        if (state == 16){
            flightState =  "半自动辅助";
        }
        if (state == 17){
            flightState =  "半自动垂转平";
        }
        if (state == 18){
            flightState =  "半自动平转垂";
        }
        if (state == 19){
            flightState =  "即时悬停";
        }
        if (state == 20){
            flightState =  "自毁";
        }

        return flightState;
    }

    /**
     * GPS状态
     * @param state
     * @return
     */
    public String getGPSState(int state){
        String gpsState = "";
        if (state == 0){
            gpsState = "RTK";
        }
        if (state == 1){
            gpsState = "SINGLE";
        }
        return gpsState;
    }
}
