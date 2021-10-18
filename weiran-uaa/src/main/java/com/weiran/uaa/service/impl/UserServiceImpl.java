package com.weiran.uaa.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.weiran.uaa.manager.UserManager;
import com.weiran.uaa.model.UserDO;
import com.weiran.uaa.service.UserService;
import com.weiran.uaa.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public AjaxResult login(String username, String password) {
        AjaxResult ajaxResult = new AjaxResult();
        if (StringUtils.isEmpty(username)) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("请填写用户名");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }
        if (StringUtils.isEmpty(password)) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("请填写密码");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }

        // 身份验证
        UserDO userDO = userManager.getOne(Wrappers.<UserDO>lambdaQuery()
                .eq(UserDO::getName, username)
                .eq(UserDO::getPassword, password));
        if (userDO == null) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("用户名或密码错误");
            ajaxResult.setCode(ajaxResult.CODE_ERROR);
            return ajaxResult;
        }

        StpUtil.login(SaSecureUtil.md5(username)); // 这里有个bug，不能用StpUseUtil封装的工具类，否则有bug

        if (!StpUtil.hasRole("student")) {
            ajaxResult.setSuccess(false);
            ajaxResult.setCode(ajaxResult.CODE_WARNING);
            ajaxResult.setMessage("角色认证有问题");
            log.info("角色认证有问题");
        }
        if (!StpUtil.hasPermission("student")) {
            ajaxResult.setSuccess(false);
            ajaxResult.setCode(ajaxResult.CODE_WARNING);
            ajaxResult.setMessage("权限认证有问题");
            log.info("权限认证有问题");
        }

        ajaxResult.setCode(ajaxResult.CODE_SUCCESS);
        ajaxResult.setSuccess(true);
        ajaxResult.setMessage(username + "登陆成功");

        return ajaxResult;
    }
}
