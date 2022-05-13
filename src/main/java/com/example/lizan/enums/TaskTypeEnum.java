package com.example.lizan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wanghao
 * @DateTime: 2022/05/11
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum TaskTypeEnum {
    ACCEPT("accept", "受理任务"),
    DISPATCH("dispatch", "分拨任务"),
    TREAT("treat", "处置任务"),
    CLOSE("close", "办结任务"),
    VERIFY("verify","核实任务"),
    CHECK("check","核查任务"),
    TO_VOID("toVoid","作废任务"),
    COPY("copy", "抄送任务"),
    DOWN("down","下派任务"),
    STAGED("staged","阶段性处置"),
    REPORT("report","上报"),
    AUDIT("audit","审核任务"),
    ;


    private String type;
    private String des;
}
