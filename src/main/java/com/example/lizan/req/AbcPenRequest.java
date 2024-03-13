package com.example.lizan.req;

import java.io.Serializable;

/**
 * @projectName: tts
 * @className: AbcPenRequest
 * @author: ZhaoCheng
 * @description: TODO
 * @date: 2022/12/7 10:30 PM
 * @version: 1.0
 */
public interface AbcPenRequest extends Serializable {

    default String endpoint() {
        return null;
    }

    String path();

    default String version() {
        return "v2";
    }

}
