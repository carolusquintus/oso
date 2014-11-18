package com.carm.oso

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

    static final String REST_ROOT = "/rest/oso/*"

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), REST_ROOT)
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyServletConfig.class.getName())
        return registration
    }

    public static class JerseyServletConfig extends ResourceConfig {
        public JerseyServletConfig() {
            register(RequestContextFilter.class)
            packages("com.carm.oso")
        }
    }
}
