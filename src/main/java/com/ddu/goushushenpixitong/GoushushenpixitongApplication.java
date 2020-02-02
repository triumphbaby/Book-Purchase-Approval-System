package com.ddu.goushushenpixitong;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;
import java.util.Properties;

@MapperScan({"com.ddu.goushushenpixitong.mapper","com.ddu.goushushenpixitong.auth.mapper"})
@SpringBootApplication
public class GoushushenpixitongApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoushushenpixitongApplication.class, args);
    }

    /**
     * 配置mybatis的分页插件pageHelper
     *
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }


}
