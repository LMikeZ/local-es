
let now = Date.now();
Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 1 /* INTEGER */,
    slotType: "酸洗槽1槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: me.temp1/* NUMBER */,
    processTime: me.time1 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl1_1 /* INTEGER */,
    hf: me.hf1_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add1_1 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 1 /* INTEGER */,
    slotType: "酸洗槽1槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl1_2 /* INTEGER */,
    hf: me.hf1_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add1_2 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 2 /* INTEGER */,
    slotType: "酸洗槽2槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: me.temp2/* NUMBER */,
    processTime: me.time2 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl2_1 /* INTEGER */,
    hf: me.hf2_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add2_1 /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 2 /* INTEGER */,
    slotType: "酸洗槽2槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl2_2 /* INTEGER */,
    hf: me.hf2_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add2_2 /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 3 /* INTEGER */,
    slotType: "酸洗槽3槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: me.temp3/* NUMBER */,
    processTime: me.time3 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl3_1 /* INTEGER */,
    hf: me.hf3_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add3_1 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 3 /* INTEGER */,
    slotType: "酸洗槽3槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl3_2 /* INTEGER */,
    hf: me.hf3_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add3_2 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 4 /* INTEGER */,
    slotType: "酸洗槽4槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: me.temp4/* NUMBER */,
    processTime: me.time4 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl4_1 /* INTEGER */,
    hf: me.hf4_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add4_1 /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 4 /* INTEGER */,
    slotType: "酸洗槽4槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl4_2 /* INTEGER */,
    hf: me.hf4_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add4_2 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 6 /* INTEGER */,
    slotType: "6槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: null /* NUMBER */,
    processTime: me.time6 /* INTEGER */,
    hno3: me.hno36_1 /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: me.hf6_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 6 /* INTEGER */,
    slotType: "6槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: me.hno36_2 /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: me.hf6_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});



Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 8 /* INTEGER */,
    slotType: "碱洗槽8槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: me.temp8 /* NUMBER */,
    processTime: me.time8 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null  /* INTEGER */,
    hf: null /* INTEGER */,
    koh: me.koh8_1 /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add8_1 /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 8 /* INTEGER */,
    slotType: "碱洗槽8槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: me.koh8_2 /* INTEGER */,
    pl: null /* INTEGER */,
    add: me.add8_2 /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 10 /* INTEGER */,
    slotType: "10槽" /* STRING */,
    processType: "初配" /* STRING */,
    temp: null /* NUMBER */,
    processTime: me.time10 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl10_1 /* INTEGER */,
    hf: me.hf10_1 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});


Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 10 /* INTEGER */,
    slotType: "10槽" /* STRING */,
    processType: "补加" /* STRING */,
    temp: null /* NUMBER */,
    processTime: null /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: me.hcl10_2 /* INTEGER */,
    hf: me.hf10_2 /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 11 /* INTEGER */,
    slotType: "11槽" /* STRING */,
    processType: "/" /* STRING */,
    temp: null /* NUMBER */,
    processTime: me.time11 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});



Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 12 /* INTEGER */,
    slotType: "慢提拉槽12槽" /* STRING */,
    processType: null /* STRING */,
    temp: me.time12 /* NUMBER */,
    processTime: me.time12 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: null /* INTEGER */,
    pl: null /* INTEGER */,
    add: null /* INTEGER */
});



Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 13 /* INTEGER */,
    slotType: "烘干槽13槽" /* STRING */,
    processType: "/" /* STRING */,
    temp: me.time13 /10 /* NUMBER */,
    processTime: me.time13 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: null /* INTEGER */,
    pl: me.pl13 * 0.2 /* INTEGER */,
    add: null /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 14 /* INTEGER */,
    slotType: "烘干槽14槽" /* STRING */,
    processType: "/" /* STRING */,
    temp: me.time14 /10 /* NUMBER */,
    processTime: me.time14 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: null /* INTEGER */,
    pl: me.pl14 *0.2 /* INTEGER */,
    add: null /* INTEGER */
});

Things["TS.ELEC.ProcessCheck.DB"].insertReworkProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 15 /* INTEGER */,
    slotType: "烘干槽15槽" /* STRING */,
    processType: "/" /* STRING */,
    temp: me.time15 /10 /* NUMBER */,
    processTime: me.time15 /* INTEGER */,
    hno3: null /* INTEGER */,
    hcl: null /* INTEGER */,
    hf: null /* INTEGER */,
    koh: null /* INTEGER */,
    pl: me.pl15 * 0.2 /* INTEGER */,
    add: null /* INTEGER */
});



