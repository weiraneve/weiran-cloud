package com.weiran.uaa.manager.impl;

import com.weiran.uaa.model.RoleDO;
import com.weiran.uaa.mapper.RoleMapper;
import com.weiran.uaa.manager.RoleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
