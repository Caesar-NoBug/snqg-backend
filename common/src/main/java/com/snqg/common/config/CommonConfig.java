package com.snqg.common.config;

import com.snqg.common.util.WechatUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.snqg.common")
public class CommonConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
