package com.ruoyi.system.domain;

/**
 * @ClassName MinioConstant
 * @Description TODO
 * @Author zyc
 * @Date 2023/6/1 21:34
 * @Version 1.0
 */
public interface MinioConstant {
    // 分块大小
    int DEFAULT_CHUNK_SIZE = 10 * 1024 * 1024;

    // 预签名url过期时间(ms)
    Long PRE_SIGN_URL_EXPIRE = 60 * 10 * 1000L;
}
