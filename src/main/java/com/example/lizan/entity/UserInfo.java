package com.example.lizan.entity..entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author lizan
 * @since 2022-09-14
 */
@Data
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 修改时间
     */
    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 身份证
     */
    @TableField("identity_code")
    private String identityCode;

    /**
     * 电话号码
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 科室id
     */
    @TableField("depart_id")
    private Long departId;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 现阶段职务
     */
    @TableField("job_level")
    private Long jobLevel;

    /**
     * 0-未删除 1- 已删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 修改人
     */
    @TableField("update_by")
    private String updateBy;


}
