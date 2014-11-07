package com.carm.oso

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.grails.datastore.mapping.validation.ValidationErrors

/**
 * Date: Nov 06, 2014
 *
 * @author carolus
 */
class ErrorsSerializer extends JsonSerializer<ValidationErrors> {

    @Override
    void serialize(ValidationErrors errors, JsonGenerator jgen, SerializerProvider provider) {
        jgen.writeStartObject()
        jgen.writeEndObject()
    }
}