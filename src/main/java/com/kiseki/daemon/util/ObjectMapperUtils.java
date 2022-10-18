package com.kiseki.daemon.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class ObjectMapperUtils {

    /**
     * 定义常量对象
     * 优势：
     * 对象独一份，节省空间
     * 对象不允许别人随意篡改
     * 保持统一，公共调用
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // config
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        // 如果 json 中有新增的字段并且是实体类类中不存在的，不报错
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 修改日期格式
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static String writeValueAsString(Object object) {
        try {
            if (object == null) {
                throw new RuntimeException("传递的参数 [object] 为 null, 请认真检查");
            }
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // 应该为检查异常，转化为运行时异常
            throw new RuntimeException("传递的对象不支持 json 转化/检查是否有 getter/setter 方法");
        }
    }

    public static <T> T readValue(String json, Class<T> target) {
        if (StringUtils.isEmpty(json) || target == null) {
            throw new RuntimeException("传递的参数不能为 null ");
        }
        try {
            return OBJECT_MAPPER.readValue(json, target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("json 转化异常");
        }
    }
}
