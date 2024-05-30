package com.example.lizan.collection;

import com.example.lizan.bean.UserTestDTO;
import io.github.burukeyou.dataframe.iframe.JDFrame;
import io.github.burukeyou.dataframe.iframe.item.FI2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizan
 * @version $Id: ListDemo.java, v 0.1 2022年06月13日 17:22 lizan Exp $$
 */
public class ListDemo {
    public static void main(String[] args) {

        List<UserTestDTO> arrayList = new ArrayList<>();
        arrayList.add(new UserTestDTO("1","1","1"));
        arrayList.add(new UserTestDTO("2","2","2"));
        arrayList.add(new UserTestDTO("3","3","4"));
        arrayList.add(new UserTestDTO("3","4","4"));

        List<FI2<String, List<UserTestDTO>>> lists =
                JDFrame.read(arrayList).group(UserTestDTO::getUid).toLists();
        lists.forEach(x->{
            System.out.println(x.getC1());
            System.out.println(x.getC2());
        });
    }
}