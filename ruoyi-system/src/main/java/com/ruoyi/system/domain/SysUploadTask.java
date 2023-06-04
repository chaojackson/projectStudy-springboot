package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分片上传-分片任务记录对象 sys_upload_task
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public class SysUploadTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 分片上传的uploadId */
    @Excel(name = "分片上传的uploadId")
    private String uploadId;

    /** 文件唯一标识（md5） */
    @Excel(name = "文件唯一标识", readConverterExp = "m=d5")
    private String fileIdentifier;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 所属桶名 */
    @Excel(name = "所属桶名")
    private String bucketName;

    /** 文件的key */
    @Excel(name = "文件的key")
    private String objectKey;

    /** 文件大小（byte） */
    @Excel(name = "文件大小", readConverterExp = "b=yte")
    private Long totalSize;

    /** 每个分片大小（byte） */
    @Excel(name = "每个分片大小", readConverterExp = "b=yte")
    private Long chunkSize;

    /** 分片数量 */
    @Excel(name = "分片数量")
    private Integer chunkNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUploadId(String uploadId) 
    {
        this.uploadId = uploadId;
    }

    public String getUploadId() 
    {
        return uploadId;
    }
    public void setFileIdentifier(String fileIdentifier) 
    {
        this.fileIdentifier = fileIdentifier;
    }

    public String getFileIdentifier() 
    {
        return fileIdentifier;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setBucketName(String bucketName) 
    {
        this.bucketName = bucketName;
    }

    public String getBucketName() 
    {
        return bucketName;
    }
    public void setObjectKey(String objectKey) 
    {
        this.objectKey = objectKey;
    }

    public String getObjectKey() 
    {
        return objectKey;
    }
    public void setTotalSize(Long totalSize) 
    {
        this.totalSize = totalSize;
    }

    public Long getTotalSize() 
    {
        return totalSize;
    }
    public void setChunkSize(Long chunkSize) 
    {
        this.chunkSize = chunkSize;
    }

    public Long getChunkSize() 
    {
        return chunkSize;
    }
    public void setChunkNum(Integer chunkNum)
    {
        this.chunkNum = chunkNum;
    }

    public Integer getChunkNum()
    {
        return chunkNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uploadId", getUploadId())
            .append("fileIdentifier", getFileIdentifier())
            .append("fileName", getFileName())
            .append("bucketName", getBucketName())
            .append("objectKey", getObjectKey())
            .append("totalSize", getTotalSize())
            .append("chunkSize", getChunkSize())
            .append("chunkNum", getChunkNum())
            .toString();
    }
}
