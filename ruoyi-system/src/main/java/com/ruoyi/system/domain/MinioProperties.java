package com.ruoyi.system.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName MinioProperties
 * @Description TODO
 * @Author zyc
 * @Date 2023/6/1 21:33
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    /** minio服务地址 **/
    @Value("endpoint")
    private String endpoint;

    /** minio服务访问账号 **/
    @Value("access-key")
    private String accessKey;

    /** minio服务访问密码 **/
    @Value("access-secret")
    private String accessSecret;

    /** minio服务存储桶名称 **/
    @Value("bucket")
    private String bucket;
}
