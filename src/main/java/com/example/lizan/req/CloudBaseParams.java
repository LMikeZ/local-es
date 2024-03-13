package com.example.lizan.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: cloud-server
 * @className: CloudBaseDTO
 * @author: ZhaoCheng
 * @description:
 * @date: 2022/12/24 4:48 PM
 * @version: 1.0
 */
@Data
public class CloudBaseParams implements Serializable {

    private String requestId;

     private String appId;
}
