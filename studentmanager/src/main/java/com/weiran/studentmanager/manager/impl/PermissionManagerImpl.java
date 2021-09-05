package com.weiran.studentmanager.manager.impl;

import com.weiran.studentmanager.model.PermissionDO;
import com.weiran.studentmanager.mapper.PermissionMapper;
import com.weiran.studentmanager.manager.PermissionManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Weiran
 * @since 2021-09-02
 */
@Service
public class PermissionManagerImpl extends ServiceImpl<PermissionMapper, PermissionDO> implements PermissionManager {

}
