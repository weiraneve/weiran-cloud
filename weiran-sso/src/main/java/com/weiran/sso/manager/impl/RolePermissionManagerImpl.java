package com.weiran.sso.manager.impl;

import com.weiran.sso.model.RolePermissionDO;
import com.weiran.sso.mapper.RolePermissionMapper;
import com.weiran.sso.manager.RolePermissionManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限中间表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Service
public class RolePermissionManagerImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO> implements RolePermissionManager {

}
