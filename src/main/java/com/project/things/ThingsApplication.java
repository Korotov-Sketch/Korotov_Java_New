package com.project.things;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebMvc
public class ThingsApplication {
   /* @Autowired
    private DataSource dataSource;*/

    public static void main(String[] args) {
        SpringApplication.run(ThingsApplication.class, args);
    }

   /* @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("db/initRecords.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }*/

}
