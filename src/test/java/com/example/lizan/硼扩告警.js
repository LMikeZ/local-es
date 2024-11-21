let newValue = eventData.newValue.value;
let oldValue = eventData.oldValue.value;
try {
    if (newValue == 1) {
        //获取步骤1结束工艺名称
        me.checkRecipeName = me.recipeName;
        logger.info("currentStepUpdate" + me.name + "步骤1结束时间点管道:" + me.tube + ",工艺名称：" + me.checkRecipeName);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤1结束时间点报错:" + err.message);
}

try {
    if (newValue == 6) {
        //获取步骤5结束时间点
        logger.info("currentStepUpdate步骤5结束时间点管道" + me.tube);
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
            logger.info("currentStepUpdate" + me.name + "步骤5结束时间点管道:" + me.tube + ",工艺名称：" + me.checkRecipeName);
        }
        //更新漏率值
        me.checkLeakageRate = me.leakageRate;
        logger.info("currentStepUpdate步骤5结束时间点管道:" + me.tube + ",漏率：" + me.checkLeakageRate);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤5结束时间点报错:" + err.message);
}

try {
    if (newValue == 9) {
        //步骤9开始时间
        logger.info("currentStepUpdate步骤9开始时间点管道" + me.tube);
        //工艺总运行时间
        me.runTimeMiddle = me.totalRunTime;
        logger.info("currentStepUpdate步骤9开始时间点管道:" + me.tube + ",总运行时间：" + me.runTimeMiddle);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤9开始时间点报错:" + err.message);
}


try {
    if (newValue == 10) {
        //获取步骤9结束时间点
        logger.info("currentStepUpdate步骤9结束时间点管道" + me.tube);
        //泵速
        me.checkPumpSpeed9 = me.pumpSpeed;
        logger.info("currentStepUpdate步骤9结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed9);
        //BCl3流量
        // me.checkBCL3Flow9 = me.bcl3Flow;
        // logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤9结束时间点,BCl3流量" + me.checkBCL3Flow9);
        //SO2流量
        // me.checkSO2Flow9=me.so2Flow;
        //logger.info("currentStepUpdate步骤9结束时间点管道:"+me.tube+",SO2流量"+me.checkSO2Flow9);
        //通源压力
        me.checkPressure9 = me.pressure;
        logger.info("currentStepUpdate步骤9结束时间点管道:" + me.tube + ",通源压力" + me.checkPressure9);
        //工艺总运行时间   9步骤的时间
        me.runTime_9_11_13 = me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤9结束时间点管道:" + me.tube + ",9步骤的时间" + me.runTime_9_11_13);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤9结束时间点报错:" + err.message);
}


try {
    if (newValue == 11) {
        //获取步骤10结束时间点
        logger.info("currentStepUpdate步骤10结束时间点管道" + me.tube);

        me.checkBCL3Flow10 = me.bcl3Flow;
        logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤10结束时间点,BCl3流量" + me.checkBCL3Flow10);
        me.runTimeMiddle = me.totalRunTime;
        logger.info("currentStepUpdate步骤10结束时间点管道:" + me.tube + ",时间" + me.runTimeMiddle);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤10结束时间点报错:" + err.message);
}


try {
    if (newValue == 12) {
        //BCl3流量
        // me.checkBCL3Flow11 = me.bcl3Flow;
        // logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤11结束时间点,BCl3流量" + me.checkBCL3Flow11);
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
            logger.info("currentStepUpdate" + me.name + "步骤11结束时间点管道:" + me.tube + ",工艺名称：" + me.checkRecipeName);
        }
        //获取步骤11结束时间点
        logger.info("currentStepUpdate步骤11结束时间点管道" + me.tube);
        //泵速
        me.checkPumpSpeed11 = me.pumpSpeed;
        logger.info("currentStepUpdate步骤11结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed11);

        //SO2流量
        // me.checkSO2Flow11 = me.so2Flow;
        //logger.info("currentStepUpdate步骤11结束时间点管道:"+me.tube+",SO2流量"+me.checkSO2Flow11);
        //通源压力
        me.checkPressure11 = me.pressure;
        logger.info("currentStepUpdate步骤11结束时间点管道:" + me.tube + ",通源压力" + me.checkPressure11);
        //工艺总运行时间   11步骤的时间
        me.runTime_9_11_13 = me.runTime_9_11_13 + me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤11结束时间点管道:" + me.tube + ",时间" + me.runTime_9_11_13);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤11结束时间点报错:" + err.message);
}


try {
    if (newValue == 13) {
        //获取步骤13开始时间点
        logger.info("currentStepUpdate步骤13开始时间点管道" + me.tube);
        me.checkBCL3Flow12 = me.bcl3Flow;
        logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤12结束时间点,BCl3流量" + me.checkBCL3Flow12);
        me.runTimeMiddle = me.totalRunTime;
        logger.info("currentStepUpdate步骤13开始时间点管道:" + me.tube + ",时间" + me.runTimeMiddle);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤13开始时间点报错:" + err.message);
}


try {
    if (newValue == 14) {
        //获取步骤13结束时间点
        logger.info("currentStepUpdate步骤13结束时间点管道" + me.tube);
        //泵速
        me.checkPumpSpeed13 = me.pumpSpeed;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed13);
        //BCl3流量
        // me.checkBCL3Flow13 = me.bcl3Flow;
        // logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤13结束时间点,BCl3流量" + me.checkBCL3Flow13);
        //SO2流量
        //me.checkSO2Flow13=me.so2Flow;
        //logger.info("currentStepUpdate步骤13结束时间点管道:"+me.tube+",SO2流量"+me.checkSO2Flow13);
        //通源压力
        me.checkPressure13 = me.pressure;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",通源压力" + me.checkPressure13);
        //沉积温度
        me.checkInTemp1_13 = me.inTemp1;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度1" + me.checkInTemp1_13);
        me.checkInTemp2_13 = me.inTemp2;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度2" + me.checkInTemp2_13);
        me.checkInTemp3_13 = me.inTemp3;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度3" + me.checkInTemp3_13);
        me.checkInTemp4_13 = me.inTemp4;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度4" + me.checkInTemp4_13);
        me.checkInTemp5_13 = me.inTemp5;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度5" + me.checkInTemp5_13);
        me.checkInTemp6_13 = me.inTemp6;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",温度6" + me.checkInTemp6_13);
        //工艺总运行时间   13步骤的时间
        me.runTime_9_11_13 = me.runTime_9_11_13 + me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤13结束时间点管道:" + me.tube + ",时间" + me.runTime_9_11_13);

    }
} catch (err) {
    logger.error("currentStepUpdate步骤13结束时间点报错:" + err.message);
}


try {
    if (newValue == 15) {
        logger.info("currentStepUpdate步骤15开始时间点管道" + me.tube);
        me.checkBCL3Flow14 = me.bcl3Flow;
        logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤14结束时间点,BCl3流量" + me.checkBCL3Flow14);
        me.runTimeMiddle = me.totalRunTime;

        logger.info("currentStepUpdate步骤15开始时间点管道:" + me.tube + ",时间" + me.runTimeMiddle);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤15开始时间点报错:" + err.message);
}

try {
    if (newValue == 16) {
        me.checkPumpSpeed15 = me.pumpSpeed;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",泵速" + me.checkPumpSpeed15);
        //获取步骤15结束时间点
        logger.info("currentStepUpdate步骤15结束时间点管道" + me.tube);
        // me.checkBCL3Flow15 = me.bcl3Flow;
        // logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤15结束时间点,BCl3流量" + me.checkBCL3Flow15);
        //推进压力
        me.checkPressure15 = me.pressure;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",推进压力" + me.checkPressure15);
        me.runTime_9_11_13_15 = me.runTime_9_11_13 + me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",沉积时间" + me.runTime_9_11_13_15);
        //沉积温度
        me.checkInTemp1_15 = me.inTemp1;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度1" + me.checkInTemp1_15);
        me.checkInTemp2_15 = me.inTemp2;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度2" + me.checkInTemp2_15);
        me.checkInTemp3_15 = me.inTemp3;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度3" + me.checkInTemp3_15);
        me.checkInTemp4_15 = me.inTemp4;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度4" + me.checkInTemp4_15);
        me.checkInTemp5_15 = me.inTemp5;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度5" + me.checkInTemp5_15);
        me.checkInTemp6_15 = me.inTemp6;
        logger.info("currentStepUpdate步骤15结束时间点管道:" + me.tube + ",温度6" + me.checkInTemp6_15);
    }
} catch (err) {
    logger.error("currentStepUpdate步骤15结束时间点报错:" + err.message);
}


