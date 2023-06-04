/*
package com.ruoyi.web.controller;

import com.netsdk.demo.module.LoginModule;
import com.netsdk.lib.NetSDKLib;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



@Component
public class InitSdkManager {


    private static final Logger log = LoggerFactory.getLogger(InitSdkManager.class);
    // 网络断线处理
    private static DisConnectCallBack disConnect = new DisConnectCallBack();

    // 设备连接恢复，实现设备连接恢复接口
    private static HaveReConnectCallBack haveReConnect = new HaveReConnectCallBack();

    private static String ip = "192.168.110.180";
    private static int port = 37777;
    private static String username = "admin";
    private static String password = "admin123";

    @PostConstruct
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

        // 订阅实时上传智能分析数据
       RealLoadPicTest.realLoadPic();

    }





    private static class DisConnectCallBack implements NetSDKLib.fDisConnect {

        private DisConnectCallBack() {
        }

        private static class CallBackHolder {
            private static DisConnectCallBack instance = new DisConnectCallBack();
        }

        public static DisConnectCallBack getInstance() {
            return CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong lLoginID, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);
        }
    }



    private static class HaveReConnectCallBack implements NetSDKLib.fHaveReConnect {
        private HaveReConnectCallBack() {
        }

        private static class CallBackHolder {
            private static HaveReConnectCallBack instance = new HaveReConnectCallBack();
        }

        public static HaveReConnectCallBack getInstance() {
            return CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);

        }
    }
}
*/
