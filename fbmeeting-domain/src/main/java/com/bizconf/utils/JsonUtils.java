/**
 * 
 */
package com.bizconf.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ZhaoHongbo
 *
 */
public class JsonUtils {
	
	private static JsonFactory jsonFactory = new JsonFactory();

	public static String toJsonCompress(Object obj){
		return compress(toJson(obj));
	}

	@SuppressWarnings("deprecation")
	public static String toJson(Object obj) {
		String json = "";
		Writer w = new StringWriter();
		try {
			JsonGenerator jg = jsonFactory.createJsonGenerator(w);
			jg.useDefaultPrettyPrinter();
			@SuppressWarnings("unused")
			StdSerializerProvider sp = new StdSerializerProvider();
			ObjectMapper mapper = new ObjectMapper();
			
			SerializationConfig c = mapper.getSerializationConfig();
			//过期的忽略Null值的属性方法
			//c.set(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
			
			//最新忽略Null值的属性方法
//			c.setSerializationInclusion(Inclusion.NON_NULL);
			
			mapper.setSerializationConfig(c);
			mapper.writeValue(jg, obj);
			json = w.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
				w = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}

	public static String toJson(Object obj, boolean usePretty) {
		String json = "";
		Writer w = new StringWriter();
		try {
			JsonGenerator jg = jsonFactory.createJsonGenerator(w);
			if (usePretty) {
				jg.useDefaultPrettyPrinter();
			}
			@SuppressWarnings("unused")
			StdSerializerProvider sp = new StdSerializerProvider();
			ObjectMapper mapper = new ObjectMapper();

			SerializationConfig c = mapper.getSerializationConfig();
			//过期的忽略Null值的属性方法
			//c.set(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

			//最新忽略Null值的属性方法
			c.setSerializationInclusion(Inclusion.NON_NULL);

			mapper.setSerializationConfig(c);
			mapper.writeValue(jg, obj);
			json = w.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
				w = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
	
	/**
	 * 返回JSON数据构造成的Map
	 * 
	 * @param jsonText
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map readToMap(String jsonText) {
		ObjectMapper o = new ObjectMapper();
		o.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		o.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		o.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		o.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		o.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
		Map maps = null;
		try {
			maps = o.readValue(jsonText, Map.class);
			return maps;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_MAP;
	}

	public static <T> List<T> readToList(String jsonText , Class<T> clazz) {
		ObjectMapper o = new ObjectMapper();
		o.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		o.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		o.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		o.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		o.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
		JavaType javaType = o.getTypeFactory().constructParametricType(ArrayList.class, clazz);
		try {
			List<T> list = o.readValue(jsonText, javaType);
			return  list;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String compress(String json)
	{
		if (json == null)
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		boolean skip = true;// true 允许截取(表示未进入string双引号)
		boolean escaped = false;// 转义符
		for (int i = 0; i < json.length(); i++)
		{
			char c = json.charAt(i);
			if (!escaped && c == '\\')
			{
				escaped = true;
			}
			else
			{
				escaped = false;
			}
			if (skip)
			{
				if (c == ' ' || c == '\r' || c == '\n' || c == '\t')
				{
					continue;
				}
			}
			sb.append(c);
			if (c == '"' && !escaped)
			{
				skip = !skip;
			}
		}
		return sb.toString().replaceAll("\r\n", "\\\\r\\\\n");
	}
}

