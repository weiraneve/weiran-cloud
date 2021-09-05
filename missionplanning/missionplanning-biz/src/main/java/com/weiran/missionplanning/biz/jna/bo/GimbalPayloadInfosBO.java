package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * discription:吊舱数据
 *
 * @author wujinzhu@weiran.com
 * @date 2021/7/21 11:22
 */
public class GimbalPayloadInfosBO extends Structure {
    public GimbalPayloadInfosBO (){
        super(ALIGN_NONE);
    }
    public GimbalPayloadInfosBO(Pointer pointer){
        super(pointer);
    }

    public GimbalPosInfoBO.ByValue GimbalPosInfo_p; //吊舱pos数据
    public GimbalStatusInfoBO.ByValue GimbalStatusInfo_p;  //吊舱状态数据
    public ImageProcessingBoardInfoBO.ByValue ImageProcessingBoardInfo_p; //图像处理板数据

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByReference extends GimbalPayloadInfosBO implements Structure.ByReference {}
    public static class ByValue extends GimbalPayloadInfosBO implements Structure.ByValue{}

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"GimbalPosInfo_p", "GimbalStatusInfo_p", "ImageProcessingBoardInfo_p"});
    }

}
