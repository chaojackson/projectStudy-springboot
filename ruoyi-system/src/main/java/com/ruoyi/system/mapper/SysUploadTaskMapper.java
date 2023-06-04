package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUploadTask;

/**
 * 分片上传-分片任务记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-01
 */
public interface SysUploadTaskMapper 
{
    /**
     * 查询分片上传-分片任务记录
     * 
     * @param id 分片上传-分片任务记录主键
     * @return 分片上传-分片任务记录
     */
    public SysUploadTask selectSysUploadTaskById(Long id);

    /**
     * 查询分片上传-分片任务记录列表
     * 
     * @param sysUploadTask 分片上传-分片任务记录
     * @return 分片上传-分片任务记录集合
     */
    public List<SysUploadTask> selectSysUploadTaskList(SysUploadTask sysUploadTask);

    /**
     * 新增分片上传-分片任务记录
     * 
     * @param sysUploadTask 分片上传-分片任务记录
     * @return 结果
     */
    public int insertSysUploadTask(SysUploadTask sysUploadTask);

    /**
     * 修改分片上传-分片任务记录
     * 
     * @param sysUploadTask 分片上传-分片任务记录
     * @return 结果
     */
    public int updateSysUploadTask(SysUploadTask sysUploadTask);

    /**
     * 删除分片上传-分片任务记录
     * 
     * @param id 分片上传-分片任务记录主键
     * @return 结果
     */
    public int deleteSysUploadTaskById(Long id);

    /**
     * 批量删除分片上传-分片任务记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysUploadTaskByIds(Long[] ids);

    public SysUploadTask selectSysUploadTaskByIdentifier(String identifier);
}