try {
    if (newValue == 17) {
        me.checkBCL3Flow16 = me.bcl3Flow;
        logger.info("currentStepUpdate:" + me.name + ",管道:" + me.tube + "步骤16结束时间点,吹扫步BCI3流程" + me.checkBCL3Flow16);
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
            logger.info("currentStepUpdate" + me.name + "步骤16结束时间点管道:" + me.tube + ",工艺名称：" + me.checkRecipeName);
        }
        //获取步骤16结束时间点
        logger.info("currentStepUpdate步骤16结束时间点管道" + me.tube);
        //推进压力
        me.checkPressure16 = me.pressure;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进压力" + me.checkPressure15);
        //推进温度
        me.checkInTemp1_16 = me.inTemp1;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度1" + me.checkInTemp1_16);
        me.checkInTemp2_16 = me.inTemp2;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度2" + me.checkInTemp2_16);
        me.checkInTemp3_16 = me.inTemp3;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度3" + me.checkInTemp3_16);
        me.checkInTemp4_16 = me.inTemp4;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度4" + me.checkInTemp4_16);
        me.checkInTemp5_16 = me.inTemp5;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度5" + me.checkInTemp5_16);
        me.checkInTemp6_16 = me.inTemp6;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",推进温度6" + me.checkInTemp6_16);
        //工艺总运行时间   16步骤的时间
        me.runTime_15_16 = me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤16结束时间点管道:" + me.tube + ",时间" + me.runTime_15_16);

        me.runTimeMiddle = me.totalRunTime;
        logger.info("现在时间2" + Date.now());

    }
} catch (err) {
    logger.error("currentStepUpdate步骤16结束时间点报错:" + err.message);
}


