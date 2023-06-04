/*
package com.ruoyi.web.controller;

import com.netsdk.demo.module.GateModule;
import com.netsdk.demo.module.LoginModule;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


public class RealLoadPicTest {
    private static final Logger log = LoggerFactory.getLogger(RealLoadPicTest.class);




    public static void realLoadPic() {
        if (LoginModule.m_hLoginHandle.longValue() != 0) {
            // 订阅实时上传智能分析数据
            NetSDKLib.LLong m_hAttachHandle = GateModule.realLoadPic(0, FAnalyzerDataCallBack.getInstance());
            if (m_hAttachHandle.longValue() != 0) {
                log.info("订阅实时上传智能分析数据成功");
                return;
            }
        }
        log.info("订阅实时上传智能分析数据失败");
    }

    public static class FAnalyzerDataCallBack implements NetSDKLib.fAnalyzerDataCallBack {

        private FAnalyzerDataCallBack() {
        }

        private static class CallBackHolder {
            private static FAnalyzerDataCallBack instance = new FAnalyzerDataCallBack();
        }

        public static FAnalyzerDataCallBack getInstance() {
            return CallBackHolder.instance;
        }

        */
/**
         *
         * @param lAnalyzerHandle  分析器句柄，用于标识一个分析器实例。
         * @param dwAlarmType   告警类型，表示当前告警的类型。
         * @param pAlarmInfo  告警信息，包含了当前告警的详细信息。 对应智能事件信息
         * @param pBuffer     告警图片数据，包含了当前告警的相关图片数据。
         * @param dwBufSize    告警图片数据大小，表示 pBuffer 缓冲区的大小。
         * @param dwUser          用户数据，可以是任意类型的用户数据。
         * @param nSequence    告警序号，表示当前告警的序号。表示上传的相同图片情况， 为0时表示是第一次出现，为2表示最后一次出现或仅出现一次，为1表示此次之后还有
         * @param reserved    保留参数，暂未使用。  表示当前回调数据的状态, 为0表示当前数据为实时数据，为1表示当前回调数据是离线数据，为2时表示离线数据传送结束
         * @return
         *//*

        @Override
        public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType, Pointer pAlarmInfo, Pointer pBuffer, int dwBufSize, Pointer dwUser, int nSequence, Pointer reserved) {

            if (lAnalyzerHandle.longValue() == 0 || pAlarmInfo == null) {
                return -1;
            }
            log.info("智能分析数据回调开始, 事件类型dwAlarmType: {}", dwAlarmType);
            switch (dwAlarmType) {
                // 人脸识别事件
                case NetSDKLib.EVENT_IVS_FACERECOGNITION: {
                    // DEV_EVENT_FACERECOGNITION_INFO 结构体比较大，new对象会比较耗时， ToolKits.GetPointerData内容拷贝是不耗时的。
                    //DEV_EVENT_FACEDETECT_INFO
                   */
/* NetSDKLib.DEV_EVENT_FACERECOGNITION_INFO msg = new NetSDKLib.DEV_EVENT_FACERECOGNITION_INFO();*//*

                    NetSDKLib.DEV_EVENT_FACEDETECT_INFO msg = new NetSDKLib.DEV_EVENT_FACEDETECT_INFO();
                    ToolKits.GetPointerData(pAlarmInfo, msg);
                    // 保存人脸对比信息
                    log.info("人脸对比信息: {}", msg);
                    break;
                }
                // 人体特征事件
                case NetSDKLib.EVENT_IVS_HUMANTRAIT: {
                    NetSDKLib.DEV_EVENT_HUMANTRAIT_INFO msg = new NetSDKLib.DEV_EVENT_HUMANTRAIT_INFO();
                    ToolKits.GetPointerData(pAlarmInfo, msg);
                    log.info("人体特征事件: {}", msg);
                    break;
                }
                default:
                    break;
            }
            NetSDKLib.MEDIAFILE_FACERECOGNITION_INFO picInfo = new NetSDKLib.MEDIAFILE_FACERECOGNITION_INFO();

            */
/**
             * ToolKits.GetPointerData(pBuffer, picInfo)  的作用是将  pBuffer  中的数据读取到  picInfo  中。
             * pBuffer  是一个指向缓冲区的指针，存储了图片数据，而  picInfo  是一个结构体，用于存储媒体文件中的人脸识别信息。
             * 通过调用  ToolKits.GetPointerData()  方法，可以将  pBuffer  中的数据读取到  picInfo  中，从而获取媒体文件中的人脸识别信息，
             * 例如人脸坐标、人脸 ID、人脸图片等等。
             *//*

            ToolKits.GetPointerData(pBuffer, picInfo);


            */
/** 抓拍图片 **//*

            if (pBuffer != null && dwBufSize > 0) {
                try {
                    byte[] buf = pBuffer.getByteArray(0, dwBufSize);
                    ByteArrayInputStream byteArrInput = new ByteArrayInputStream(buf);
                    BufferedImage bufferedImage = ImageIO.read(byteArrInput);
                    if (bufferedImage == null) {
                        log.info("图片解析失败");
                        return -1;
                    }
                    String path = "D:\\test\\" + System.currentTimeMillis() + ".jpg";
                    ImageIO.write(bufferedImage, "jpg", new File(path));
                } catch (IOException e) {
                    log.error("写文件失败:" + e.getMessage(), e);
                }

                log.info("智能分析图片；{}", picInfo);

                log.info("智能分析数据回调结束");

            }
            return 0;
        }
    }
}

*/
