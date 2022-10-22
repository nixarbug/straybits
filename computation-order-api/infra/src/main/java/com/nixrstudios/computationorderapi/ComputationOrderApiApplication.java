package com.nixrstudios.computationorderapi;

import com.nixrstudios.computationorderapi.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
        }
)
public class ComputationOrderApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComputationOrderApiApplication.class, args);
    }
}
