package com.weiran.gateway.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weiran.gateway.manager.RolePermissionManager;
import com.weiran.gateway.mapper.RolePermissionMapper;
import com.weiran.gateway.model.RolePermissionDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限中间表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-02
 */
@Service
public class RolePermissionManagerImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO> implements RolePermissionManager {

}
