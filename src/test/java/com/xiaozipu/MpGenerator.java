package com.xiaozipu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 代码生成器
 * @description
 */
public class MpGenerator {

    @Test
    public void generateCode() {
        String packageName = "com.xiaozipu.data";
        //true user-->UserService, false user-->IUserService
        boolean serviceNameStartWithI = true;
        //需要自动生成的表
        String[] tables = new String[]{"loan_order"};
        generateByTables(serviceNameStartWithI, packageName, tables);

    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tables) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/huahuale";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                        .setUrl(dbUrl)
                        .setUsername("root")
                        .setPassword("root")
                        .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tables);
        config.setActiveRecord(true)
                .setAuthor("along")
                .setOutputDir("F:\\code\\xiaozipu\\src\\main\\java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig().setParent(packageName)
                        .setController("controller")
                        .setEntity("entity").
                         setMapper("mapper")
                ).execute();
    }

}
