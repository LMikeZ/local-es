package com.example.lizan.webservice;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizan
 * @version $Id: ThirdResponseResult.java, v 0.1 2024年10月17日 15:57 lizan Exp $$
 */
@Data
public class ThirdResponseResult implements Serializable {

    /**
     * STATUS : OK
     * ERRORMSG :
     * ORDER_NO : 0001550298
     * SN : 00003.0.01.30.000010LP2780004
     * PRODUCT_NUM : 1
     * PRODUCT_NAME : 裸机-LPS01_IPD-控制器总成
     * PRODUCT_NO : 3.7.01.20.00001
     * TYPE : 1
     */

    private String status;
    private String errorMsg;
    private String orderNo;
    private String sn;
    private String productNum;
    private String productName;
    private String productNo;
    private String type;

}
