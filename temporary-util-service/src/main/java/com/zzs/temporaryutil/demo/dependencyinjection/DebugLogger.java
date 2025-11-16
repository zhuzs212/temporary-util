package com.zzs.temporaryutil.demo.dependencyinjection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")  // 仅在 dev 环境激活
public class DebugLogger {
    public void log(String message) {
        System.out.println("[DEV DEBUG] " + message);
    }
}