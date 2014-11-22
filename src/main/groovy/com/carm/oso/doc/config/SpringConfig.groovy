package com.carm.oso.doc.config

import com.mangofactory.swagger.plugin.EnableSwagger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

import static org.ajar.swaggermvcui.SwaggerSpringMvcUi.*

/**
 * Date: Nov 07, 2014
 *
 * @author carolus
 */
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.carm.oso")
//@EnableSwagger
class SpringConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(WEB_JAR_RESOURCE_PATTERNS)
                .addResourceLocations(WEB_JAR_RESOURCE_LOCATION).setCachePeriod(0)
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(WEB_JAR_VIEW_RESOLVER_PREFIX)
        resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX)

        return resolver
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable()
    }
}
