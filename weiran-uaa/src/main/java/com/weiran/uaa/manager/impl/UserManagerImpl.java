package com.weiran.uaa.manager.impl;

import com.weiran.uaa.model.UserDO;
import com.weiran.uaa.mapper.UserMapper;
import com.weiran.uaa.manager.UserManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