try {
    if (newValue == 18) {
        //推进压力
        me.checkPressure17 = me.pressure;
        logger.info("currentStepUpdate步骤17结束时间点管道:" + me.tube + ",推进压力" + me.checkPressure17);


    }
} catch (err) {
    logger.error("currentStepUpdate步骤17结束时间点报错:" + err.message);
}
try {
    if (newValue == 19) {
        //推进压力
        me.checkPressure18 = me.pressure;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进压力" + me.checkPressure18);
        //工艺总运行时间  17/18步骤的时间
        me.runTime_17_18 = me.totalRunTime - me.runTimeMiddle;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",时间" + me.runTime_17_18);
        //推进温度
        me.checkInTemp1_18 = me.inTemp1;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度1" + me.checkInTemp1_18);
        me.checkInTemp2_18 = me.inTemp2;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度2" + me.checkInTemp2_18);
        me.checkInTemp3_18 = me.inTemp3;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度3" + me.checkInTemp3_18);
        me.checkInTemp4_18 = me.inTemp4;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度4" + me.checkInTemp4_18);
        me.checkInTemp5_18 = me.inTemp5;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度5" + me.checkInTemp5_18);
        me.checkInTemp6_18 = me.inTemp6;
        logger.info("currentStepUpdate步骤18结束时间点管道:" + me.tube + ",推进温度6" + me.checkInTemp6_18);

    }
} catch (err) {
    logger.error("currentStepUpdate步骤18结束时间点报错:" + err.message);
}


