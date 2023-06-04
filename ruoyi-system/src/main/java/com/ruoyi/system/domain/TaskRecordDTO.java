package com.ruoyi.system.domain;

import cn.hutool.core.bean.BeanUtil;
import com.amazonaws.services.s3.model.PartSummary;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName TaskRecordDTO
 * @Description TODO
 * @Author zyc
 * @Date 2023/6/1 21:30
 * @Version 1.0
 */
@Data
@ToString
@Accessors(chain = true)
public class TaskRecordDTO  extends SysUploadTask{

    /**
     * 已上传完的分片
     */
    private List<PartSummary> exitPartList;

    public static TaskRecordDTO convertFromEntity (SysUploadTask task) {
        TaskRecordDTO dto = new TaskRecordDTO();
        BeanUtil.copyProperties(task, dto);
        return dto;
    }
}
