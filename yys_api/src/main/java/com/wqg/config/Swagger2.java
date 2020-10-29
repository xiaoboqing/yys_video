package com.wqg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration//必须存在
@EnableWebMvc //必须存在
//扫描的API Controller包
@ComponentScan(basePackages = {"com.wqg.api"})
public class Swagger2 {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact("LB", "www.baidu.com", "1471385294@qq.com");
        return new ApiInfoBuilder()
                .title("swagger入门项目接口")
                .description("API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
