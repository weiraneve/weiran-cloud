package com.weiran.sso.manager.impl;

import com.weiran.sso.model.RoleDO;
import com.weiran.sso.mapper.RoleMapper;
import com.weiran.sso.manager.RoleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Service
public class RoleManagerImpl extends ServiceImpl<RoleMapper, RoleDO> implements RoleManager {

}
