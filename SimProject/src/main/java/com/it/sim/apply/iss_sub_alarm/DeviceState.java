package com.it.sim.apply.iss_sub_alarm;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2023-02-24 18:04
 */
@Data
@NoArgsConstructor
public class DeviceState {
    String ip;
    String username;
    String password;

    String url;

    boolean isCanLogin;
    boolean isLogin;
    boolean isSub;
    int sunTryCount;
    int loginCount;
    int pullCount;

    String deviceCode;

}
