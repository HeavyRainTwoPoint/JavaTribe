package com.javatribe.apicommon.config.properties;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * OSS 对象 配置
 * @Author lyr
 * @create 2020/11/21 22:38
 */
@Configuration
@ConfigurationProperties(prefix = "oss")
@Data
// <<<<<<< HEAD
//
// =======
// @ConditionalOnProperty(value = "oss")
//@ConditionalOnProperty(value = "oss")
// >>>>>>> 9d8a4a18581b6f94fa77c62de6634b3d29b70eea
@Component
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
    @Scope("prototype")
    @ConditionalOnBean(AliOssProperties.class)
    public OSS getOSSClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }


}