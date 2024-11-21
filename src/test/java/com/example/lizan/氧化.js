let newValue = eventData.newValue.value;
let oldValue = eventData.oldValue.value;
let parts = me.name.split(".");
try {

    if (newValue == 1) {
        //获取步骤1工艺名称
        me.checkRecipeName = me.recipeName;
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤1结束时间点管道" + me.tube + ",工艺名称" + me.checkRecipeName);
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤1结束时间点报错:" + err.message);
}
try {

    if (newValue == 6) {
        //获取步骤5结束工艺名称
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
            logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤5结束时间点管道" + me.tube + ",工艺名称" + me.checkRecipeName);
        }
        //更新漏率值
        me.checkLeakageRate = me.leakageRate;
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤5结束时间点管道:" + me.tube + ",漏率：" + me.checkLeakageRate);
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤5结束时间点报错:" + err.message);
}


try {
    if (newValue == 10) {
        //获取步骤9结束时间点
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤9结束时间点管道" + me.tube);
        //氧化时间 第10步骤初始
        me.checkOxidationTime = me.totalRunTime;
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤9结束时间点管道:" + me.tube + ",氧化时间" + me.checkPumpSpeed9);
        //BCl3流量
        //me.checkBCL3Flow9=me.bcl3Flow;
        //logger.info("currentStepUpdate步骤9结束时间点管道:"+me.tube+",BCl3流量"+me.checkBCL3Flow9);
        //SO2流量
        // me.checkSO2Flow9=me.so2Flow;
        //logger.info("currentStepUpdate步骤9结束时间点管道:"+me.tube+",SO2流量"+me.checkSO2Flow9);
        //通源压力
        //me.checkPressure9=me.pressure;
        //logger.info("currentStepUpdate步骤9结束时间点管道:"+me.tube+",通源压力"+me.checkPressure9);
        //工艺总运行时间   9步骤的时间
        // me.runTime_9_11_13=me.totalRunTime-me.runTimeMiddle;
        // logger.info("currentStepUpdate步骤9结束时间点管道:"+me.tube+",9步骤的时间"+me.runTime_9_11_13);
    }
} catch (err) {
    logger.error("currentStepUpdate设备:" + parts[2] + ",步骤9结束时间点报错:" + err.message);
}


try {
    if (newValue == 11) {
        //获取步骤10结束时间点
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤11结束时间点管道" + me.tube);
        //泵速
        me.checkPumpSpeed10 = me.pumpSpeed;
        //温度
        me.checkInTemp1_10 = me.inTemp1;
        me.checkInTemp2_10 = me.inTemp2;
        me.checkInTemp3_10 = me.inTemp3;
        me.checkInTemp4_10 = me.inTemp4;
        me.checkInTemp5_10 = me.inTemp5;
        me.checkInTemp6_10 = me.inTemp6;
        //氮气
        me.checkBn2_10 = me.bn2;
        //氧气
        me.checkO2_10 = me.o2;
        //压力
        me.checkPressure_10 = me.pressure;

        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤11结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed10 +
            ",温度" + me.checkInTemp1_10 + ",氮气" + me.checkBn2_10 + ",氧气" + me.checkO2_10 +
            ",压力" + me.checkPressure_10);
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤11结束时间点报错:" + err.message);


}
try {
    if (newValue == 12) {
        //获取步骤11结束时间点
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤12结束时间点管道" + me.tube);
        //泵速
        me.checkPumpSpeed11 = me.pumpSpeed;
        //温度
        me.checkInTemp1_11 = me.inTemp1;
        me.checkInTemp2_11 = me.inTemp2;
        me.checkInTemp3_11 = me.inTemp3;
        me.checkInTemp4_11 = me.inTemp4;
        me.checkInTemp5_11 = me.inTemp5;
        me.checkInTemp6_11 = me.inTemp6;
        //氮气
        me.checkBn2_11 = me.bn2;
        //氧气
        me.checkO2_11 = me.o2;
        //压力
        me.checkPressure_11 = me.pressure;
        if (me.recipeName == "YH0003") {
            me.checkOxidationTime = me.totalRunTime - me.checkOxidationTime;
        }
        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤12结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed11 +
            ",温度" + me.checkInTemp1_11 + ",氮气" + me.checkBn2_11 + ",氧气" + me.checkO2_11 +
            ",压力" + me.checkPressure_11);
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤12结束时间点报错:" + err.message);


}
try {
    if (newValue == 13) {
        //获取步骤12结束时间点
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
            logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤13结束时间点管道" + me.tube + ",工艺名称" + me.checkRecipeName);
        }
        //泵速
        me.checkPumpSpeed12 = me.pumpSpeed;
        //温度
        me.checkInTemp1_12 = me.inTemp1;
        me.checkInTemp2_12 = me.inTemp2;
        me.checkInTemp3_12 = me.inTemp3;
        me.checkInTemp4_12 = me.inTemp4;
        me.checkInTemp5_12 = me.inTemp5;
        me.checkInTemp6_12 = me.inTemp6;
        //氮气
        me.checkBn2_12 = me.bn2;
        //氧气
        me.checkO2_12 = me.o2;
        //压力
        me.checkPressure_12 = me.pressure;
        if (me.recipeName == "YH0002") {
            me.checkOxidationTime = me.totalRunTime - me.checkOxidationTime;
        }

        logger.info("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤13结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed12 +
            ",温度" + me.checkInTemp1_12 + ",氮气" + me.checkBn2_12 + ",氧气" + me.checkO2_12 +
            ",压力" + me.checkPressure_12);
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",步骤13结束时间点报错:" + err.message);


}


