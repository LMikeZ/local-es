try {
    let newValue = eventData.newValue.value;
// 1槽
    if (me.slotNum == 1) {
        //判断是否和上次时间相同
        if (me.checkTime1 != me.time1 && me.count1 == 0) {
            me.boatNo1_1 = newValue;
            me.count1 = 1;
        }
        if (me.checkTime1 != me.time1 && me.count1 == 1) {
            me.boatNo1_2 = newValue;
            me.count1 = 2;
        }

        if (me.checkTime1 != me.time1 && me.count1 == 2) {
            me.boatNo1_3 = newValue;
            me.count1 = 3;
        }
        //	第四次把取值次数改为0和时间值赋值
        if (me.checkTime1 != me.time1 && me.count1 == 3) {
            me.boatNo1_4 = newValue;
            me.count1 = 0;
            me.checkTime1 = me.time1;
        }
    }
    if (me.slotNum == 2) {
//判断是否和上次时间相同
        if (me.checkTime2 != me.time1 && me.count2 == 0) {
            me.boatNo2_1 = newValue;
            me.count2 = 1;
        }
        if (me.checkTime2 != me.time2 && me.count2 == 1) {
            me.boatNo2_2 = newValue;
            me.count2 = 2;
        }

        if (me.checkTime2 != me.time2 && me.count2 == 2) {
            me.boatNo2_3 = newValue;
            me.count2 = 3;
        }
//	第四次把取值次数改为0和时间值赋值
        if (me.checkTime2 != me.time2 && me.count2 == 3) {
            me.boatNo2_4 = newValue;
            me.count2 = 0;
            me.checkTime2 = me.time2;
        }
    }
    if (me.slotNum == 3) {
//判断是否和上次时间相同
        if (me.checkTime3 != me.time1 && me.count3 == 0) {
            me.boatNo3_1 = newValue;
            me.count3 = 1;
        }
        if (me.checkTime3 != me.time3 && me.count3 == 1) {
            me.boatNo3_2 = newValue;
            me.count3 = 2;
        }

        if (me.checkTime3 != me.time3 && me.count3 == 2) {
            me.boatNo3_3 = newValue;
            me.count3 = 3;
        }
//	第四次把取值次数改为0和时间值赋值
        if (me.checkTime3 != me.time3 && me.count3 == 3) {
            me.boatNo3_4 = newValue;
            me.count3 = 0;
            me.checkTime3 = me.time3;
        }
    }
} catch (e) {
    logger.error("subBoatNo报错:" + e);
}
