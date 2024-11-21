// 以TS.ELEC.PepolyMain1001.Tube1.TH为基础 创建其余所有Main的Tube
let name = soureNameParam;

//传Main的版本 例如 1002
let sourceNoRT = sourceNoRTParam;
//Tube的版本 例如 Tube2
let machineNo = tubeNoParam;
let sourceNo = "Tube1";
// sourceNo = Tube1 machineNo = Tube2
let machineName = name.replace(sourceNo, machineNo);
machineName = machineName.replace("1002", sourceNoRT);
let description = me.description.replace("1002", sourceNoRT);
let params = {
    name: machineName /* STRING */,
    description: description /* STRING */,
    sourceThingName: name /* THINGNAME */,
    tags: undefined /* TAGS */
};
let remoteName = name.replace(".Tube1.TH", ".RT");
remoteName = remoteName.replace("1002", sourceNoRT);

result = "";

try {
    logger.info("cloneTH开始" + machineName);
    if (Things[machineName] == null) {
        logger.info("cloneTH开始复制" + machineName);
        // no return
        Resources["EntityServices"].CloneThing(params);
        Things[machineName].EnableThing();
        Things[machineName].RestartThing();
        logger.info("cloneTH结束复制" + machineName);

    }

    let properties = Things[machineName].GetPropertyDefinitions();
    properties.rows.toArray().forEach(property => {
        let pn = property.name || "";
        logger.info("cloneTH开始前" + property.name);
        if (pn == "")
            return;
        logger.info("cloneTH开始绑定" + property.name);
        //Your code here
        let binding = Things[name].GetLocalPropertyBinding({
            propertyName: pn
        });
        let spn = binding.getRow(0).sourceName || "";

        if (spn != "") {
            logger.info("cloneTH_SPN_Front:" + spn);
            if (machineNo != "Tube1") {
                while (spn.indexOf("Tube1") >= 0) {
                    spn = spn.replace("Tube1", machineNo);
                }
            }

            while (spn.indexOf("1002") >= 0) {
                spn = spn.replace("1002", sourceNoRT);
            }
            logger.info("cloneTH_SPN_After:" + spn);
            Things[machineName].RemoveLocalPropertyBinding({
                propertyName: pn /* STRING */
            });
            Things[machineName].SetLocalPropertyBinding({
                propertyName: pn,
                sourcePropertyName: spn,
                sourceThingName: remoteName,
                aspects: {}
            });
        }
    });
    Things[machineName].EnableThing();
    Things[machineName].RestartThing();
} catch (e) {
    logger.error("cloneTH报错" + e);
}

