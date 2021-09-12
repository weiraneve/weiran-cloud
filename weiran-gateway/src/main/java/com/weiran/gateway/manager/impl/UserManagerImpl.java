package com.weiran.gateway.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weiran.gateway.manager.UserManager;
import com.weiran.gateway.mapper.UserMapper;
import com.weiran.gateway.model.UserDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表
 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-02
 */
@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, UserDO> implements UserManager {

}
