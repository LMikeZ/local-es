package com.example.lizan.req;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: tts
 * @className: TranslateRequest
 * @author: ZhaoCheng
 * @description:
 * @date: 2022/12/8 4:33 PM
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class TranslateRequestParams extends CloudBaseParams implements AbcPenRequest {


    private String mode;

    private String sentence;


    @Override
    public String path() {
        return "/v1/translate/sentence";
    }

    @Override
    public String endpoint() {
        return "translate.abcpen.com";
    }
}
