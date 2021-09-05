package com.weiran.common.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.jouav.jouavcloud.common.code.CodeDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * discription:
 *
 * @author luobin@jouav.com
 * @date 2019/10/25 0025 10:17
 */
@RestControllerAdvice
public class CustomExtHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);


    //捕获全局异常,处理所有不可知的异常
    @ExceptionHandler(value=Exception.class)
    Object handleException(Exception ex,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        //判断返回异常类型是否是自定义
        if(ex instanceof BusinessException){
            attributes.put("code", 400);
        } else if (ex instanceof MyException) {
            attributes.put("code", ((MyException) ex).getCode());
            attributes.put("msg", ((MyException) ex).getMsg());
        } else if (ex instanceof AuthenticationException) {
            attributes.put("code", 400);
            attributes.put("msg", "token过期,请重新登录");
        } else if (ex instanceof AccessDeniedException) {
            attributes.put("code", CodeDesc.NO_AUTHORITY.getCode());
            attributes.put("msg", CodeDesc.NO_AUTHORITY.getName());
        } else if (ex instanceof HttpMessageNotReadableException) {
            attributes.put("code", 400);
            attributes.put("msg", "参数请求格式错误, 具体信息：" + ex.getLocalizedMessage());
            attributes.put("data", ex.getLocalizedMessage());
        } else if(ex instanceof HttpRequestMethodNotSupportedException) {
            attributes.put("code", 400);
            attributes.put("msg", "请求方式错误, 具体信息：" + ex.getLocalizedMessage());
            attributes.put("data", ex.getLocalizedMessage());
        }
        else {
            attributes.put("code", 400);
            attributes.put("msg", "请求失败, 具体信息：" + ex.getLocalizedMessage());
            attributes.put("data", ex.getLocalizedMessage());
        }
        if (attributes.get("msg") == null) {
            attributes.put("msg", ex.getMessage());
        }
        attributes.put("data", new HashMap());
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }

    /**
     * 功能描述: 处理自定义异常类
     * @return
     *
     */
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(MyException e, HttpServletRequest request){
        //进行页面跳转
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;

        //f返回json数据
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("msg", "请求失败");
        return map;
    }
}
