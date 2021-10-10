//package com.weiran.studentmanager.mybatis;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * discription:
// */
//public class CodeGenerator {
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
////        gc.setOutputDir(projectPath + "\\jouavcloud-message" + "/src/main/java");
//        gc.setOutputDir(projectPath + "/src/main/java");
//        // TODO 设置用户名
//        gc.setAuthor("Weiran");
//        gc.setOpen(false);
//        // service 命名方式
//        gc.setServiceName("%sManager");
//        // service impl 命名方式
//        gc.setServiceImplName("%sManagerImpl");
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setEntityName("%sDO");
//        // XML 二级缓存
//        gc.setEnableCache(false);
//        // XML ResultMap
//        gc.setBaseResultMap(true);
//        // XML columList
//        gc.setBaseColumnList(false);
//        gc.setIdType(IdType.AUTO);
//        mpg.setGlobalConfig(gc);
//
//        // TODO 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        // 自定义数据库表字段类型转换【可选】
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            @Override
//            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
//                //将数据库中datetime转换成DATE
//                if (fieldType.toLowerCase().contains("datetime")) {
//                    return DbColumnType.DATE;
//                }
//                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
//            }
//        });
//        mpg.setDataSource(dsc);
//
//        // TODO 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.weiran.studentmanager");
//        pc.setEntity("model");
//        pc.setMapper("mapper");
//        pc.setService("manager");
//        pc.setServiceImpl("manager.impl");
//        pc.setXml("mapper");
//        mpg.setPackageInfo(pc);
//        // pc.setEntity("dal.model");
//        // pc.setMapper("dal.mapper");
//        // pc.setService("biz.manager");
//        // pc.setServiceImpl("biz.manager.impl");
//        // pc.setController("api.controller");
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                // return projectPath + "\\jouavcloud-message" + "/message-dal/src/main/resources/mapper/"
//                //         + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Mapper" + StringPool.DOT_XML;
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
////                return projectPath + "\\jouavcloud-message" + "/message-dal/src/main/java/com/jouav/jouavcloudmessage/dal/model/"
////                        + tableInfo.getEntityName() + StringPool.DOT_JAVA;
//                return projectPath + "/src/main/java/com/weiran/studentmanager/model/" + pc.getModuleName()
//                        + tableInfo.getEntityName() + StringPool.DOT_JAVA;
//            }
//        });
//        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
////                return projectPath + "\\jouavcloud-message" + "/message-dal/src/main/java/com/jouav/jouavcloudmessage/dal/mapper/"
////                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Mapper" + StringPool.DOT_JAVA;
//                return projectPath + "/src/main/java/com/weiran/studentmanager/mapper/"
//                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Mapper" + StringPool.DOT_JAVA;
//            }
//        });
//        focList.add(new FileOutConfig("/templates/service.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
////                return projectPath + "\\jouavcloud-message" + "/message-biz/src/main/java/com/jouav/jouavcloudmessage/biz/manager/"
////                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Manager" + StringPool.DOT_JAVA;
//                return projectPath + "/src/main/java/com/weiran/studentmanager/manager/"
//                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Manager" + StringPool.DOT_JAVA;
//            }
//        });
//        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
////                return projectPath + "\\jouavcloud-message" + "/message-biz/src/main/java/com/jouav/jouavcloudmessage/biz/manager/impl/"
////                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "ManagerImpl" + StringPool.DOT_JAVA;
//                return projectPath + "/src/main/java/com/weiran/studentmanager/manager/impl/"
//                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "ManagerImpl" + StringPool.DOT_JAVA;
//            }
//        });
//        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
////                return projectPath + "\\jouavcloud-message" + "/message-api/src/main/java/com/jouav/jouavcloudmessage/api/controller/"
////                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Controller" + StringPool.DOT_JAVA;
//                return projectPath + "/src/main/java/com/weiran/studentmanager/controller/"
//                        + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length() - 2) + "Controller" + StringPool.DOT_JAVA;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        cfg.setFileCreate((configBuilder, fileType, filePath) -> {
//            //如果是Entity则直接返回true表示写文件
//            if (filePath.endsWith("DO.java")) {
//                return true;
//            }
//            //否则先判断文件是否存在
//            File file = new File(filePath);
//            boolean exist = file.exists();
//            if (!exist) {
//                file.getParentFile().mkdirs();
//            }
//            //文件不存在或者全局配置的fileOverride为true才写文件
//            return !exist || configBuilder.getGlobalConfig().isFileOverride();
//        });
//        mpg.setCfg(cfg);
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        // 配置自定义输出模板
//        //此处设置为null，就不会再java下创建xml的文件夹了
//        templateConfig.setXml(null);
//        templateConfig.setEntity(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
//        templateConfig.setMapper(null);
//        templateConfig.setController(null);
//        mpg.setTemplate(templateConfig);
//
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        // strategy.setTablePrefix("jouav_"); // 表名前缀
//        // TODO 指定生成的bean的数据库表名
//        String[] dataTable = new String[]{
//                "user", "role", "role_permission", "permission"
//        };
//        strategy.setInclude(dataTable);
//        strategy.setRestControllerStyle(true);
//        // 驼峰转连字符
//        strategy.setControllerMappingHyphenStyle(false);
//        // 自定义需要填充的字段 数据库中的字段
//        List<TableFill> timeAuto = new ArrayList<>();
//        timeAuto.add(new TableFill("created_at", FieldFill.INSERT));
//        timeAuto.add(new TableFill("updated_at", FieldFill.INSERT_UPDATE));
//        strategy.setTableFillList(timeAuto);
//        mpg.setStrategy(strategy);
//        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//}
