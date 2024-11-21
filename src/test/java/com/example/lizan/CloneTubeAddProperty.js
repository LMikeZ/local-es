try{
    for (let j = 1; j < 28; j++) {
        try {
            let machineIdStr = "10" + j;
            if (j < 10) {
                machineIdStr = "100" + j;
            } else {
                machineIdStr = "10" + j;
            }

            for (let i = 1; i < 7; i++) {
                let t = "TS.ELEC.RearPECVDMain" + machineIdStr + ".Tube" + i + ".TH";
                let spn = "RearPECVDMain" + machineIdStr + "_RearPECVDMain" + machineIdStr + "_HTY_PECVD_Tube" + i + "_RecipeName";

                let binding = Things[t].GetLocalPropertyBinding({
                    propertyName: "recipeName"
                });
                let spn2 = binding.getRow(0).sourceName || "";
                let remoteName = "TS.ELEC.RearPECVDMain" + machineIdStr + ".RT";
                logger.info("RearPECVDMain1001CloneTubespn2"+spn2);
                if(spn2==""){
                    Things[t].SetLocalPropertyBinding({
                        propertyName: "recipeName",
                        sourcePropertyName: spn,
                        sourceThingName: remoteName,
                        aspects: {}
                    });
                    Things[t].EnableThing();
                    Things[t].RestartThing();
                }

            }

        } catch (e) {
            logger.error("RearPECVDMain1001CloneTube"+e);
        }
    }
}catch(e){
    logger.error("RearPECVDMain1001CloneTube:"+e);
}