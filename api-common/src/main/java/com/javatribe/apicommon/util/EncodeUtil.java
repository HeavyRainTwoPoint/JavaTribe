package com.javatribe.apicommon.util;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 18:53
 * @description 教务系统解码
 */
public class EncodeUtil {
    /**
     * Java执行JavaScript脚本破解加密算法
     *
     * @param str
     * @return 加密后的字符串
     */
    public static String playJs(String str) {
        // 创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 获取一个指定的名称的脚本引擎
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            // 获取当前类的所在目录的路径（%20是处理空格）
            String path = "api-common/src/main/java/com/javatribe/apicommon/util/";
            // FileReader的参数为所要执行的js文件的路径（对空格进行处理）
            engine.eval(new FileReader(path + "conwork.js"));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                // 从脚本引擎中返回一个给定接口的实现
                Methods executeMethod = invocable.getInterface(Methods.class);
                // 执行指定的js方法
                return executeMethod.encodeInp(str);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String s = playJs("181549126");
        String s2 = playJs("Sister19971124");
        System.out.println(s + "%%%" + s2);

    }
}
