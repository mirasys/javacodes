package com.mirasysgroup.javacodes.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.driverClassName}")
    private String dataSourceDriverClassName;
    @Value("${spring.datasource.jdbc-url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;
    @Value("${spring.datasource.pool.size}")
    private int dataSourcePoolSize;

    @Bean(name = "allDataDataSource")
    @Primary
    public DataSource allDataDataSource(){
        try (HikariDataSource ds = new HikariDataSource()){
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(dataSourceDriverClassName);
            config.setJdbcUrl(dataSourceUrl);
            config.setUsername(dataSourceUsername);
            config.setPassword(dataSourcePassword);
            config.setMaximumPoolSize(dataSourcePoolSize);
            return new HikariDataSource(config);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Bean
    public Flyway flyway(@Qualifier("allDataDataSource") DataSource allDataDataSource){
        Flyway flyway = Flyway.configure()
                .dataSource(allDataDataSource)
                .baselineOnMigrate(true)
                .validateOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }
}
