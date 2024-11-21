try {
    let definition = me.GetPropertyDefinition({
        name: eventData.name /* STRING */
    });
    let desc = definition.getRow(0).description;
    if (desc.indexOf("掉片") || desc.indexOf("堵片")) {
        let machineThing = me.name.replace("Alarm", "");
        Things["TS.ELEC.SIM.COMMON.TH"].calSIMJamAlarm({
            linkEvent: eventData.newValue.value /* BOOLEAN */,
            sourceObj: Things[machineThing].machineID /* STRING */,
            desc: desc /* STRING */,
            happenTime: Date.now() /* DATETIME */
        });
    }

} catch (err) {
    logger.error("alarmUploadWarnInfo报错:" + err);
}

