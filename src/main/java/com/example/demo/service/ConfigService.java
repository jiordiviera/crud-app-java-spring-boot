package com.example.demo.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    Dotenv dotenv = Dotenv.load();

    public void printConfig() {
        System.out.println("APP_NAME: " + dotenv.get("APP_NAME"));
        System.out.println("DB_HOST: " + dotenv.get("DB_HOST"));
        System.out.println("JWT_SECRET: " + dotenv.get("JWT_SECRET"));
    }
}