package com.weiran.sso.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限中间表
 * </p>
 *
 * @author Weiran
 * @since 2021-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role_permission")
public class RolePermissionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID 
     */
    private Integer roleId;

    /**
     * 权限ID
     */
    private Integer permissionId;


}
