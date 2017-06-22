package com.app.dropshuttle.admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.dropshuttle.customer.*;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@EntityScan(basePackageClasses =UserDao.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class,
	    DataSourceTransactionManagerAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class})
public class Application {
    public static void main(String[] args) throws Throwable {
    	
        SpringApplication.run(Application.class, args);
    }
}