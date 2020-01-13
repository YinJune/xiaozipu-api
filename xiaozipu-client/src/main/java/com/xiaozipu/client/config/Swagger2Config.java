package com.xiaozipu.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //过滤Swagger响应的API
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaozipu.client.web"))
                .paths(PathSelectors.any())
                .build();
    }

    //自定义信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("小资铺客户端 API")
                //创建人
                .contact(new Contact("殷俊杰", "http://www.baidu.com", "247385709@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("小资铺API")
                .build();
    }
}
