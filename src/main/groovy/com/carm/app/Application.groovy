package com.carm.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

/**
 * Date: Nov 01, 2014
 *
 * @author carolus
 */

@ComponentScan
@EnableAutoConfiguration
class Application {
    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
