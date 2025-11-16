package com.zzs.temporaryutil.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUser(Long id) {
        System.out.println("=== 执行 getUser 业务逻辑 ===");
        return "User-" + id;
    }

    public void deleteUser(Long id) {
        System.out.println("=== 执行 deleteUser 业务逻辑 ===");
    }
}