package com.example.collab.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.collab.exception.resource.ConfigurationException;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        Dotenv dotenv = Dotenv.load(); // carrega o .env

        String url = dotenv.get("DB_URL"); // pega a variavel DB_URL do arquivo .env
        String username = dotenv.get("DB_USERNAME"); // pega a variavel DB_USERNAME do arquivo .env
        String password = dotenv.get("DB_PASSWORD"); // pega a variavel DB_PASSWORD do arquivo .env

        if (url == null || username == null || password == null) {

            throw new ConfigurationException("Database environment variables were not found in the .env");

        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}