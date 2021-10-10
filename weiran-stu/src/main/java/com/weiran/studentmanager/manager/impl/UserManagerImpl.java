package com.weiran.studentmanager.manager.impl;

import com.weiran.studentmanager.model.UserDO;
import com.weiran.studentmanager.mapper.UserMapper;
import com.weiran.studentmanager.manager.UserManager;
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
