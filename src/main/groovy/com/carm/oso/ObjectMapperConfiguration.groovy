package com.carm.oso

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import org.grails.datastore.mapping.validation.ValidationErrors
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Date: Nov 06, 2014
 *
 * @author carolus
 */
@Component
class ObjectMapperConfiguration implements InitializingBean {

    @Autowired
    ObjectMapper objectMapper

    @Override
    void afterPropertiesSet() {
        def validationErrorsModule = new SimpleModule()
        validationErrorsModule.addSerializer(ValidationErrors, new ErrorsSerializer())
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.registerModule(validationErrorsModule)
    }

}