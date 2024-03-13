package com.example.lizan.bean;

import com.example.lizan.aspect.ann.SignCheck;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lizan
 * @version $Id: UserTestDTO.java, v 0.1 2023年07月27日 13:38 lizan Exp $$
 */
@Data
@Accessors(chain = true)
public class UserTestDTO {

    private String uid;

    @SignCheck
    private String url;

    private String name;
}
