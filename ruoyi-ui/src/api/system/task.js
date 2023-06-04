import request from '@/utils/request'

import axiosExtra from 'axios-extra'


/**
 * 根据文件的md5获取未上传完的任务
 * @param identifier 文件md5
 * @returns {Promise<AxiosResponse<any>>}
 */
export function taskInfo(identifier) {
  return request({
    url: '/system/file/'+identifier,
    method: 'get',
  })
}

/**
 * 初始化一个分片上传任务
 * @param identifier 文件md5
 * @param fileName 文件名称
 * @param totalSize 文件大小
 * @param chunkSize 分块大小
 * @returns {Promise<AxiosResponse<any>>}
 */
export function initTask(data) {
  return request({
    url: '/system/file',
    method: 'post',
    data: data
  })
}


/**
 * 获取预签名分片上传地址
 * @param identifier 文件md5
 * @param partNumber 分片编号
 * @returns {Promise<AxiosResponse<any>>}
 */
export function preSignUrl(data) {
  return request({
    url: '/system/file/getIdentifierUrl',
    method: 'post',
    data: data
  })
}

// 修改用户
export function merge(identifier) {
  return request({
    url: '/system/file/merge/'+identifier,
    method: 'post'
  })
}
