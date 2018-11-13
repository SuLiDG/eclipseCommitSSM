package com.df.ssm.commons;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;

/**
 * 将Long类型的数据采用字符串的形式输出，解决前端js中long类型精度问题
 * @author J.L.Zhou
 *
 */
public class FastJSONLong {

	static {
		
		ObjectSerializer serializer = new ObjectSerializer() {
            @Override
            public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
                    throws IOException {
                SerializeWriter out = serializer.getWriter();

                if (fieldType == long.class || fieldType == Long.class || object instanceof Long) {
                    out.writeString(Objects.toString(object, null));
                }
            }
        };
        
		SerializeConfig.getGlobalInstance().put(Long.class, serializer);
		SerializeConfig.getGlobalInstance().put(long.class, serializer);
	}
}
