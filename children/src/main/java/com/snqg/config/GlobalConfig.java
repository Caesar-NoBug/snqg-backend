package com.snqg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.snqg")
public class GlobalConfig {
}
