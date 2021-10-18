package com.weiran.uaa.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.weiran.uaa.manager.PermissionManager;
import com.weiran.uaa.manager.RoleManager;
import com.weiran.uaa.manager.RolePermissionManager;
import com.weiran.uaa.manager.UserManager;
import com.weiran.uaa.model.RoleDO;
import com.weiran.uaa.model.RolePermissionDO;
import com.weiran.uaa.model.UserDO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    private final UserManager userManager;
    private final RoleManager roleManager;
    private final RolePermissionManager rolePermissionManager;
    private final PermissionManager permissionManager;


    /** 返回一个账号所拥有的权限码集合  */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        if (loginType.equals("login")) {
            UserDO userDO = userManager.getOne(Wrappers.<UserDO>lambdaQuery()
                            .eq(UserDO::getLoginId, loginId));
            if (userDO == null) {
                return null; //判断是否为空，保证MP框架返回不报错
            } else {
                int roleId = userDO.getRoleId();
                List<RolePermissionDO> rolePermissionDOList = rolePermissionManager.list(Wrappers.<RolePermissionDO>lambdaQuery()
                        .eq(RolePermissionDO::getRoleId, roleId));
                // 这里不去对对象做存在的判断，因为在数据库中一定会存在关系
                for (RolePermissionDO rolePermissionDO : rolePermissionDOList) {
                    int permissionId = rolePermissionDO.getPermissionId();
                    String permissionCode = permissionManager.getById(permissionId).getPermissionCode();
                    list.add(permissionCode);
                }
            }
        }
        return list;
    }

    /** 返回一个账号所拥有的角色标识集合  */
    @Override
        public List<String> getRoleList(Object loginId, String loginType) {
            List<String> list = new ArrayList<>();
            if (loginType.equals("login")) {
                UserDO userDO = userManager.getOne(Wrappers.<UserDO>lambdaQuery().
                        eq(UserDO::getLoginId, loginId));
                if (userDO == null) {
                    return null; //判断是否为空，保证MP框架返回不报错
                } else {
                    int roleId = userDO.getRoleId();
                    RoleDO roleDO = roleManager.getById(roleId);
                    list.add(roleDO.getName()); // 一个用户只有一个身份
                }
            }
            return list;
        }
}