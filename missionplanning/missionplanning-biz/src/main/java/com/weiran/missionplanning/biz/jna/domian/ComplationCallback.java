package com.weiran.missionplanning.biz.jna.domian;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;


/**
 * discription:
 *
 * @author jouav
 * @date 2021/4/16 0016 13:02
 */
public interface ComplationCallback extends Callback {

    Boolean myCallBack(Integer eErr, Pointer pResult);
}
