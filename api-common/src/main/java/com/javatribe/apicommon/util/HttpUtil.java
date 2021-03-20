package com.javatribe.apicommon.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.javatribe.apicommon.core.constant.GDUFHost;
import com.javatribe.apicommon.dto.UserDTO;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/16 21:28
 * @description
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static UserDTO doGDUFGet(String url) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            logger.info("请求链接为-->{}",url);
            logger.info("响应状态为-->{}",response.getStatusLine());
            if (response.getStatusLine().getStatusCode() == 200) {
                return JSONArray.parseObject(EntityUtils.toString(responseEntity), UserDTO.class);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = GDUFHost.HOST.replace(GDUFHost.PARAM1, "1815491126").replace(GDUFHost.PARAM2, "Sister19971124");
        UserDTO userDTO = HttpUtil.doGDUFGet(s);
        System.out.println(userDTO);
    }
}
