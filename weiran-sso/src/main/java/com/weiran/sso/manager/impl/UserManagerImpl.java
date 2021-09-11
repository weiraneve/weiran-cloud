package com.weiran.sso.manager.impl;

import com.weiran.sso.model.UserDO;
import com.weiran.sso.mapper.UserMapper;
import com.weiran.sso.manager.UserManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表
 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, UserDO> implements UserManager {

}
