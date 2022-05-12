package com.example.lizan.test;

import com.shinemo.chinamobile.common.elasticsearch.annotations.EsDocument;
import com.shinemo.chinamobile.common.elasticsearch.annotations.EsField;
import com.shinemo.chinamobile.common.elasticsearch.annotations.FieldType;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author lizan
 * @version $Id: User.java, v 0.1 2022年05月11日 10:13 lizan Exp $$
 */
@Data
@EsDocument(indexName = "user")
public class UserTest {

    @EsField(type = FieldType.Text,doc_values = false)
    private String name;
    @EsField(type = FieldType.Keyword,doc_values = false)
    private String sex;
    @EsField(type = FieldType.Integer,doc_values = false)
    private Integer age;
}