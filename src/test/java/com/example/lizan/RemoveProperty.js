for (let j = 1; j < 28; j++) {
    try {
        let machineIdStr = "10" + j;
        if (j < 10) {
            machineIdStr = "100" + j;
        } else {
            machineIdStr = "10" + j;
        }

        for (let i = 2; i < 7; i++) {
            let t = "TS.ELEC.RearPECVDMain" + machineIdStr + ".Tube" + i + ".TH";
            let spn = "RearPECVDMain" + machineIdStr + "_RearPECVDMain" + machineIdStr + "_HTY_PECVD_Tube" + i + "_RecipeName";
            Things[t].RemoveLocalPropertyBinding({
                propertyName: "recipeName" /* STRING */
            });
            let remoteName = "TS.ELEC.RearPECVDMain" + machineIdStr + ".RT";
            Things[t].SetLocalPropertyBinding({
                propertyName: "recipeName",
                sourcePropertyName: spn,
                sourceThingName: remoteName,
                aspects: {}
            });
            Things[t].EnableThing();
            Things[t].RestartThing();
        }

    } catch (e) {
        logger.error(e);
    }
}


//删除name
me.RemovePropertyDefinition({
    name: undefined /* STRING */
});

//删除绑定的属性
Things[machineName].RemoveLocalPropertyBinding({
    propertyName: pn /* STRING */
});