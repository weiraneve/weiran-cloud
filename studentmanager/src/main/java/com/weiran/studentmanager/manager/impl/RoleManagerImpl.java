package com.weiran.studentmanager.manager.impl;

import com.weiran.studentmanager.model.RoleDO;
import com.weiran.studentmanager.mapper.RoleMapper;
import com.weiran.studentmanager.manager.RoleManager;
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
