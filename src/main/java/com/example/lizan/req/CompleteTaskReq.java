package com.example.lizan.req;


import lombok.Data;

import java.util.List;

/**
 * @author lizan
 * @version $Id: CompleteTaskReq.java, v 0.1 2022年05月13日 14:05 lizan Exp $$
 */
@Data
public class CompleteTaskReq {


    /**
     * 意见
     */
    private String opinion;
    /**
     * 事件编码
     */
    private String caseCode;

    /**
     * 附件
     */
    private List<EventFileDTO> fileList;



    /**
     * @see TaskTypeEnum
     * 任务类型，treat：处置任务,verify：核实任务,check：核查任务,accept:受理,close:办结,audit:审核,dispatch:分拨。
     */
    private String taskType;

    /**
     * 分派类型，Organization：部门；Grid：网格。
     */
    private String assignerType;

    /**
     * 处置方式，分配到部门时生效；分派到网格时不填值。处理模式。
     * Task_Cooperation_Type  MainCo：主协办 United：联办 Serial:顺序办
     */
    private String cooperationType;

    /**
     * 处置部门列表，分配到部门时生效，可以精确到岗位，也可以精确到用户
     */
    private List<Assigner> assigners;

    /**
     * 处置网格，分配到网格时生效。
     */
    private AssignGrid grid;

    @Data
    public static class Assigner {
        /**
         * 组织编码
         */
        private String orgCode;
        /**
         * 组织名称
         */
        private String orgName;
        /**
         * 岗位编码
         */
        private String postCode;
        /**
         * 用户编码
         */
        private String userCode;
        /**
         * 处置顺序 顺序办
         */
        private String orderNo;
        /**
         * 是否牵头。Y：主办；N：非主办
         */
        private String isLead;

        public Assigner() {

        }

        public Assigner(String regionCode, String orgName) {
            this.orgCode = regionCode;
            this.orgName = orgName;
        }
    }

    @Data
    public class AssignGrid {

        /**
         * 网格类型 最小长度:1 最大长度:64
         */
        private String gridType;

        /**
         * 网格编码，基础网格编码或业务网格编码
         */
        private String gridCode;

    }


    /**
     * 定时分拨时间
     */
    private String quezTime;

    /**
     * 是否回退
     */
    private String backOff;

    /**
     * 抄送部门
     */
    private List<Dept> depts;

    @Data
    public static class Dept {
        public Dept(String deptCode) {
            this.deptCode = deptCode;
        }

        public Dept() {
        }

        /**
         * 部门code
         */
        private String deptCode;

    }

    /**
     * 任务id
     */
    private String taskId;


    /**
     * 审核状态（0:待审核，1:审核通过，2:审核不通过，3:撤销,99:已审核）
     */
    private Integer auditStatus;

    /**
     * 审核意见
     */
    private String auditView;

    /**
     * 流程实例id
     */
    private String processInstanceId;


}