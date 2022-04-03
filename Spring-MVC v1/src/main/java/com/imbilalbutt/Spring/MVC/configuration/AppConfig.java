package com.imbilalbutt.Spring.MVC.configuration;


import com.imbilalbutt.Spring.MVC.repository.DistributedRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = DistributedRepository.class)
public class AppConfig {
}
