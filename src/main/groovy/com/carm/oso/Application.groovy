package com.carm.oso

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.plugin.EnableSwagger
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
import com.wordnik.swagger.model.ApiInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */
@Configuration
@ComponentScan("com.carm.oso")
@EnableAutoConfiguration
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
