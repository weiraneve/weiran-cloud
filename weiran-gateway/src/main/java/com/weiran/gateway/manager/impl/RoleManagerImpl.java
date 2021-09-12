package com.weiran.gateway.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weiran.gateway.manager.RoleManager;
import com.weiran.gateway.mapper.RoleMapper;
import com.weiran.gateway.model.RoleDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-02
 */
@Service
public class RoleManagerImpl extends ServiceImpl<RoleMapper, RoleDO> implements RoleManager {

}
