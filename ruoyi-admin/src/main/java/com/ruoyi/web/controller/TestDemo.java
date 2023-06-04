package com.ruoyi.web.controller;



/**
 * @ClassName TestDemo
 * @Description
 * @Author zyc
 * @Date 2023/5/31 14:04
 */
public class TestDemo {
   /* private static final Logger log = LoggerFactory.getLogger(TestDemo.class);

    private static NetSDKLib.LLong m_hLoginHandle = new NetSDKLib.LLong(0);

    // 网络断线处理
    private static TestDemo.DisConnectCallBack disConnect = new TestDemo.DisConnectCallBack();

    // 设备连接恢复，实现设备连接恢复接口
    private static TestDemo.HaveReConnectCallBack haveReConnect = new TestDemo.HaveReConnectCallBack();

    private static String ip = "192.168.110.180";
    private static int port = 37777;
    private static String username = "admin";
    private static String password = "admin123";

    private static NetSDKLib.NET_DEVICEINFO_Ex m_stDeviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();


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
    }


    *//**
     * 设备断线回调*//*


    private static class DisConnectCallBack implements NetSDKLib.fDisConnect {

        private DisConnectCallBack() {
        }

        private static class CallBackHolder {
            private static TestDemo.DisConnectCallBack instance = new TestDemo.DisConnectCallBack();
        }

        public static TestDemo.DisConnectCallBack getInstance() {
            return TestDemo.DisConnectCallBack.CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong lLoginID, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);
        }
    }

    *//**
     * 设备重连回调*//*


    private static class HaveReConnectCallBack implements NetSDKLib.fHaveReConnect {
        private HaveReConnectCallBack() {
        }

        private static class CallBackHolder {
            private static TestDemo.HaveReConnectCallBack instance = new TestDemo.HaveReConnectCallBack();
        }

        public static TestDemo.HaveReConnectCallBack getInstance() {
            return TestDemo.HaveReConnectCallBack.CallBackHolder.instance;
        }

        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
            System.out.printf("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);

        }
    }*/
}
