
package com.pogong.MyChat.config;

import com.pogong.MyChat.dao.TvSeriesDao;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackageClasses = {TvSeriesDao.class})
@EnableTransactionManagement
public class DalConfig {

    //Dao映射配置
    @Value(value = "classpath:mybatis-config.xml")
    private Resource configLocation;

    //数据库连接配置
    @Value(value = "${data.driver-class-name}")
    private String driver;
    @Value(value = "${data.url}")
    private String url;
    @Value(value = "${data.username}")
    private String userName;
    @Value(value = "${data.password}")
    private String pwd;

    @Bean
    public DataSource getDataSource() {
        DataSource dataSource = new DriverManagerDataSource();
        ((DriverManagerDataSource) dataSource).setDriverClassName(driver);
        ((DriverManagerDataSource) dataSource).setUrl(url);
        ((DriverManagerDataSource) dataSource).setUsername(userName);
        ((DriverManagerDataSource) dataSource).setPassword(pwd);
        return dataSource;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setConfigLocation(configLocation);
        ssfb.setDataSource(getDataSource());
        return ssfb;
    }

}
