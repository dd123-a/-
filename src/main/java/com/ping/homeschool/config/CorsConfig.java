package com.ping.homeschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 允许的请求来源，可以使用 * 表示允许任意来源
        config.addAllowedOrigin("*");

        // 允许的请求方法，如 GET、POST 等，可以使用 * 表示允许任意方法
        config.addAllowedMethod("*");

        // 允许的请求头，可以使用 * 表示允许任意请求头
        config.addAllowedHeader("*");

        // 是否允许发送Cookie
        config.setAllowCredentials(true);

        // 预检请求的有效期，单位为秒
        config.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
