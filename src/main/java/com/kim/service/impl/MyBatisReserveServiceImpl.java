package com.kim.service.impl;

import com.kim.service.MyBatisReserveService;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/13.
 */
@Service("myBatisReserveService")
public class MyBatisReserveServiceImpl implements MyBatisReserveService {

    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;

        //指定 逆向工程配置文件
        Resource resource = new ClassPathResource("config/generatorConfig.xml");
//        File configFile = new File("config/generatorConfig.xml");
        File configFile = resource.getFile();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {

        try {
            MyBatisReserveServiceImpl generatorSqlmap = new MyBatisReserveServiceImpl();
            generatorSqlmap.generator();
            System.out.println("编辑完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