try {
    if (newValue == 0 && oldValue != 1) {
        //工艺名称
        if (me.checkRecipeName == "" || me.checkRecipeName == null) {
            me.checkRecipeName = me.recipeName;
        }
        logger.info("currentStepUpdate" + me.name + "结束时间点管道:" + me.tube + ",工艺名称：" + me.checkRecipeName);
        //小氧 求平均值  除数处理
        if (me.so2FlowNo0 == 0) {
            me.so2FlowNo0 = 1;
        }
        logger.info(me.machineID + ":currentStepUpdate:" + me.tube + ",小氧1:" + me.checkSO2Flow9 + ",小氧2:" + me.checkSO2Flow11 + ",小氧3:" + me.checkSO2Flow13 + "---计算次数" + me.so2FlowNo0);

        //通源压力  只算不为0的时候取平均值
        if (me.checkPressure9 != 0) {
            me.pressure_9_11_13 = me.pressure_9_11_13 + me.checkPressure9;
            me.pressure_int_9_11_13 = me.pressure_int_9_11_13 + 1;
        }

        if (me.checkPressure11 != 0) {
            me.pressure_9_11_13 = me.pressure_9_11_13 + me.checkPressure11;
            me.pressure_int_9_11_13 = me.pressure_int_9_11_13 + 1;
        }

        if (me.checkPressure13 != 0) {

            me.pressure_9_11_13 = me.pressure_9_11_13 + me.checkPressure13;
            me.pressure_int_9_11_13 = me.pressure_int_9_11_13 + 1;
        }

        //推进压力  只算不为0的时候取平均值
        if (me.checkPressure15 != 0) {

            me.pressure_15_16 = me.pressure_15_16 + me.checkPressure15;
            me.pressure_int_15_16 = me.pressure_int_15_16 + 1;

            me.pressure_9_11_13_15 = me.pressure_9_11_13 + me.checkPressure15;
            me.pressure_int_9_11_13_15 = me.pressure_int_9_11_13 + 1;
        }

        if (me.checkPressure16 != 0) {

            me.pressure_15_16 = me.pressure_15_16 + me.checkPressure16;
            me.pressure_int_15_16 = me.pressure_int_15_16 + 1;
        }
        //防止被除数出现0导致结果未NaN
        if (me.pressure_int_9_11_13 == 0) {
            me.pressure_int_9_11_13 = 1;
        }

        if (me.pressure_int_15_16 == 0) {
            me.pressure_int_15_16 = 1;
        }

        //计算BCI3流量被除数
        if (me.checkBCL3Flow9 >= 200) {
            me.bcl3FlowNo = me.bcl3FlowNo + 1;
        } else {
            me.checkBCL3Flow9 = 0;
        }
        if (me.checkBCL3Flow11 >= 200) {
            me.bcl3FlowNo = me.bcl3FlowNo + 1;
        } else {
            me.checkBCL3Flow11 = 0;
        }
        if (me.checkBCL3Flow13 >= 200) {
            me.bcl3FlowNo = me.bcl3FlowNo + 1;
        } else {
            me.checkBCL3Flow13 = 0;
        }
        //吹扫步BCI3流量
        if (me.checkBCL3Flow10 > 0) {
            me.bcl3FlowStepNo = me.bcl3FlowStepNo + 1;
        }else{
            me.checkBCL3Flow10=0;
        }
        if (me.checkBCL3Flow12 > 0) {
            me.bcl3FlowStepNo = me.bcl3FlowStepNo + 1;
        }else{
            me.checkBCL3Flow12 = 0;
        }
        if (me.checkBCL3Flow14 > 0) {
            me.bcl3FlowStepNo = me.bcl3FlowStepNo + 1;
        }else{
            me.checkBCL3Flow14= 0;
        }


        if (me.checkPressure17 != 0) {
            me.pressure_17_18 = me.checkPressure17 + me.pressure_17_18;
            me.pressure_int_17_18 = me.pressure_int_17_18 + 1;
        }
        if (me.checkPressure18 != 0) {
            me.pressure_17_18 = me.checkPressure18 + me.pressure_17_18;
            me.pressure_int_17_18 = me.pressure_int_17_18 + 1;
        }
        let nowTime = Date.now();
        logger.info("currentStepUpdate大循环结束时间点管道" + me.tube + "时间" + nowTime);
        if (me.checkRecipeName == "PK0003") {
            if (me.checkBCL3Flow15 >= 200) {
                me.bcl3FlowNo = me.bcl3FlowNo + 1;
            }else{
                me.checkBCL3Flow15= 0;
            }
            if (me.checkBCL3Flow16 > 0) {
                me.bcl3FlowStepNo = me.bcl3FlowStepNo + 1;
            }else{
                me.checkBCL3Flow16=0;
            }
            if (me.bcl3FlowStepNo == 0) {
                me.bcl3FlowStepNo = 1;
            }
            if (me.bcl3FlowNo == 0) {
                me.bcl3FlowNo = 1;
            }
            Things["TS.ELEC.ProcessCheck.DB"].insertBoronDiffusionProcessCheck({
                machineId: me.machineID /* STRING */,
                name: me.machineName /* STRING [Required] */,
                dateDay: nowTime /* DATETIME */,
                tube: me.tube /* INTEGER */,
                recipeName: me.checkRecipeName /* STRING */,
                pumpSpeed: ((me.checkPumpSpeed9 + me.checkPumpSpeed11 + me.checkPumpSpeed13 + me.checkPumpSpeed15) / 4).toFixed(2) /* NUMBER */,
                leakageRate: me.checkLeakageRate /* NUMBER */,
                depositedTime: me.runTime_9_11_13_15 /* INTEGER */,
                bcl3Flow: ((me.checkBCL3Flow9 + me.checkBCL3Flow11 + me.checkBCL3Flow13 + me.checkBCL3Flow15) / me.bcl3FlowNo).toFixed(2) /* NUMBER */,
                bcl3FlowStep: ((me.checkBCL3Flow10 + me.checkBCL3Flow12 + me.checkBCL3Flow14 + me.checkBCL3Flow16) / 4).toFixed(2) /* NUMBER */,
                so2Flow: ((me.checkSO2Flow9 + me.checkSO2Flow11 + me.checkSO2Flow13 + me.checkSO2Flow15) / me.so2FlowNo0).toFixed(2) /* NUMBER */,
                sourcePressure: (me.pressure_9_11_13_15 / me.pressure_int_9_11_13_15).toFixed(2) /* NUMBER */,
                propellingPressure: (me.pressure_17_18 / me.pressure_int_17_18).toFixed(2) /* NUMBER */,
                highTemperatureAdvanceTime: me.runTime_17_18 /* INTEGER */,
                depositionTemperature1: me.checkInTemp1_15 /* NUMBER */,
                depositionTemperature2: me.checkInTemp2_15 /* NUMBER */,
                depositionTemperature3: me.checkInTemp3_15 /* NUMBER */,
                depositionTemperature4: me.checkInTemp4_15 /* NUMBER */,
                depositionTemperature5: me.checkInTemp5_15 /* NUMBER */,
                depositionTemperature6: me.checkInTemp6_15 /* NUMBER */,
                propulsionTemperature1: me.checkInTemp1_18 /* NUMBER */,
                propulsionTemperature2: me.checkInTemp2_18 /* NUMBER */,
                propulsionTemperature3: me.checkInTemp3_18 /* NUMBER */,
                propulsionTemperature4: me.checkInTemp4_18 /* NUMBER */,
                propulsionTemperature5: me.checkInTemp5_18 /* NUMBER */,
                propulsionTemperature6: me.checkInTemp6_18 /* NUMBER */
            });
        } else {
            if (me.bcl3FlowStepNo == 0) {
                me.bcl3FlowStepNo = 1;
            }
            if (me.bcl3FlowNo == 0) {
                me.bcl3FlowNo = 1;
            }
            Things["TS.ELEC.ProcessCheck.DB"].insertBoronDiffusionProcessCheck({
                machineId: me.machineID /* STRING */,
                name: me.machineName /* STRING [Required] */,
                dateDay: nowTime /* DATETIME */,
                tube: me.tube /* INTEGER */,
                recipeName: me.checkRecipeName /* STRING */,
                pumpSpeed: ((me.checkPumpSpeed9 + me.checkPumpSpeed11 + me.checkPumpSpeed13) / 3).toFixed(2) /* NUMBER */,
                leakageRate: me.checkLeakageRate /* NUMBER */,
                depositedTime: me.runTime_9_11_13 /* INTEGER */,
                bcl3Flow: ((me.checkBCL3Flow9 + me.checkBCL3Flow11 + me.checkBCL3Flow13) / me.bcl3FlowNo).toFixed(2) /* NUMBER */,
                bcl3FlowStep: ((me.checkBCL3Flow10 + me.checkBCL3Flow12 + me.checkBCL3Flow14) / 3).toFixed(2) /* NUMBER */,
                so2Flow: ((me.checkSO2Flow9 + me.checkSO2Flow11 + me.checkSO2Flow13) / me.so2FlowNo0).toFixed(2) /* NUMBER */,
                sourcePressure: (me.pressure_9_11_13 / me.pressure_int_9_11_13).toFixed(2) /* NUMBER */,
                propellingPressure: (me.pressure_15_16 / me.pressure_int_15_16).toFixed(2) /* NUMBER */,
                highTemperatureAdvanceTime: me.runTime_15_16 /* INTEGER */,
                depositionTemperature1: me.checkInTemp1_13 /* NUMBER */,
                depositionTemperature2: me.checkInTemp2_13 /* NUMBER */,
                depositionTemperature3: me.checkInTemp3_13 /* NUMBER */,
                depositionTemperature4: me.checkInTemp4_13 /* NUMBER */,
                depositionTemperature5: me.checkInTemp5_13 /* NUMBER */,
                depositionTemperature6: me.checkInTemp6_13 /* NUMBER */,
                propulsionTemperature1: me.checkInTemp1_16 /* NUMBER */,
                propulsionTemperature2: me.checkInTemp2_16 /* NUMBER */,
                propulsionTemperature3: me.checkInTemp3_16 /* NUMBER */,
                propulsionTemperature4: me.checkInTemp4_16 /* NUMBER */,
                propulsionTemperature5: me.checkInTemp5_16 /* NUMBER */,
                propulsionTemperature6: me.checkInTemp6_16 /* NUMBER */
            });
        }

        logger.info("currentStepUpdate写入数据库管道:" + me.tube + ",checkPumpSpeed9：" + me.checkPumpSpeed9 +
            ",checkPumpSpeed11：" + me.checkPumpSpeed11 + ",checkPumpSpeed13：" + me.checkPumpSpeed13 +
            ",/3：" + ((me.checkPumpSpeed9 + me.checkPumpSpeed11 + me.checkPumpSpeed13) / 3) +
            "结果:" + ((me.checkPumpSpeed9 + me.checkPumpSpeed11 + me.checkPumpSpeed13) / 3).toFixed(2));
        //把其他字段  置为0  以防上一循环在下次使用
        me.bcl3FlowNo = 0;
        me.bcl3FlowStepNo = 0;
        me.checkBCL3Flow9 = 0;
        me.checkBCL3Flow10 = 0;
        me.checkBCL3Flow11 = 0;
        me.checkBCL3Flow12 = 0;
        me.checkBCL3Flow13 = 0;
        me.checkBCL3Flow16 = 0;
        me.checkBCL3Flow14 = 0;
        me.checkSO2Flow9 = 0;
        me.checkSO2Flow11 = 0;
        me.checkSO2Flow13 = 0;
        me.checkSO2Flow15 = 0;
        me.checkInTemp1_13 = 0;
        me.checkInTemp2_13 = 0;
        me.checkInTemp3_13 = 0;
        me.checkInTemp4_13 = 0;
        me.checkInTemp5_13 = 0;
        me.checkInTemp6_13 = 0;
        me.checkInTemp1_16 = 0;
        me.checkInTemp2_16 = 0;
        me.checkInTemp3_16 = 0;
        me.checkInTemp4_16 = 0;
        me.checkInTemp5_16 = 0;
        me.checkInTemp6_16 = 0;
        me.checkPressure9 = 0;
        me.checkPressure11 = 0;
        me.checkPressure13 = 0;
        me.checkPressure15 = 0;
        me.checkPressure16 = 0;
        me.runTimeMiddle = 0;
        me.runTime_15_16 = 0;
        me.runTime_9_11_13 = 0;
        me.checkLeakageRate = 0;
        me.checkPumpSpeed9 = 0;
        me.checkPumpSpeed11 = 0;
        me.checkPumpSpeed13 = 0;
        me.so2FlowNo0 = 0;
        me.pressure_15_16 = 0;
        me.pressure_17_18 = 0;
        me.pressure_9_11_13 = 0;
        me.pressure_int_15_16 = 0;
        me.pressure_int_9_11_13 = 0;
        me.checkBCL3Flow15 = 0;
        me.checkPumpSpeed15 = 0;
        me.checkInTemp1_15 = 0;
        me.checkInTemp2_15 = 0;
        me.checkInTemp3_15 = 0;
        me.checkInTemp4_15 = 0;
        me.checkInTemp5_15 = 0;
        me.checkInTemp6_15 = 0;
        me.checkInTemp1_18 = 0;
        me.checkInTemp2_18 = 0;
        me.checkInTemp3_18 = 0;
        me.checkInTemp4_18 = 0;
        me.checkInTemp5_18 = 0;
        me.checkInTemp6_18 = 0;
        me.pressure_int_17_18 = 0;
        me.pressure_int_9_11_13_15 = 0;
    }
} catch (err) {
    logger.error("currentStepUpdate大循环结束时间点报错:" + err.message);
}