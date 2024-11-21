let now = Date.now();

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 1 /* INTEGER */,
    slotType: "抛光槽1槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(1).element /10 /* STRING */,
    processTime: me.time.getRow(1).element /* STRING */,
    alkali: me.alkali1 /* STRING */,
    add: me.add1 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 1 /* INTEGER */,
    slotType: "抛光槽1槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali1_1 /* STRING */,
    add: me.add1_1 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 2 /* INTEGER */,
    slotType: "抛光槽2槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(2).element / 10 /* STRING */,
    processTime: me.time.getRow(2).element /* STRING */,
    alkali: me.alkali2 /* STRING */,
    add: me.add2 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 2 /* INTEGER */,
    slotType: "抛光槽2槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali2_1 /* STRING */,
    add: me.add2_1 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});
Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 4 /* INTEGER */,
    slotType: "抛光槽4槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(4).element / 10 /* STRING */,
    processTime: me.time.getRow(4).element /* STRING */,
    alkali: me.alkali4 /* STRING */,
    add: me.add4 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 4 /* INTEGER */,
    slotType: "抛光槽4槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali4_1 /* STRING */,
    add: me.add4_1 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 5 /* INTEGER */,
    slotType: "抛光槽5槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(5).element /10  /* STRING */,
    processTime: me.time.getRow(5).element /* STRING */,
    alkali: me.alkali5 /* STRING */,
    add: me.add5 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 5 /* INTEGER */,
    slotType: "抛光槽5槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali5_1 /* STRING */,
    add: me.add5_1 /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 7 /* INTEGER */,
    slotType: "碱洗槽7槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(7).element /10 /* STRING */,
    processTime: me.time.getRow(7).element /* STRING */,
    alkali: me.alkali7 /* STRING */,
    add: null /* STRING */,
    h2o2: me.h2o27 /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 7 /* INTEGER */,
    slotType: "碱洗槽7槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali7_1 /* STRING */,
    add: null /* STRING */,
    h2o2: me.h2o27_1 /* STRING */,
    hf: null /* STRING */
});
Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 8 /* INTEGER */,
    slotType: "碱洗槽8槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: me.temp.getRow(8).element / 10 /* STRING */,
    processTime: me.time.getRow(8).element /* STRING */,
    alkali: me.alkali8 /* STRING */,
    add: null /* STRING */,
    h2o2: me.h2o28 /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 8 /* INTEGER */,
    slotType: "碱洗槽8槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: me.alkali8_1 /* STRING */,
    add: null /* STRING */,
    h2o2: me.h2o28_1 /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 10 /* INTEGER */,
    slotType: "前酸洗槽10槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: null /* STRING */,
    processTime: me.time.getRow(10).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf10 /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 10 /* INTEGER */,
    slotType: "前酸洗槽10槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf10_1 /* STRING */
});
Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 11 /* INTEGER */,
    slotType: "前酸洗槽11槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: null /* STRING */,
    processTime: me.time.getRow(11).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf11 /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 11 /* INTEGER */,
    slotType: "前酸洗槽11槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf11_1 /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 12 /* INTEGER */,
    slotType: "后酸洗槽12槽" /* STRING */,
    processType: "初配" /* STRING */,

    temp: null /* STRING */,
    processTime: me.time.getRow(12).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf12 /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 12 /* INTEGER */,
    slotType: "后酸洗槽12槽" /* STRING */,
    processType: "补加" /* STRING */,

    temp: null /* STRING */,
    processTime: null /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: me.hf12_1 /* STRING */
});



Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 14 /* INTEGER */,
    slotType: "慢提拉槽14槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: null /* STRING */,
    processTime: me.time.getRow(14).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 15 /* INTEGER */,
    slotType: "烘干槽15槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(15).element /10 /* STRING */,
    processTime: me.time.getRow(15).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 16 /* INTEGER */,
    slotType: "烘干槽16槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(16).element /10 /* STRING */,
    processTime: me.time.getRow(16).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 17 /* INTEGER */,
    slotType: "烘干槽17槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(17).element /10 /* STRING */,
    processTime: me.time.getRow(17).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 18 /* INTEGER */,
    slotType: "烘干槽18槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(18).element /10 /* STRING */,
    processTime: me.time.getRow(18).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});

Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 19 /* INTEGER */,
    slotType: "烘干槽19槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(19).element /10 /* STRING */,
    processTime: me.time.getRow(19).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});


Things["TS.ELEC.ProcessCheck.DB"].insertRCAProcessCheck({
    machineId: me.machine_id /* STRING */,
    name: me.machineName /* STRING [Required] */,
    dateDay: now,
    slotNumber: 20 /* INTEGER */,
    slotType: "烘干槽20槽" /* STRING */,
    processType: "/" /* STRING */,

    temp: me.temp.getRow(20).element /10 /* STRING */,
    processTime: me.time.getRow(20).element /* STRING */,
    alkali: null /* STRING */,
    add: null /* STRING */,
    h2o2: null /* STRING */,
    hf: null /* STRING */
});
