//package com.example.lizan.conf;
//
//
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * <p>
// * CodeGenerator
// * </p>
// *
// * @author zengyuan
// * @since 2021-06-07
// */
//// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
//public class CodeGenerator {
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入" + tip + "：");
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    public static void main(String[] args) {
//        // 代码生成器
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor("lizan");
//        gc.setOpen(false);
//        gc.setBaseResultMap(true);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://10.0.17.204:3306/shinemo_im?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("shinemo123");
//        mpg.setDataSource(dsc);
//        AutoGenerator mpg = new AutoGenerator(gc);
//
////        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
////        pc.setModuleName(scanner("模块名"));
//        pc.setParent("com.example.lizan");
//        pc.setMapper("repository.mapper");
//        pc.setEntity("repository.model");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
////        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录，自定义目录用");
//                if (fileType == FileType.MAPPER) {
//                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
//                    return !new File(filePath).exists();
//                }
//                // 允许生成模板文件
//                return true;
//            }
//        });
//        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("p_","t_");
//        strategy.setEntityTableFieldAnnotationEnable(true);
//        List<TableFill> tableFillList = new ArrayList<>();
//        tableFillList.add(new TableFill("gmt_create", FieldFill.INSERT));
//        tableFillList.add(new TableFill("gmt_modified", FieldFill.INSERT_UPDATE));
//        tableFillList.add(new TableFill("gmt_update", FieldFill.INSERT_UPDATE));
//        strategy.setTableFillList(tableFillList);
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
//        mpg.execute();
//    }
//
//}