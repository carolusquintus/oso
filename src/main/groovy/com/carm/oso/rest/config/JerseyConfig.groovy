package com.carm.oso.rest.config

import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter
import org.glassfish.jersey.servlet.ServletContainer
import org.glassfish.jersey.servlet.ServletProperties
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Date: Nov 17, 2014
 *
 * @author carolus
 */
@Configuration
class JerseyConfig extends ResourceConfig {

    static final String REST_ROOT = "/rest/api/*"

    public JerseyConfig() {
        register(RequestContextFilter.class)
        packages("com.carm.oso")
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), REST_ROOT)
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName())
        registration.setLoadOnStartup(1)
        return registration
    }
}
