package com.example.lizan..entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author lizan
 * @since 2022-09-14
 */
@Data
@Accessors(chain = true)
@TableName("training_info")
public class TrainingInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("uid")
    private String uid;

    /**
     * 科室id
     */
    @TableField("depart_id")
    private Long departId;

    /**
     * 培训项目名称
     */
    @TableField("training_project_name")
    private String trainingProjectName;

    /**
     * 主办单位
     */
    @TableField("sponsor_unit")
    private String sponsorUnit;

    /**
     * 培训单位
     */
    @TableField("training_unit")
    private String trainingUnit;

    /**
     * 培训费用状态 10：免费，20：收费
     */
    @TableField("training_fee_status")
    private Integer trainingFeeStatus;

    /**
     * 金额
     */
    @TableField("training_fee")
    private BigDecimal trainingFee;

    /**
     * 列支情况
     */
    @TableField("charge_situation")
    private String chargeSituation;

    /**
     * 培训内容id
     */
    @TableField("training_content_id")
    private Long trainingContentId;

    /**
     * 培训形式id
     */
    @TableField("training_form_id")
    private Long trainingFormId;

    /**
     * 培训渠道id
     */
    @TableField("training_channel_id")
    private Long trainingChannelId;

    /**
     * 是否有关省区市对口支援培训
     */
    @TableField("is_support_training")
    private Integer isSupportTraining;

    /**
     * 培训开始时间
     */
    @TableField("training_start_time")
    private LocalDate trainingStartTime;

    /**
     * 培训结束时间
     */
    @TableField("training_end_time")
    private LocalDate trainingEndTime;

    /**
     * 培训时长
     */
    @TableField("training_duration")
    private Integer trainingDuration;

    /**
     * 获得学时
     */
    @TableField("training_earned_hours")
    private Integer trainingEarnedHours;

    /**
     * 培训通知图片
     */
    @TableField("training_notice_pic")
    private String trainingNoticePic;

    /**
     * 结业正式图片
     */
    @TableField("graduate_certificate_pic")
    private String graduateCertificatePic;

    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

    @TableField("uname")
    private String uname;

    @TableField("is_delete")
    @TableLogic(delval = "1", value = "0")
    private Integer isDelete;


}
