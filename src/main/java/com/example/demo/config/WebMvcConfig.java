package com.example.demo.config;


import com.example.demo.domain.enums.BaseEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.ClassKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        var stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        var converter = new MappingJackson2HttpMessageConverter();

        converter.setObjectMapper(objectMapperForWebConvert());
        converters.addFirst(stringHttpMessageConverter);
        converters.addFirst(converter);
    }


    public ObjectMapper objectMapperForWebConvert() {
        var om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        var sm = getSimpleModule();

        sm.addSerializer(BaseEnum.class, new JsonSerializer<>() {
            @Override
            public void serialize(BaseEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(value.getName());
            }
        });
        om.registerModule(sm);

        return om;
    }

    private static SimpleModule getSimpleModule() {
        var sm = new SimpleModule();
        //自定义查找规则
        sm.setDeserializers(new SimpleDeserializers() {
            @Override
            public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config,
                                                            BeanDescription beanDesc) throws JsonMappingException {
                var enumDeserializer = super.findEnumDeserializer(type, config, beanDesc);
                if (enumDeserializer != null) {
                    return enumDeserializer;
                }
                //遍历枚举实现的接口, 查找反序列化器
                for (var typeInterface : type.getInterfaces()) {
                    enumDeserializer = this._classMappings.get(new ClassKey(typeInterface));
                    if (enumDeserializer != null) {
                        return enumDeserializer;
                    }
                }
                return null;
            }
        });
        return sm;
    }
}
