package com.zzs;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.zzs.temporaryutil.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableCreateCacheAnnotation// 启用 @CreateCache 注解创建缓存实例
@EnableMethodCache(basePackages = "com.zzs.temporaryutil")// 启用方法级缓存（@Cached, @CacheUpdate, @CacheInvalidate）
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zzs.temporaryutil.*")// 扫描 Feign 客户端
@MapperScan("com.zzs.temporaryutil.mapper")// 告诉 MyBatis：去哪里扫描 @Mapper 接口，自动注册为 Spring Bean。
public class TemporaryUtilServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemporaryUtilServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            System.out.println("========== 调用 getUser ==========");
            String user = userService.getUser(100L);
            System.out.println("结果: " + user);

            System.out.println("\n========== 调用 deleteUser ==========");
            userService.deleteUser(200L);
        };
    }

}
