package com.carm.oso.swagger.config;

import com.mangofactory.swagger.core.SwaggerPathProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;

/**
 * Date: Nov 30, 2014
 *
 * @author carolus
 */
public class ApiPathProvider implements SwaggerPathProvider {

    private SwaggerPathProvider defaultProvider;

    @Autowired
    private ServletContext context;

    private String docsLocation;

    public ApiPathProvider(String docsLocation) {
        this.docsLocation = docsLocation;
    }

    @Override
    public String getApiResourcePrefix() {
        return defaultProvider.getApiResourcePrefix();
    }

    public String getAppBasePath() {
        return UriComponentsBuilder
                .fromHttpUrl(docsLocation)
                .path(context.getContextPath())
                .build()
                .toString();
    }

    @Override
    public String getSwaggerDocumentationBasePath() {
        return UriComponentsBuilder
                .fromHttpUrl(getAppBasePath())
                .pathSegment("api-docs/")
                .build()
                .toString();
    }

    @Override
    public String getRequestMappingEndpoint(String requestMappingPattern) {
        return defaultProvider.getRequestMappingEndpoint(requestMappingPattern);
    }

    public void setDefaultSwaggerPathProvider(SwaggerPathProvider defaultProvider) {
        this.defaultProvider = defaultProvider;
    }
}
