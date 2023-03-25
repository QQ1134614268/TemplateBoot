package com.it.sim.apply.iss_sub_alarm;

import java.util.List;

/**
 * @date 2023-02-24 18:04
 */
public class Env2 {
    // 管理

    List<DeviceState> deviceTable;


    private boolean checkLogin(DeviceState deviceState) {
        boolean loginResult = Onvif.instance.isLogin();
        if (loginResult) {
            return failCase2(deviceState);
        }
        return true;
    }

    private static boolean login(DeviceState deviceState) {
        return Onvif.instance.login();
    }

    // 失败策略1
    private void failCase(DeviceState deviceState) {
        deviceState.loginCount += 1;
    }

    // 失败策略2
    private boolean failCase2(DeviceState deviceState) {
        deviceState.loginCount += 1;
        return checkLogin(deviceState);
    }

    // 处理登陆结果 (差评, 主函数处理, 符合主函数逻辑, 处理结果, 异常作为分支处理)
    private boolean handelLoginResult(DeviceState deviceState, boolean loginResult) {
        if(!loginResult){
            failCase2(deviceState);
        }
        deviceState.loginCount += 1;
        return checkLogin(deviceState);
    }
}
