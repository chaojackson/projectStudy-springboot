/*
package com.ruoyi.web.controller;

import com.netsdk.demo.module.LoginModule;
import com.netsdk.lib.NetSDKLib;
import com.netsdk.lib.ToolKits;
import com.sun.jna.Pointer;

*/
/**
 * @ClassName NetSdkUtil
 * @Description
 * @Author zyc
 * @Date 2023/5/30 14:31
 *//*

public class NetSdkUtil {

    // 初始化sdk
    public static NetSDKLib netsdk = NetSDKLib.NETSDK_INSTANCE;

    // 设备信息
    private static NetSDKLib.NET_DEVICEINFO_Ex m_stDeviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();

    // 登陆句柄
    private static NetSDKLib.LLong m_hLoginHandle = new NetSDKLib.LLong(0);

    // 网络断线处理
    private static DisConnect disConnect = new DisConnect();

    private static class HaveReConnect implements NetSDKLib.fHaveReConnect
    {
        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser)
        {
            System.out.printf("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);
        }
    }

    // 设备连接恢复，实现设备连接恢复接口
    private static HaveReConnect haveReConnect = new HaveReConnect();

    // 设备断线回调: 通过 CLIENT_Init 设置该回调函数，当设备出现断线时，SDK会调用该函数
    private static class DisConnect implements NetSDKLib.fDisConnect
    {
        public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser)
        {
            System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);
        }
    }


    public static boolean login(String m_strIp, int m_nPort, String m_strUser, String m_strPassword)
    {
        //IntByReference nError = new IntByReference(0);
        //入参
        NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY pstInParam = new NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY();
        pstInParam.nPort = m_nPort;
        pstInParam.szIP = m_strIp.getBytes();
        pstInParam.szPassword = m_strPassword.getBytes();
        pstInParam.szUserName = m_strUser.getBytes();
        //出参
        NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY pstOutParam = new NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY();
        pstOutParam.stuDeviceInfo = m_stDeviceInfo;
        m_hLoginHandle = netsdk.CLIENT_LoginWithHighLevelSecurity(pstInParam, pstOutParam);
        System.out.println(netsdk.getClass().toString());
        if (m_hLoginHandle.longValue() == 0)
        {
            System.out.println("登录失败！\n"+ m_strIp+m_nPort+ ToolKits.getErrorCodePrint());
        } else
        {
            System.out.println("登录成功： [ " + m_strIp + " ]");
        }

        return m_hLoginHandle.longValue() == 0 ? false : true;
    }

    // 向上
    private static boolean startUpControl(int nChannelID, int lParam1, int lParam2)
    {
        if (m_hLoginHandle.longValue() != 0)
        {
            return netsdk.CLIENT_DHPTZControlEx(m_hLoginHandle, nChannelID,
                    NetSDKLib.NET_PTZ_ControlType.NET_PTZ_UP_CONTROL,
                    lParam1, lParam2, 0, 0);
        } else
        {
            System.out.println("登录句柄不存在！");
            return false;
        }
    }

    private static boolean stopUpControl(int nChannelID)
    {
        return netsdk.CLIENT_DHPTZControlEx(m_hLoginHandle, nChannelID,
                NetSDKLib.NET_PTZ_ControlType.NET_PTZ_UP_CONTROL,
                0, 0, 0, 1);
    }

    */
/**
     * 退出登录
     *//*

    private static void logout()
    {
        if (m_hLoginHandle.longValue() == 0)
        {
            return;
        }

        boolean bRet = netsdk.CLIENT_Logout(m_hLoginHandle);
        if (bRet)
        {
            m_hLoginHandle.setValue(0);
        }

    }

    public static void initLogin(String m_strIp, int m_nPort, String m_strUser, String m_strPassword, int nChannelID, int lParam1, int lParam2){
        // 初始化
        LoginModule.init(disConnect, haveReConnect);
        // 若未登录，先登录。
        if (m_hLoginHandle.longValue() == 0)
        {
            login(m_strIp, m_nPort, m_strUser, m_strPassword);
        }
    }


    public static boolean upControlPtz(String m_strIp, int m_nPort, String m_strUser, String m_strPassword, int nChannelID, int lParam1, int lParam2)
    {

        boolean result;

        // 初始化
        LoginModule.init(disConnect, haveReConnect);
        // 若未登录，先登录。
        if (m_hLoginHandle.longValue() == 0)
        {
            login(m_strIp, m_nPort, m_strUser, m_strPassword);
        }
        // 开始向上移动，若超过角度则会变为左右移动
        if (m_hLoginHandle.longValue() != 0)
        {
            result = startUpControl(nChannelID, lParam1, lParam2);
        }
        System.out.println("操作完成");
        // 停止移动
        result = stopUpControl(nChannelID);
        // 退出
        logout();
        System.out.println("退出登录...");
        // 释放资源
        LoginModule.cleanup();

        return result;
    }
}
*/
