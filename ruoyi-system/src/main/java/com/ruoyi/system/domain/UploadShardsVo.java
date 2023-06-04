package com.ruoyi.system.domain;

import lombok.Data;

/**
 * @ClassName UploadShardsVo
 * @Description TODO
 * @Author zyc
 * @Date 2023/6/1 22:26
 * @Version 1.0
 */
@Data
public class UploadShardsVo {

    /** 文件md5 **/
    private String identifier;

    /** 分片编号 **/
    private Integer partNumber;
}
