package com.lumine.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {
    /**
     * 是否开启Swagger
     */
    private Boolean enable;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 调试地址
     */
    private String host;
}
