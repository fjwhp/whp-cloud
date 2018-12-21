
package com.cloud.whp.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.cloud.whp.common.security.exception.WhpAuth2Exception;

import java.io.IOException;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * OAuth2 异常格式化
 */
public class WhpAuth2ExceptionSerializer extends StdSerializer<WhpAuth2Exception> {
	public WhpAuth2ExceptionSerializer() {
		super(WhpAuth2Exception.class);
	}

	@Override
	public void serialize(WhpAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeObjectField("code", 1);
		gen.writeStringField("message", value.getMessage());
		gen.writeStringField("data", value.getOAuth2ErrorCode());
		gen.writeEndObject();
	}
}
