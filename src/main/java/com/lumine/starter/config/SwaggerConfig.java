package com.lumine.starter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

/**
 * Swagger配置
 *
 * @author 斑马
 * @author CGM
 */
@Configuration
public class SwaggerConfig {
    /**
     * X-Token为vue-element-admin所使用的名称
     */
    private static final String TOKEN_NAME = "X-Token";
    /**
     * 传输途径
     */
    private static final String PASS_AS = "header";

    @Value("${spring.application.version}")
    private String version;

    private final SwaggerProperties swaggerProperties;

    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    /**
     * 构建API文档插件
     *
     * @return 文档插件
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(swaggerProperties.getEnable())
                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())
                // 接口调试地址
                .host(swaggerProperties.getHost())
                // 选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(new LinkedHashSet<>(Arrays.asList("https", "http")))
                // 授权信息设置，必要的header token等认证信息
                .securitySchemes(Collections.singletonList(new ApiKey(TOKEN_NAME, TOKEN_NAME, PASS_AS)))
                // 授权信息全局应用
                .securityContexts(securityContexts());
    }

    /**
     * 展示在页面顶部的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact("cgm", "https://github.com/lumine1996", "675056544@qq.com"))
                .version(version)
                .build();
    }

    /**
     * 用于调用接口时附加token
     *
     * @return 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = {authorizationScope};
        SecurityReference securityReference = new SecurityReference(TOKEN_NAME, authorizationScopes);

        SecurityContext securityContext = SecurityContext.builder()
                .securityReferences(Collections.singletonList(securityReference))
                .build();
        return Collections.singletonList(securityContext);
    }
}
