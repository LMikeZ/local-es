package com.example.lizan.repository.model;

import com.baomidou.mybatisplus.annotation.*;
import com.example.lizan.util.change.LogIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizan
 * @since 2022-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_test_user")
public class TestUser  {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("password")
    @LogIgnore
    private String password;

    @TableField("id_deleted")
    @LogIgnore
    private Boolean idDeleted;

    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @LogIgnore
    private LocalDateTime gmtCreate;


}
