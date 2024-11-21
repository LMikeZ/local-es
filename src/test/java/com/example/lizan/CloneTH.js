let machineName = me.name.replace(sourceNo, machineNo);

let remoteSourceRT = me.name.replace(".TH", ".RT");
remoteSourceRT = remoteSourceRT.replace(sourceNo, machineNo);
let remoteName = me.name.replace(".TH", ".TH");
let description= me.description.replace(sourceNo, machineNo);
let params = {
    name: machineName /* STRING */,
    description: description /* STRING */,
    sourceThingName: remoteName /* THINGNAME */,
    tags: undefined /* TAGS */
};
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
        let binding = Things[me.name].GetLocalPropertyBinding({
            propertyName: pn
        });
        let spn = binding.getRow(0).sourceName || "";

        if (spn != "") {
            logger.info("cloneTH_spn:" + spn);
            while (spn.indexOf(sourceNo) >= 0) {
                spn = spn.replace(sourceNo, machineNo);
            }
            Things[machineName].RemoveLocalPropertyBinding({
                propertyName: pn /* STRING */
            });
            Things[machineName].SetLocalPropertyBinding({
                propertyName: pn,
                sourcePropertyName: spn,
                sourceThingName: remoteSourceRT,
                aspects: {}
            });
        }
    });
    Things[machineName].EnableThing();
    Things[machineName].RestartThing();
} catch (e) {
    logger.error("cloneTH报错" + e);
}

