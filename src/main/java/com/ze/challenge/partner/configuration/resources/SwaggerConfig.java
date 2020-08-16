package com.ze.challenge.partner.configuration.resources;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.AlternateTypeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String PATH = "/partner/.*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(PATH))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "ZE DELIVERY PARTNER",
                "BACKEND CHALLENGE",
                "1.0",
                "TERMS OF SERVICE URL",
                new Contact("JOSÉ KLEITON","URL","KLEITON.CONTATO@GMAIL.COM"),
                "OPEN SOURCE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    @Bean
    public AlternateTypeRuleConvention typeConvention(final TypeResolver resolver) {
        return new AlternateTypeRuleConvention() {

            @Override
            public int getOrder() {
                return Ordered.HIGHEST_PRECEDENCE;
            }

            @Override
            public List<AlternateTypeRule> rules() {
                return Collections.singletonList(
                        AlternateTypeRules.newRule(resolver.resolve(JsonNode.class), resolver.resolve(jsonNodeApi()))
                );
            }
        };
    }

    private Class<?> jsonNodeApi() {
        return new AlternateTypeBuilder()
                .fullyQualifiedClassName(
                        String.format("%s.generated.%s",
                                JsonNode.class.getPackage().getName(),
                                JsonNode.class.getSimpleName()))
                .build();
    }
}
