package com.weiran.missionplanning.biz.jna.bo;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;

/**
 * discription:
 *
 * @author luobin@weiran.com
 * @date 2021/5/6 0006 16:39
 */
@Structure.FieldOrder({"x", "y"})
public class PointBO extends Structure {

    public X x;

    public Y y;

    /**
     * 构造函数定义
     */
    public PointBO() {
        super();
    }

    public PointBO(Pointer pointer) {
        super(pointer);
    }

    /**
     * 定义取值次序，需要与C/C++中对齐，不然会出现NoSuchFieldError
     */
    @FieldOrder({"x", "col", "pixel"})
    public static class X extends Union {
        public double x;
        public double col;
        public double pixel;
    }

    @FieldOrder({"y", "row", "line"})
    public static class Y extends Union {
        public double y;
        public double row;
        public double line;
    }

    /**
     * 添加2个内部类，分别实现指针类型接口、值类型接口
     */
    public static class ByValue extends PointBO implements Structure.ByValue{}
    public static class ByReference extends PointBO implements Structure.ByReference{}

//    @Override
//    public void read() {
//        super.read();
//        x.setType(X.class);
//        y.setType(Y.class);
//    }
//
//    @Override
//    public void write() {
//        super.write();
//        x.setType(X.class);
//        y.setType(Y.class);
//    }
}
