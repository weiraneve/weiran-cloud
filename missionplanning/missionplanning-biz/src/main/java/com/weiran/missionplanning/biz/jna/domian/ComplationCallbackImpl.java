package com.weiran.missionplanning.biz.jna.domian;

import com.weiran.missionplanning.biz.jna.common.CommonMission;
import com.weiran.missionplanning.biz.jna.common.PlanZoneState;
import com.weiran.missionplanning.biz.jna.mission.MissionJnaService;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/5/17 0017 16:14
 */
public class ComplationCallbackImpl implements ComplationCallback{


    public Pointer[] zonehList;

    public IntByReference count = new IntByReference(0);

    @Override
    public Boolean myCallBack(Integer eErr, Pointer pResult) {
        if (eErr != 0) {
            return false;
        }
        //String json;
        if (pResult != null)
        {
            Pointer planh = pResult;
            int aa = MissionJnaService.INSTANCE.mission_plan_get_zones_count(planh);
            zonehList = new Pointer[aa];
            MissionJnaService.INSTANCE.mission_plan_get_zones(planh, zonehList, count);
            System.out.println("count = " + count.getValue());
            int routeCount = MissionJnaService.INSTANCE.mission_plan_get_route_count(planh);
            Pointer[] waypointList = new Pointer[routeCount];
            int co = 0;
            IntByReference waypointcount = new IntByReference(co);
            System.out.println("waypointcount = " + waypointcount.getValue());
            MissionJnaService.INSTANCE.mission_plan_get_route(planh, waypointList, waypointcount);
            System.out.println("waypointcount = " + waypointcount.getValue());
            if (routeCount > 0 && waypointcount.getValue() > 0 )
            {
                System.out.println("=====================进入回调=====================");
                for(int i = 0; i < count.getValue(); i++) {
                    System.out.println("----------------" + Pointer.nativeValue(zonehList[i]));
                    CommonMission.PLAN_STATE.put(Pointer.nativeValue(zonehList[i]), PlanZoneState.generated);
                }
                String aaa = MissionJnaService.INSTANCE.mission_plan_to_json(planh);
                System.out.println("==============" + aaa);
                System.out.println("waypointcount = " + waypointcount.getValue());
            }
        }
        System.out.println("**********************generated route data************************\n");
        return true;
    }
}
