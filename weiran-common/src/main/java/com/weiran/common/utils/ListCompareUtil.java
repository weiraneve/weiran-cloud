package com.weiran.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description:集合
 * @Author wujinzhu@jouav.com
 * @Date 2020/9/27 13:36
 */
public class ListCompareUtil {
    /**
     * 判断两个list是否相等
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E> boolean equalsList(List<E> list1, List<E> list2) {
        // 两个list引用相同（包括两者都为空指针的情况）
        if (list1 == list2) {
            return true;
        }
        // 两个list都为空（包括空指针、元素个数为0）
        if ((list1 == null && list2 != null && list2.size() == 0)
                || (list2 == null && list1 != null && list1.size() == 0)) {
            return true;
        }
        // 两个list元素个数不相同
        if (list1.size() != list2.size()) {
            return false;
        }
        // 两个list元素个数已经相同，再比较两者内容
        // 采用这种可以忽略list中的元素的顺序
        // 涉及到对象的比较是否相同时，确保实现了equals()方法
        if (!list1.containsAll(list2)) {
            return false;
        }

        return true;
    }

    /**
     * 判断List集合是否为空或长度是否等于0
     *
     * @param list
     * @return
     */
    public static Boolean ifListLengthZeroAndNull(List list) {
        return ifObjectLengthZeroAndNull("Collection", list);
    }

    /**
     * 判断对象是否为空或者长度等于0
     *
     * @param type
     * @param obj
     * @return
     */
    private static Boolean ifObjectLengthZeroAndNull(String type, Object obj) {
        if (ifNull(obj)) {
            return true;
        }
        if (ifLengthZero(type, obj)) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    private static Boolean ifNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象长度是否为空（对象不能为null）
     *
     * @param type
     * @param obj
     * @return
     */
    private static Boolean ifLengthZero(String type, Object obj) {
        int length = 0;
        switch (type) {
            case "Collection":
                if(!(obj instanceof  Collection)){
                    throw new RuntimeException("这个不是一个Collection集合");
                }
                length = ((Collection) obj).size();
                break;
            case "Map":
                if(!(obj instanceof Map)){
                    throw new RuntimeException("这个不是一个Map集合");
                }
                length = ((Map) obj).size();
                break;
            case "String":
                if(!(obj instanceof  String)){
                    throw new RuntimeException("这个不是一个String对象");
                }
                length = ((String) obj).length();
                break;
        }
        return length == 0;
    }


    /**
     * 判断Map集合是否为空或长度是否等于0
     *
     * @param map
     * @return
     */
    public static Boolean ifMapLengthZeroAndNull(Map map) {
        return ifObjectLengthZeroAndNull("Map", map);
    }

    /**
     * 判断String集合是否为空或长度是否等于0
     *
     * @param str
     * @return
     */
    public static Boolean ifStringLengthZeroAndNull(String str) {
        return ifObjectLengthZeroAndNull("String", str);
    }

}
