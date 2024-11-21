logger.info(me.name + "cameraNG");
let ngTable = me.ngBasketTable;

let machineThing = me.name;
let uploadThing = "";
machineThing = machineThing.replace("TextureAutoDnload", "TextureMain");
if (Things[machineThing] != null) {
    let basketTable = Things[machineThing].exitTable;
//    if(basketTable == null || basketTable.getRowCount() == 0){//临时从上料机取0702
//        let uploadThing = machineThing.replace("TextureMain","TextureAutoUpload");
//        basketTable = Things[uploadThing].basketQuantityTable;
//    }
    if (basketTable != null && basketTable.getRowCount() > 0) {
        // CreateInfoTableFromDataShape(infoTableName:STRING("InfoTable"), dataShapeName:STRING):INFOTABLE(TS.ELEC.BatchQuantity.DS)
        let mainTable = Resources["InfoTableFunctions"].CreateInfoTableFromDataShape({
            infoTableName: "InfoTable",
            dataShapeName: "TS.ELEC.BatchQuantity.DS"
        });
        for (let i = 0; i < basketTable.getRowCount(); i++) {
            let basketBatchQuantity = basketTable.getRow(i);
            if (i == 0) {
//                let basketTableA = me["unloadBasketTable"+track];
//                ngTable.AddRow(basketBatchQuantity);
//                me["unloadBasketTable"+track] = basketTableA;
            } else {
                mainTable.AddRow(basketBatchQuantity);
            }
        }
        logger.info(me.name + "cameraNG:,mainTable=" + mainTable.getRowCount());
//        if(uploadThing != "")
//            Things[uploadThing].basketQuantityTable = mainTable;
//        else
        Things[machineThing].exitTable = mainTable;
        //            result = mainTable;
        Things["TS.ELEC.Management.DB"].insertSingleCameraNGRecord({
            processName: undefined /* STRING */,
            reason: undefined /* STRING */,
            quantity: undefined /* INTEGER */,
            boatNo: undefined /* STRING */,
            timestamp: undefined /* DATETIME */
        });
    }
}