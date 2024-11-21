let machineName = me.name.replace(sourceNo, machineNo);
let desc = me.description.replace(sourceNo, machineNo);//Things["TS.ELEC.BSGAutoUpload1002.RT"].description

//sourceDevice = sourceDevice.replace("RT","");
//let deviceName =sourceDevice.replace(sourceNo, machineNo);
let remoteSource = me.name.replace(".RT",".RT");
//let remoteSource = me.name.replace(".RT",".RT");
let remoteName = remoteSource.replace(sourceNo, machineNo);
let remoteDesc = Things[remoteSource].description.replace(sourceNo, machineNo);//Things["TS.ELEC.BSGAutoUpload1002.RT"].description
let remoteParams = {
    name: remoteName /* STRING */,
    description: remoteDesc /* STRING */,
    sourceThingName: remoteSource /* THINGNAME */,
    tags: undefined /* TAGS */
};
result = "";
try{
//if(Things[remoteName] == null){
//    // no return
//    Resources["EntityServices"].CloneThing(remoteParams);
//    Things[remoteName].EnableThing();
//    Things[remoteName].RestartThing();
//}
//    if(!Things[remoteName].IsEnabled()){
//    }
    //Things[remoteName].IndustrialThing = Things[remoteSource].IndustrialThing;

    let properties = Things[remoteName].GetPropertyDefinitions();
    let properties2 = Things[remoteSource].GetPropertyDefinitions();
    properties2.rows.toArray().forEach(property => {

        if(!properties.rows.toArray().includes(property)){

            let newProp = property.name;
            if(!(newProp=="isConnected"||newProp=="isReporting"||newProp=="lastConnection"||newProp=="reportingLastChange"||newProp=="reportingLastEvaluation")){


                logger.info("addTest  进入添加字段"+newProp+",sourceDevice:"+sourceDevice);
                while(newProp.indexOf(sourceDevice) >= 0){
//        	let newProp = property.name.replace(sourceNo, machineNo);
//            if(newProp.indexOf(sourceDevice) >= 0){
                    //logger.info("addTest  newP"+newProp);
                    newProp = newProp.replace(sourceNo, machineNo);
//            }
                }
                try{
                    Things[remoteName].AddPropertyDefinition({
                        name: newProp,
                        descruption: "",
                        type: property.baseType
                    });
                    let binding = Things[remoteSource].GetRemotePropertyBinding({
                        propertyName: property.name
                    });
                    logger.info("addProperty  绑定 "+binding);
                    if(binding != null){
                        //                result = binding.aspects;
                        let aspects = binding.aspects;
                        let address = aspects.tagAddress;
                        while(address.indexOf(sourceNo) >= 0){
                            address = address.replace(sourceNo, machineNo);
                        }
                        aspects.tagAddress = address;
                        Things[remoteName].SetRemotePropertyBinding({
                            propertyName: newProp,
                            sourcePropertyName: address,
                            aspects: aspects,
                            pushType: property.baseType=="INFOTABLE"?"ALWAYS":"VALUE"
                        });
                    }
                }catch(e){
                    logger.error("addProperty  "+e.message);
                }
            }
        }



    });


    Things[remoteName].EnableThing();
    Things[remoteName].RestartThing();
}catch(e){
    logger.error("addProperty  "+e.message);
}


