package com.javatribe.apicompetition.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.HtmlUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author lyr
 * @create 2021/1/17 1:14
 */
@Slf4j
public class HtmlUtil {
    /**
     * 过滤脚本
     * @param pojo
     */
    public static void escapeHtml(Object pojo) {
        if (pojo == null) {
            return;
        }
        try {
            for (Field field: pojo.getClass().getDeclaredFields()) {
                int modi = field.getModifiers();
                if (Modifier.isStatic(modi) || Modifier.isFinal(modi)) {
                    //if  static or final  field ,continue
                    continue;
                }
                //过滤 html 标签
                field.setAccessible(true);
                if (String.class.isAssignableFrom(field.getType())) {
                    String val = null;

                    val = (String) field.get(pojo);

                    if (val != null) {
                        field.set(pojo, HtmlUtils.htmlEscape(val));
                    }
                }
            }
        }catch (IllegalAccessException ex) {
            log.error("服务器消息异常");
        }

    }
}
