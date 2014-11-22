package com.carm.oso.doc.config

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.plugin.EnableSwagger
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
import com.wordnik.swagger.model.ApiInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Date: Nov 07, 2014
 *
 * @author carolus
 */
@Configuration
@EnableSwagger
class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig

    @Autowired
    void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig
    }

    @Bean
     SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns("/user/.*")
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "OSO API Title",
                "OSO API Description",
                "OSO API terms of service",
                "OSO API Contact Email",
                "OSO API Licence Type",
                "OSO API License URL"
        )

        return apiInfo
    }
}
