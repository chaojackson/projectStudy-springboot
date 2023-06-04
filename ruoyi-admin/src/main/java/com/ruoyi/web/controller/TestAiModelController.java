/*
package com.ruoyi.web.controller;

import com.netsdk.demo.module.AutoRegisterModule;
import com.netsdk.demo.module.LoginModule;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.Threads;
import com.sun.jna.Callback;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @ClassName TestAiModelController
 * @Description
 * @Author zyc
 * @Date 2023/5/29 14:06
 *//*

@RestController
@RequestMapping("/testAiModel")

public class TestAiModelController {
    private static final Logger log = LoggerFactory.getLogger(TestAiModelController.class);
    private static NetSDKLib.LLong m_hLoginHandle = new NetSDKLib.LLong(0);

    // 网络断线处理
    private static TestAiModelController.DisConnectCallBack disConnect = new TestAiModelController.DisConnectCallBack();

    // 设备连接恢复，实现设备连接恢复接口
    private static TestAiModelController.HaveReConnectCallBack haveReConnect = new TestAiModelController.HaveReConnectCallBack();

    private static String ip = "192.168.110.180";
    private static int port = 37777;
    private static String username = "admin";
    private static String password = "admin123";

    private static NetSDKLib.NET_DEVICEINFO_Ex m_stDeviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();





  */
/*  @PostConstruct
    public void startServer() {
        // 先初始化sdk，再开启服务的监听
        if (!LoginModule.init(disConnect, haveReConnect)) {
            log.info("初始化DaHua SDK失败");
            return;
        }
        log.info("初始化DaHua SDK成功");

        // 先登录设备
        if (!LoginModule.login(ip, port, username, password)) {
            log.info("登录DaHua IVD机器失败");
            return;
        }
        log.info("登录DaHua IVD机器成功");
    }*//*



    @RequestMapping("/getDVRIPConfig")
    public void getDVRIPConfig(){

*/
/*

        CaptureReceiveCB captureReceiveCB = new CaptureReceiveCB(ip, "图片11");

        String key = ip + LoginModule.m_hLoginHandle.longValue();
        String filepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/static/" + filename;
*//*




    }








    */
/**
     * 设备断线回调*//*



    private static class DisConnectCallBack implements NetSDKLib.fDisConnect {

        private DisConnectCallBack() {
        }

        private static class CallBackHolder {
            private static TestAiModelController.DisConnectCallBack instance = new TestAiModelController.DisConnectCallBack();
        }

        public static TestAiModelController.DisConnectCallBack getInstance() {
            return TestAiModelController.DisConnectCallBack.CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong lLoginID, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);
        }
    }

    */
/**
     * 设备重连回调*//*



    private static class HaveReConnectCallBack implements NetSDKLib.fHaveReConnect {
        private HaveReConnectCallBack() {
        }

        private static class CallBackHolder {
            private static TestAiModelController.HaveReConnectCallBack instance = new TestAiModelController.HaveReConnectCallBack();
        }

        public static TestAiModelController.HaveReConnectCallBack getInstance() {
            return TestAiModelController.HaveReConnectCallBack.CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);

        }
    }



}
*/
