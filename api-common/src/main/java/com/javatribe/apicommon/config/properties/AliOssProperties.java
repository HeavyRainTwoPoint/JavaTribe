package com.javatribe.apicommon.config.properties;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS 对象 配置
 * @Author lyr
 * @create 2020/11/21 22:38
 */
@Configuration
@ConfigurationProperties(prefix = "oss")
@Data
public class AliOssProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;

    private String bucketName;

    private String host;

    /**
     * 返回 OSS api 操作对象
     * @return
     */
    @Bean
    public OSS getOOSClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}