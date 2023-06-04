<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="分片数量" prop="chunkNum">
        <el-input
          v-model="queryParams.chunkNum"
          placeholder="请输入分片数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:task:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:task:edit']"
        >修改</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="分片上传的" align="center" prop="uploadId" />
      <el-table-column label="文件唯一标识" align="center" prop="fileIdentifier" />
      <el-table-column label="文件名" align="center" prop="fileName" />
      <el-table-column label="所属桶名" align="center" prop="bucketName" />
      <el-table-column label="文件的key" align="center" prop="objectKey" />
      <el-table-column label="文件大小" align="center" prop="totalSize" />
      <el-table-column label="每个分片大小" align="center" prop="chunkSize" />
      <el-table-column label="分片数量" align="center" prop="chunkNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:task:edit']"
          >修改</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改分片上传-分片任务记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-upload
        class="upload-demo"
        drag
        action="/"
        multiple
        :http-request="handleHttpRequest"
        :on-remove="handleRemoveFile">
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { taskInfo, initTask, preSignUrl, merge } from "@/api/system/task";
import md5 from "@/api/system/md5";
import axios from 'axios';
import Queue from 'promise-queue-plus';


export default {
  name: "file",
  data() {
    return {
      fileUploadChunkQueue:{},
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 分片上传-分片任务记录表格数据
      taskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uploadId: null,
        fileIdentifier: null,
        fileName: null,
        bucketName: null,
        objectKey: null,
        totalSize: null,
        chunkSize: null,
        chunkNum: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        uploadId: [
          { required: true, message: "分片上传的uploadId不能为空", trigger: "blur" }
        ],
        fileIdentifier: [
          { required: true, message: "文件唯一标识不能为空", trigger: "blur" }
        ],
        fileName: [
          { required: true, message: "文件名不能为空", trigger: "blur" }
        ],
        bucketName: [
          { required: true, message: "所属桶名不能为空", trigger: "blur" }
        ],
        objectKey: [
          { required: true, message: "文件的key不能为空", trigger: "blur" }
        ],
        totalSize: [
          { required: true, message: "文件大小不能为空", trigger: "blur" }
        ],
        chunkSize: [
          { required: true, message: "每个分片大小不能为空", trigger: "blur" }
        ],
        chunkNum: [
          { required: true, message: "分片数量不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询分片上传-分片任务记录列表 */
    getList() {
      this.loading = false;
      /*this.loading = true;*/
      /*listFile(this.queryParams).then(response => {
        this.taskList = response.rows;
        this.total = response.total;
        this.loading = false;
      });*/
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        uploadId: null,
        fileIdentifier: null,
        fileName: null,
        bucketName: null,
        objectKey: null,
        totalSize: null,
        chunkSize: null,
        chunkNum: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加分片上传-分片任务记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      updateFile(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改分片上传-分片任务记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
    },

    /** 自定义的上传方法 **/
    async handleHttpRequest(options){
      const file = options.file
      const task = await this.getTaskInfo(file)
      if (task) {
        const { finished, path, taskRecord } = task
        const { fileIdentifier: identifier } = taskRecord
        if (finished) {
          return path
        } else {
          /** TODO  处理上传的逻辑 **/

          const errorList = await this.handleUpload(file, taskRecord, options)
          if (errorList.length > 0) {

            this.$modal.msgSuccess("部分分片上次失败，请尝试重新上传文件");
            return;
          }
          const { code, data, msg } = await merge(identifier)
          if (code === 200) {
            return path;
          } else {
            this.$modal.msgSuccess("文件上传错误");
          }
        }
      } else {

        this.$modal.msgSuccess("文件上传错误");

      }
    },
    /**
     * 获取一个上传任务，没有则初始化一个
     */
    async getTaskInfo(file) {
      let task;
      // 获取文件分块
      const identifier = await md5(file)
      console.log("identifier =======>>>>", identifier);
      const { code, data, msg } = await taskInfo(identifier);
      if (code === 200) {
        task = data
        if (!task) {
          const initTaskData = {
            identifier,
            fileName: file.name,
            totalSize: file.size,
            chunkSize: 5 * 1024 * 1024
          }
          const { code, data, msg } = await initTask(initTaskData)
          if (code === 200) {
            task = data
          } else {
            this.$modal.msgSuccess("文件上传错误");
          }
        }
      } else {
        this.$modal.msgSuccess("文件上传错误");
      }
      return task
    },
    /**
     * 上传逻辑处理，如果文件已经上传完成（完成分块合并操作），则不会进入到此方法中
     */
    handleUpload(file, taskRecord, options){
      let lastUploadedSize = 0; // 上次断点续传时上传的总大小
      let uploadedSize = 0 // 已上传的大小
      const totalSize = file.size || 0 // 文件总大小
      let startMs = new Date().getTime(); // 开始上传的时间
      const { exitPartList, chunkSize, chunkNum, fileIdentifier } = taskRecord
      console.log("exitPartList =======>>>>", exitPartList);
      console.log("chunkSize =======>>>>", chunkSize);
      console.log("chunkNum =======>>>>", chunkNum);
      console.log("fileIdentifier =======>>>>", fileIdentifier);
      console.log("taskRecord =======>>>>", taskRecord);

      // 获取从开始上传到现在的平均速度（byte/s）
      const getSpeed = () => {
        // 已上传的总大小 - 上次上传的总大小（断点续传）= 本次上传的总大小（byte）
        const intervalSize = uploadedSize - lastUploadedSize
        const nowMs = new Date().getTime()
        // 时间间隔（s）
        const intervalTime = (nowMs - startMs) / 1000
        return intervalSize / intervalTime
      }

      const uploadNext = async (partNumber) => {
        const start = Number(chunkSize) * (partNumber - 1)
        const end = start + Number(chunkSize)
        const blob = file.slice(start, end)
        /** TODO  出错位置 1 **/
        const { code, data, msg } = await preSignUrl({ identifier: fileIdentifier, partNumber: partNumber} )
        console.log("preSignUrl =======>>>>", code, data, msg);

        if (code === 200 && msg) {
          await axios.request({
            url: msg,
            method: 'PUT',
            data: blob,
            headers: {'Content-Type': 'application/octet-stream'}
          })
          return Promise.resolve({ partNumber: partNumber, uploadedSize: blob.size })
        }
        return Promise.reject(`分片${partNumber}， 获取上传地址失败`)
      }

      /**
       * 更新上传进度
       * @param increment 为已上传的进度增加的字节量
       */
      const updateProcess = (increment) => {
        increment = Number(increment)
        const { onProgress } = options
        let factor = 1000; // 每次增加1000 byte
        let from = 0;
        // 通过循环一点一点的增加进度
        while (from <= increment) {
          from += factor
          uploadedSize += factor
          const percent = Math.round(uploadedSize / totalSize * 100).toFixed(2);
          onProgress({percent: percent})
        }

        const speed = getSpeed();
        const remainingTime = speed !== 0 ? Math.ceil((totalSize - uploadedSize) / speed) + 's' : '未知'
        console.log('剩余大小：', (totalSize - uploadedSize) / 1024 / 1024, 'mb');
        console.log('当前速度：', (speed / 1024 / 1024).toFixed(2), 'mbps');
        console.log('预计完成：', remainingTime);
      }


      /*===================================*/
      return new Promise(resolve => {
        const failArr = [];

        // 我们创建了一个最大并发数为  5  的队列，每个任务最多重试  3  次，当任务被拒绝时将失败的任务添加到
        // failArr  数组中，当队列完成时将  failArr  数组作为结果传递给  resolve  函数。这些选项参数可以根据实际需求进行调整
        const queue = Queue(5, {
          "retry": 3,               //Number of retries
          "retryIsJump": false,     //retry now?  设置在任务重试之前是否跳过队列中的其他任务为  false 为不跳过
          "workReject": function(reason,queue){  //任务被拒绝时触发 reason 为拒绝原因  queue 为当前队列
            failArr.push(reason)
          },
          "queueEnd": function(queue){
            resolve(failArr);   //队列结束时触发 设置队列完成时的处理函数，将  failArr  数组作为结果传递给  resolve  函数。
          }
        })

        this.fileUploadChunkQueue[file.uid] = queue
        for (let partNumber = 1; partNumber <= chunkNum; partNumber++) {
          const exitPart = (exitPartList || []).find(exitPart => exitPart.partNumber === partNumber)
          if (exitPart) {
            // 分片已上传完成，累计到上传完成的总额中,同时记录一下上次断点上传的大小，用于计算上传速度
            lastUploadedSize += Number(exitPart.size)
            updateProcess(exitPart.size)
          } else {
            queue.push(() => uploadNext(partNumber).then(res => {
              // 单片文件上传完成再更新上传进度
              updateProcess(res.uploadedSize)
            }))
          }
        }
        if (queue.getLength() === 0) {
          // 所有分片都上传完，但未合并，直接return出去，进行合并操作
          resolve(failArr);
          return;
        }
        queue.start()
      })
      /*=================================*/



    },
    handleRemoveFile(uploadFile, uploadFiles){
      const queueObject = this.fileUploadChunkQueue[uploadFile.uid]
      if (queueObject) {
        queueObject.stop()
        this.fileUploadChunkQueue[uploadFile.uid] = undefined
      }
    }




  }
};
</script>