try {
    if (newValue == 0 && oldValue != 1) {
        let nowTime = Date.now();
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
        }
        if (me.checkBn2_10 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkBn2_11 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkBn2_12 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkBn2No == 0) {
            me.checkBn2No = 1;
        }
        if (me.checkO2_10 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkO2_11 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkO2_12 != 0) {
            me.checkBn2No = me.checkBn2No + 1;
        }
        if (me.checkO2No == 0) {
            me.checkO2No = 1;
        }
        if (me.checkPressure_10 != 0) {
            me.checkPressureNo = me.checkPressureNo + 1;
        }
        if (me.checkPressure_11 != 0) {
            me.checkPressureNo = me.checkPressureNo + 1;
        }
        if (me.checkPressure_12 != 0) {
            me.checkPressureNo = me.checkPressureNo + 1;
        }
        if (me.checkPressureNo == 0) {
            me.checkPressureNo = 1;
        }
        logger.info("oxidation_currentStepUpdate大循环结束时间点设备:" + parts[2] + ",管道" + me.tube + "时间" + nowTime + ",工艺名称" + me.checkRecipeName);
        Things["TS.ELEC.ProcessCheck.DB"].insertOxidationProcessCheck({
            machineId: parts[2] /* STRING */,
            name: me.machineName /* STRING [Required] */,
            dateDay: nowTime /* DATETIME */,
            tube: me.tube /* INTEGER */,
            recipeName: me.checkRecipeName /* STRING */,
            pumpSpeed: ((me.checkPumpSpeed10 + me.checkPumpSpeed11 + me.checkPumpSpeed12) / 3).toFixed(2) /* NUMBER */,
            leakageRate: me.checkLeakageRate /* NUMBER */,
            oxidationTime: me.checkOxidationTime /* INTEGER */,
            highTemperatureAdvanceTime: me.runTime_15_16 /* INTEGER */,
            //temperature1: ((me.checkInTemp1_10+me.checkInTemp1_11+me.checkInTemp1_12)/3).toFixed(2) /* NUMBER */,
            //temperature2: ((me.checkInTemp2_10+me.checkInTemp2_11+me.checkInTemp2_12)/3).toFixed(2) /* NUMBER */,
            //temperature3: ((me.checkInTemp3_10+me.checkInTemp3_11+me.checkInTemp3_12)/3).toFixed(2) /* NUMBER */,
            //temperature4: ((me.checkInTemp4_10+me.checkInTemp4_11+me.checkInTemp4_12)/3).toFixed(2) /* NUMBER */,
            //temperature5: ((me.checkInTemp5_10+me.checkInTemp5_11+me.checkInTemp5_12)/3).toFixed(2) /* NUMBER */,
            //temperature6: ((me.checkInTemp6_10+me.checkInTemp6_11+me.checkInTemp6_12)/3).toFixed(2) /* NUMBER */,
            temperature1: me.checkInTemp1_10.toFixed(2) /* NUMBER */,
            temperature2: me.checkInTemp2_10.toFixed(2) /* NUMBER */,
            temperature3: me.checkInTemp3_10.toFixed(2) /* NUMBER */,
            temperature4: me.checkInTemp4_10.toFixed(2) /* NUMBER */,
            temperature5: me.checkInTemp5_10.toFixed(2) /* NUMBER */,
            temperature6: me.checkInTemp6_10.toFixed(2) /* NUMBER */,
            bn2: ((me.checkBn2_10 + me.checkBn2_11 + me.checkBn2_12) / me.checkBn2No).toFixed(2)/* NUMBER */,
            o2: ((me.checkO2_10 + me.checkO2_11 + me.checkO2_12) / me.checkO2No).toFixed(2) /* NUMBER */,
            pressure: ((me.checkPressure_10 + me.checkPressure_11 + me.checkPressure_12) / me.checkPressureNo).toFixed(2) /* NUMBER */

        });
        logger.info("oxidation_currentStepUpdate写入数据库管道:" + me.tube);
        //把其他字段  置为0  以防上一循环在下次使用
        me.checkLeakageRate = 0;
        me.checkBn2_10 = 0;
        me.checkBn2_11 = 0;
        me.checkBn2_12 = 0;
        me.checkO2_10 = 0;
        me.checkO2_11 = 0;
        me.checkO2_12 = 0;
        me.checkInTemp1_10 = 0;
        me.checkInTemp2_10 = 0;
        me.checkInTemp3_10 = 0;
        me.checkInTemp4_10 = 0;
        me.checkInTemp5_10 = 0;
        me.checkInTemp6_10 = 0;
        me.checkInTemp1_11 = 0;
        me.checkInTemp2_11 = 0;
        me.checkInTemp3_11 = 0;
        me.checkInTemp4_11 = 0;
        me.checkInTemp5_11 = 0;
        me.checkInTemp6_11 = 0;
        me.checkInTemp1_12 = 0;
        me.checkInTemp2_12 = 0;
        me.checkInTemp3_12 = 0;
        me.checkInTemp4_12 = 0;
        me.checkInTemp5_12 = 0;
        me.checkInTemp6_12 = 0;
        me.checkPressure_10 = 0;
        me.checkPressure_11 = 0;
        me.checkPressure_12 = 0;
        me.checkOxidationTime = 0;
        me.checkLeakageRate = 0;
        me.checkPumpSpeed10 = 0;
        me.checkPumpSpeed11 = 0;
        me.checkPumpSpeed12 = 0;
    }
} catch (err) {
    logger.error("oxidation_currentStepUpdate设备:" + parts[2] + ",大循环结束时间点报错:" + err.message);
}