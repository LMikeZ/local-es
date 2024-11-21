// 以TS.ELEC.ALDMain1001.RC1.TH为基础 创建其余所有Main的Tube
let name = soureNameParam;

//传Main的版本 例如 1002
let sourceNoRT = sourceNoRTParam;
//Tube的版本 例如 Tube2
let machineNo = tubeNoParam;
let sourceNo = "TubeID1";
// sourceNo = Tube1 machineNo = Tube2
let machineName = name.replace(sourceNo, machineNo); //TS.ELEC.ALDMain1001.RC2.TH
machineName = machineName.replace("1001", sourceNoRT);
let description=  me.description.replace("1001", sourceNoRT);
let params = {
    name: machineName /* STRING */,
    description: description /* STRING */,
    sourceThingName: name /* THINGNAME */,
    tags: undefined /* TAGS */
};
let remoteName = name.replace(".TubeID1.TH", ".RT");
remoteName = remoteName.replace("1001", sourceNoRT);

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
    //machineName = TS.ELEC.ALDMain1001.RC2.TH
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
            if(machineNo!="TubeID1"){
                while (spn.indexOf("Tube1") >= 0 ) {
                    spn = spn.replace("Tube1", machineNo.replace("ID",""));
                }
            }
            if(sourceNoRT !="1001"){
                while (spn.indexOf("1001") >= 0) {
                    spn = spn.replace("1001", sourceNoRT);
                }
            }
            let binding2 = Things[machineName].GetLocalPropertyBinding({
                propertyName: pn
            });
            let spn2 = binding2.getRow(0).sourceName || "";
            logger.info("cloneTH_SPN_After:" + spn);
            if(spn2 != ""){
                Things[machineName].RemoveLocalPropertyBinding({
                    propertyName: pn /* STRING */
                });
            }

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

