package edu.csupomona.cs480.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This config has everything needed to use the H2 database
 * with Spring Data JPA in JUnit tests.
 *
 *
 * @Configuration = tells Spring Framework this is a Java config class.
 * @EnableAutoConfiguration = tells Spring to auto config and auto create Beans
 *                             with sensible defaults for our tests.
 * @EntityScan = specifies the packages to look for JPA Entities.
 * @EnableTransactionManagement = Enables Spring's annotation driven transaction management.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"edu.csupomona.cs480.data.entity"})
@EnableJpaRepositories(basePackages = "edu.csupomona.cs480.data.repository")
@EnableTransactionManagement
public class RepositoryConfiguration {
}
