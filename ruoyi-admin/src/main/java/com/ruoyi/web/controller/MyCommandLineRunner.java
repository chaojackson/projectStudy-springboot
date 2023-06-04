/*
package com.ruoyi.web.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

*/
/**
 * @ClassName MyCommandLineRunner
 * @Description
 * @Author zyc
 * @Date 2023/5/30 16:20
 *//*

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private static boolean hasRun = false; // 用于判断是否已经执行过


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring Boot Application has started!");

        String m_strIp = "192.168.110.180";//    ip
        int m_nPort = 37777;//    端口
        String m_strUser = "admin";//   登录名
        String m_strPassword = "admin123";// 密码
        int nChannelID = 0;//   通道id 默认为0
        int lParam1 = 0;//       默认 0，当有左上或左下等操作时才会传值 （1-8）
        int lParam2 = 5;//      垂直/水平 移动速度 （1-8）
        NetSdkUtil.initLogin(m_strIp, m_nPort, m_strUser, m_strPassword, nChannelID, lParam1, lParam2);
        hasRun = true;
    }
}
*/
