package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.InitTaskParam;
import com.ruoyi.system.domain.SysUploadTask;
import com.ruoyi.system.domain.TaskInfoDTO;

/**
 * 分片上传-分片任务记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public interface ISysUploadTaskService 
{
    void merge(String identifier);

    SysUploadTask getByIdentifier(String identifier);

    String genPreSignUploadUrl(String bucketName, String objectKey, Map<String, String> params);

    TaskInfoDTO initTask(InitTaskParam param);

    TaskInfoDTO getTaskInfo(String identifier);
}
