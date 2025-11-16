package com.zzs.temporaryutil.demo.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevToolsService {

    private DebugLogger logger;

    // 关键：可选注入
    @Autowired(required = false)
    public void setDebugLogger(DebugLogger logger) {
        this.logger = logger;
    }

    public void analyzePerformance() {
        System.out.println("正在分析系统性能...");

        Optional.ofNullable(logger)
                .ifPresent(l -> l.log("性能分析完成，耗时 128ms"));

        if (logger == null) {
            System.out.println("[PROD MODE] 调试日志未启用（生产环境正常）");
        }
    }
}