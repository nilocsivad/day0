/**
 * 
 */
package com.iam_vip.day0.rs.adapter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * /// 返回数据的类型转化 ///
 * @author Colin
 */
public class CustomValueConvertObjectMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CustomValueConvertObjectMapper() {
		super();

		/// 空值转为字符串 "" ///
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeString("");
			}
		});

	}

}
