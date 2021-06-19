package com.jjf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration// 配置类注解
@ComponentScan(basePackages = "com.jjf")// Spring包扫描
@PropertySource(value = "classpath:jdbc.properties")// 读取属性配置文件
@EnableTransactionManagement// 开启事务注解
public class SpringConfig {

    // 从配置中取值
    @Value("${jdbc_username}")
    private String username;
    @Value("${jdbc_password}")
    private String password;
    @Value("${jdbc_driver}")
    private String driver;
    @Value("${jdbc_url}")
    private String url;

    /**
     * Bean注解，Spring自动管理
     *
     * @return
     */
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        return dataSource;
    }

    /**
     * DataSource参数，Spring会自动从容器中查找有没有，有就自动注入进来
     *
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
