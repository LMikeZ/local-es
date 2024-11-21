let newValue = eventData.newValue.value;
let oldValue = eventData.oldValue.value;

try {
    if (newValue == 1) {
        //获取步骤开始工艺名称
        me.checkProcessName = me.processName;
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤1结束时间点管道:" + me.tube + ",工艺名称" + me.checkProcessName);
    }
} catch (err) {
    logger.error("pcCraftWorkStepIPUpdate步骤1结束时间点报错:" + err.message);
}
try {
    if (newValue == 9) {
        //获取步骤5结束时间点
        if (me.checkProcessName == "" || me.checkProcessName == null) {
            me.checkProcessName = me.processName;
        }
        //更新漏率值
        me.checkLeakageRate = me.leakageRate;
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤8结束时间点管道:" + me.tube + ",漏率：" + me.checkLeakageRate + ",工艺名称" + me.checkProcessName
        );
    }
} catch (err) {
    logger.error("pcCraftWorkStepIPUpdate步骤8结束时间点报错:" + err.message);
}


try {
    if (newValue == 11) {
        //氮气N2
        me.checkFlowPV1_11 = me.flowPV1;
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤11结束时间点管道:" + me.tube + ",N2氮气：" + me.checkFlowPV1_11);
        //泵速
        me.checkPumpSpeed_11 = me.pumpSpeed;
        logger.info("pcCraftWorkStepIPUpdate步骤11结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed_11);
        //更新漏率值
        me.pcCraftWorkStepTimeTotalPass_11 = me.pcCraftWorkStepTimeTotalPass;
        logger.info("pcCraftWorkStepIPUpdate步骤10结束时间点管道:" + me.tube + ",总运行时间：" + me.pcCraftWorkStepTimeTotalPass_11);
    }
} catch (err) {
    logger.error("pcCraftWorkStepIPUpdate步骤10结束时间点报错:" + err.message);
}

try {
    if (newValue == 12) {
        //获取步骤11结束时间点


        //氧气O2
        me.checkFlowPV6_11 = me.flowPV6;
        logger.info("pcCraftWorkStepIPUpdate步骤11结束时间点管道:" + me.tube + ",氧气O2：" + me.checkFlowPV6_11);

        //压力
        me.checkPressSV_11 = me.pressSV;
        logger.info("pcCraftWorkStepIPUpdate步骤11结束时间点管道:" + me.tube + ",管压" + me.checkPressSV_11);
        //退火时间
        // me.pcCraftWorkStepTimeTotalPass_11=me.pcCraftWorkStepTimeTotalPass;
        // logger.info("pcCraftWorkStepIPUpdate步骤12开始时间点管道:"+me.tube+",退火时间"+me.pcCraftWorkStepTimeTotalPass_11);
        //w温度
        me.checkTempSV1 = me.TempSV1;
        me.checkTempSV2 = me.TempSV2;
        me.checkTempSV3 = me.TempSV3;
        me.checkTempSV4 = me.TempSV4;
        me.checkTempSV5 = me.TempSV5;
        me.checkTempSV6 = me.TempSV6;
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤12结束时间点checkTempSV1:" + me.checkTempSV1 + ",checkTempSV2" + me.checkTempSV2 +
            "checkTempSV3" + me.checkTempSV3 + "checkTempSV4" + me.checkTempSV4 + "checkTempSV5" + me.checkTempSV5 + "checkTempSV6" + me.checkTempSV6);
        //氮气N2
        me.checkFlowPV1_12 = me.flowPV1;
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤12结束时间点管道:" + me.tube + ",N2氮气：" + me.checkFlowPV1_12);
        //泵速
        me.checkPumpSpeed_12 = me.pumpSpeed;
        logger.info("pcCraftWorkStepIPUpdate步骤12结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed_12);
    }
} catch (err) {
    logger.error("pcCraftWorkStepIPUpdate步骤11结束时间点报错:" + err.message);
}


try {
    if (newValue == 13) {
        //工艺名称
        if (me.checkProcessName == "" || me.checkProcessName == null) {
            me.checkProcessName = me.processName;
            logger.info("pcCraftWorkStepIPUpdate" + me.name + "步骤12结束时间点管道:" + me.tube + ",工艺名称：" + me.processName);
        }

        //氧气O2
        me.checkFlowPV6_12 = me.flowPV6;
        logger.info("pcCraftWorkStepIPUpdate步骤12结束时间点管道:" + me.tube + ",氧气：" + me.checkFlowPV6_12);

        //压力
        me.checkPressSV_12 = me.pressSV;
        logger.info("pcCraftWorkStepIPUpdate步骤12结束时间点管道:" + me.tube + ",管压" + me.checkPressSV_12);

        //退火时间
        me.pcCraftWorkStepTimeTotalPass_13 = me.pcCraftWorkStepTimeTotalPass;
        logger.info("pcCraftWorkStepIPUpdate步骤12结束时间点管道:" + me.tube + ",退火时间" + me.pcCraftWorkStepTimeTotalPass_13);


    }
} catch (err) {
    logger.error("pcCraftWorkStepIPUpdate步骤13开始时间点报错:" + err.message);
}


try {
    if (newValue == 0 && oldValue != 1) {

        let nowTime = Date.now();
        if (me.checkProcessName == "" || me.checkProcessName == null) {
            me.checkProcessName = me.processName;
        }
        if (me.checkFlowPV1_11 != 0) {
            me.checkFlowPV1No = me.checkFlowPV1No + 1;
        }
        if (me.checkFlowPV1_12 != 0) {
            me.checkFlowPV1No = me.checkFlowPV1No + 1;
        }
        if (me.checkFlowPV6_11 != 0) {
            me.checkFlowPV6No = me.checkFlowPV6No + 1;
        }
        if (me.checkFlowPV6_12 != 0) {
            me.checkFlowPV6No = me.checkFlowPV6No + 1;
        }
        if (me.checkPressSV_11 != 0) {
            me.checkPressSVNo = me.checkPressSVNo + 1;
        }
        if (me.checkPressSV_12 != 0) {
            me.checkPressSVNo = me.checkPressSVNo + 1;
        }
        if (me.checkFlowPV1No == 0) {
            me.checkFlowPV1No = 1;
        }
        if (me.checkFlowPV6No == 0) {
            me.checkFlowPV6No = 1;
        }
        if (me.checkPressSVNo == 0) {
            me.checkPressSVNo = 1;
        }
        logger.info("pcCraftWorkStepIPUpdate" + me.name + "大循环结束时间点管道" + me.tube + ",点位工艺名称" + me.checkProcessName + me.checkTempSV1 + me.checkTempSV2 + me.checkTempSV3 + me.checkTempSV4 + me.checkTempSV5 + me.checkTempSV6 + me.checkTime_T1 + me.checkTime_T2 + me.checkTime_T3 + me.checkTime_T4 + me.checkTime_T5 + me.checkTime_T6);

        Things["TS.ELEC.ProcessCheck.DB"].insertAnnealProcessCheck({
            machineId: me.machineID /* STRING */,
            name: me.machineName /* STRING [Required] */,
            dateDay: nowTime /* DATETIME */,
            tube: me.tube /* INTEGER */,
            recipeName: me.checkProcessName /* STRING */,
            pumpSpeed: ((me.checkPumpSpeed_12 + me.checkPumpSpeed_11) / 2).toFixed(2) /* NUMBER */,
            leakageRate: me.checkLeakageRate /* NUMBER */,
            annealTime: me.pcCraftWorkStepTimeTotalPass_13 - me.pcCraftWorkStepTimeTotalPass_11 /* INTEGER */,
            temperature1: me.checkTempSV1/* NUMBER */,
            temperature2: me.checkTempSV2/* NUMBER */,
            temperature3: me.checkTempSV3/* NUMBER */,
            temperature4: me.checkTempSV4/* NUMBER */,
            temperature5: me.checkTempSV5/* NUMBER */,
            temperature6: me.checkTempSV6/* NUMBER */,
            n2: ((me.checkFlowPV1_11 + me.checkFlowPV1_12) / me.checkFlowPV1No).toFixed(2)/* NUMBER */,
            o2: ((me.checkFlowPV6_11 + me.checkFlowPV6_12) / me.checkFlowPV6No).toFixed(2)/* NUMBER */,
            pressure: ((me.checkPressSV_11 + me.checkPressSV_12) / me.checkPressSVNo).toFixed(2)/* NUMBER */,
            timeT1: me.checkTime_T1 - me.checkTime890_T1/* INTEGER */,
            timeT2: me.checkTime_T2 - me.checkTime890_T2/* INTEGER */,
            timeT3: me.checkTime_T3 - me.checkTime890_T3/* INTEGER */,
            timeT4: me.checkTime_T4 - me.checkTime890_T4/* INTEGER */,
            timeT5: me.checkTime_T5 - me.checkTime890_T5/* INTEGER */,
            timeT6: me.checkTime_T6 - me.checkTime890_T6/* INTEGER */,
            tempIn1: me.checkTempInMax1 - me.checkTempInMin1,
            tempIn2: me.checkTempInMax2 - me.checkTempInMin2,
            tempIn3: me.checkTempInMax3 - me.checkTempInMin3,
            tempIn4: me.checkTempInMax4 - me.checkTempInMin4,
            tempIn5: me.checkTempInMax5 - me.checkTempInMin5,
            tempIn6: me.checkTempInMax6 - me.checkTempInMin6
        });
        //把其他字段  置为0  以防上一循环在下次使用
        me.checkTempInMin1 = 0;
        me.checkTempInMin2 = 0;
        me.checkTempInMin3 = 0;
        me.checkTempInMin4 = 0;
        me.checkTempInMin5 = 0;
        me.checkTempInMin6 = 0;
        me.checkTempInMax1 = 0;
        me.checkTempInMax2 = 0;
        me.checkTempInMax3 = 0;
        me.checkTempInMax4 = 0;
        me.checkTempInMax5 = 0;
        me.checkTempInMax6 = 0;
        me.checkPressSVNo = 0;
        me.checkFlowPV6No = 0;
        me.checkFlowPV1No = 0;
        me.checkLeakageRate = 0;
        me.pcCraftWorkStepTimeTotalPass_11 = 0;
        me.checkPumpSpeed_11 = 0;
        me.checkFlowPV1_11 = 0;
        me.checkFlowPV6_11 = 0;
        me.checkPressSV_11 = 0;
        me.checkPumpSpeed_12 = 0;
        me.checkFlowPV1_12 = 0;
        me.checkFlowPV6_12 = 0;
        me.checkPressSV_12 = 0;
        me.pcCraftWorkStepTimeTotalPass_13 = 0;
        me.pcCraftWorkStepTimeTotalPass_11 = 0;
        me.pcCraftWorkStepTimePass = 0;
        me.checkTime_T1_Count = 0;
        me.checkTime_T2_Count = 0;
        me.checkTime_T3_Count = 0;
        me.checkTime_T4_Count = 0;
        me.checkTime_T5_Count = 0;
        me.checkTime_T6_Count = 0;
        me.checkTime890_T1_Count = 0;
        me.checkTime890_T2_Count = 0;
        me.checkTime890_T3_Count = 0;
        me.checkTime890_T4_Count = 0;
        me.checkTime890_T5_Count = 0;
        me.checkTime890_T6_Count = 0;
        me.checkTime_T1 = 0;
        me.checkTime_T2 = 0;
        me.checkTime_T3 = 0;
        me.checkTime_T4 = 0;
        me.checkTime_T5 = 0;
        me.checkTime_T6 = 0;
        me.checkTime890_T1 = 0;
        me.checkTime890_T2 = 0;
        me.checkTime890_T3 = 0;
        me.checkTime890_T4 = 0;
        me.checkTime890_T5 = 0;
        me.checkTime890_T6 = 0;
        me.checkTempSV1 = 0;
        me.checkTempSV2 = 0;
        me.checkTempSV3 = 0;
        me.checkTempSV4 = 0;
        me.checkTempSV5 = 0;
        me.checkTempSV6 = 0;

    }
} catch (err) {
    //把其他字段  置为0  以防上一循环在下次使用

    me.checkTempInMin1 = 0;
    me.checkTempInMin2 = 0;
    me.checkTempInMin3 = 0;
    me.checkTempInMin4 = 0;
    me.checkTempInMin5 = 0;
    me.checkTempInMin6 = 0;
    me.checkTempInMax1 = 0;
    me.checkTempInMax2 = 0;
    me.checkTempInMax3 = 0;
    me.checkTempInMax4 = 0;
    me.checkTempInMax5 = 0;
    me.checkTempInMax6 = 0;
    me.checkPressSVNo = 0;
    me.checkFlowPV6No = 0;
    me.checkFlowPV1No = 0;
    me.checkLeakageRate = 0;
    me.pcCraftWorkStepTimeTotalPass_11 = 0;
    me.checkPumpSpeed_11 = 0;
    me.checkFlowPV1_11 = 0;
    me.checkFlowPV6_11 = 0;
    me.checkPressSV_11 = 0;
    me.checkPumpSpeed_12 = 0;
    me.checkFlowPV1_12 = 0;
    me.checkFlowPV6_12 = 0;
    me.checkPressSV_12 = 0;
    me.pcCraftWorkStepTimeTotalPass_13 = 0;
    me.pcCraftWorkStepTimeTotalPass_11 = 0;
    me.pcCraftWorkStepTimePass = 0;
    me.checkTime_T1_Count = 0;
    me.checkTime_T2_Count = 0;
    me.checkTime_T3_Count = 0;
    me.checkTime_T4_Count = 0;
    me.checkTime_T5_Count = 0;
    me.checkTime_T6_Count = 0;
    me.checkTime890_T1_Count = 0;
    me.checkTime890_T2_Count = 0;
    me.checkTime890_T3_Count = 0;
    me.checkTime890_T4_Count = 0;
    me.checkTime890_T5_Count = 0;
    me.checkTime890_T6_Count = 0;
    me.checkTime_T1 = 0;
    me.checkTime_T2 = 0;
    me.checkTime_T3 = 0;
    me.checkTime_T4 = 0;
    me.checkTime_T5 = 0;
    me.checkTime_T6 = 0;
    me.checkTime890_T1 = 0;
    me.checkTime890_T2 = 0;
    me.checkTime890_T3 = 0;
    me.checkTime890_T4 = 0;
    me.checkTime890_T5 = 0;
    me.checkTime890_T6 = 0;
    me.checkTempSV1 = 0;
    me.checkTempSV2 = 0;
    me.checkTempSV3 = 0;
    me.checkTempSV4 = 0;
    me.checkTempSV5 = 0;
    me.checkTempSV6 = 0;
    logger.error("pcCraftWorkStepIPUpdate:大循环结束时间点报错:" + err.message);
}