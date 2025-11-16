package com.zzs.temporaryutil.demo.dependencyinjection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(DevToolsService devToolsService) {
        return args -> {
            System.out.println("开始执行性能分析...\n");
            devToolsService.analyzePerformance();
            System.out.println("\n执行完成。");
        };
    }
}