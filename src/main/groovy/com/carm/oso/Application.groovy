package com.carm.oso

//import com.mangofactory.swagger.plugin.EnableSwagger
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */
@Configuration
@ComponentScan("com.carm.oso")
@EnableAutoConfiguration
//@EnableSwagger
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}