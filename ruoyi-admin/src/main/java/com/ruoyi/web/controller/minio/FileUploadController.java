package com.ruoyi.web.controller.minio;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.InitTaskParam;
import com.ruoyi.system.domain.SysUploadTask;
import com.ruoyi.system.domain.UploadShardsVo;
import com.ruoyi.system.service.ISysUploadTaskService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FileUploadController
 * @Description 使用minio 文件上传 demo   大文件上传demo
 * @Author zyc
 * @Date 2023/6/1 16:51
 */
@RestController
@RequestMapping("/system/file")
public class FileUploadController extends BaseController {

    /**
     * 服务对象
     */
    @Resource
    private ISysUploadTaskService sysUploadTaskService;


    /**
     * 获取上传进度
     * @param identifier 文件md5
     * @return
     */
    @GetMapping("/{identifier}")
    public AjaxResult taskInfo (@PathVariable("identifier") String identifier) {
        return success(sysUploadTaskService.getTaskInfo(identifier));
    }

    /**
     * 创建一个上传任务
     * @return
     */
    @PostMapping
    public AjaxResult initTask (@Valid @RequestBody InitTaskParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return error(bindingResult.getFieldError().getDefaultMessage());
        }
        return success(sysUploadTaskService.initTask(param));
    }

    /**
     * 获取每个分片的预签名上传地址
     * @param vo
     * @return
     */
    @PostMapping("/getIdentifierUrl")
    public AjaxResult preSignUploadUrl (@RequestBody UploadShardsVo vo) {
        SysUploadTask task = sysUploadTaskService.getByIdentifier(vo.getIdentifier());
        if (task == null) {
            return error("分片任务不存在");
        }
        Map<String, String> params = new HashMap<>();
        params.put("partNumber", vo.getPartNumber().toString());
        params.put("uploadId", task.getUploadId());
        return success(sysUploadTaskService.genPreSignUploadUrl(task.getBucketName(), task.getObjectKey(), params));
    }

    /**
     * 合并分片
     * @param identifier
     * @return
     */
    @PostMapping("/merge/{identifier}")
    public AjaxResult merge (@PathVariable("identifier") String identifier) {
        sysUploadTaskService.merge(identifier);
        return success();
    }
}
