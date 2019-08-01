package com.yqkj.flow.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Token 信息配置
     * @return
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenBuilder = new ParameterBuilder();
//        List<Parameter> parameterList = new ArrayList<Parameter>();
       /* tokenBuilder.name("Authorization")
                .defaultValue("去其他请求中获取heard中token参数")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).build();*/
//        parameterList.add(tokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(parameterList);
    }

    /**
     * 接口信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("YQKJ FLOW API ")
                .description("YQKJ FLOW")
                .termsOfServiceUrl("")
                .contact(new Contact("yangchao.cool@gmail.com","yangchao.cool@gmail.com","yangchao.cool@gmail.com"))
                .version("1.0")
                .build();
    }

}