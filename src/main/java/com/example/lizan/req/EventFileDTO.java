package com.example.lizan.req;

import lombok.Data;

/**
 * @author lizan
 * @version $Id: EventFileDTO.java, v 0.1 2022年03月01日 16:03 lizan Exp $$
 */
@Data
public class EventFileDTO {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String fileUrl;

}