package com.example.lizan.conf;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lizan
 * @version $Id: MybatisPlusGenerator.java, v 0.1 2022年07月14日 14:08 lizan Exp $$
 */
public class MybatisPlusGenerator {

    private static String url = "jdbc:mysql://10.0.17.204:3306/shinemo_im?autoReconnect=true&failOverReadOnly=false&maxReconnects=10&characterEncoding=utf8&allowMultiQueries=true&useSSL=false";
    private static String username = "root";
    private static String password = "shinemo123";
    //作者
    private static String author = "lizan";
    //输出目录
// private static String output = "D:\\develop\\workspace\\reminder\\src\\main\\java";
    private static String output = "D:\\IdeaProject\\local\\local-es\\src\\main\\java";
    //父包名 不包含core/client
    private static String parentPackage = "com.example.lizan";
    //要生成的表名
    //如果该表为逻辑删除，创建is_deleted字段 1-已删除 0-未删除， 设置默认值为0
    private static String[] tables = new String[]{"base_config"};
    //逻辑删除字段名称
    private static String logicDeleteColumnName = "is_deleted";
    //表前缀
    private static String[] tablePreFix = new String[]{};


    public static void main(String[] args) {


        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author)
// .fileOverride() // 覆盖已生成文件
                            .outputDir(output);
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackage) // 设置父包名
                            .pathInfo(buildPathInfo()); // 设置生成路径
                })
                .strategyConfig(builder -> {
                    if (tablePreFix.length > 0) {
                        builder.addTablePrefix(tablePreFix);
                    }
                    builder.addInclude(tables)
                            .addTablePrefix()
                            .controllerBuilder()
                            .enableRestStyle()


                            .serviceBuilder()
                            .formatServiceFileName("%sService")
// .addTablePrefix("t_", "c_"); // 设置过滤表前缀


                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()


                            .entityBuilder()
                            .idType(IdType.AUTO)
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .logicDeleteColumnName(logicDeleteColumnName)//逻辑删除字段
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableChainModel()
                            .addTableFills(
                                    new Column("gmt_create", FieldFill.INSERT),
                                    new Column("gmt_modified", FieldFill.INSERT_UPDATE)
                            );
                })
                .execute();


    }


    private static Map<OutputFile, String> buildPathInfo() {
        Map<OutputFile, String> map = new HashMap<>();
        map.put(OutputFile.mapperXml, output + "\\resources\\mapper");
        return map;
    }
}