package com.weiran.common.enums;

/**
 * discription: 公共是否选择
 *
 * @author luobin@jouav.com
 * @date 2019/4/26 0026 10:08
 */
public enum CommonWhetherEnum {

    YES("是", 1),
    NO("否", -1),
            ;
    // 成员变量
    private String name;
    private int code;

    // 构造方法
    private CommonWhetherEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
