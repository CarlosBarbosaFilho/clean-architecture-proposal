package br.com.cbgomes.swagger

import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
class SwaggerConfiguration(
    val environment: Environment
) {
    @Bean
    fun swaggerDocket(): Docket =
        Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(Predicates.not(PathSelectors.regex("/error|/info|/health.*")))
            .build()
            .apiInfo(apiInfo())

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "Clean Architecture Proposal ",
            "Demo Proposal The Clean Architecture",
            "V1",
            "Services terms",
            Contact("Demo Clean Architecture", "", ""),
            "",
            "",
            listOf()
        )
    }
}
