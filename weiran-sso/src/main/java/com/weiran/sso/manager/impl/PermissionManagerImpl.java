package com.weiran.sso.manager.impl;

import com.weiran.sso.model.PermissionDO;
import com.weiran.sso.mapper.PermissionMapper;
import com.weiran.sso.manager.PermissionManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Service
public class PermissionManagerImpl extends ServiceImpl<PermissionMapper, PermissionDO> implements PermissionManager {

}
