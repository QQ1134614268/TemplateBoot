package com.it.sim.apply.iss_sub_alarm;

import com.it.sim.thread.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @date 2023-02-24 18:04
 */
@Slf4j
public class EnvTest {
    // todo 管理(线程异常, 手动启动, 重启) , 线程池进行定时任务
    CopyOnWriteArrayList<DeviceState> deviceTable = new CopyOnWriteArrayList<>();

    public void getDevices() {
        List<DeviceState> newDevicesList = new ArrayList<>();
        newDevicesList.add(new DeviceState());
        newDevicesList.add(new DeviceState());

        // 迁移数据, 重置状态
        for (DeviceState deviceState : newDevicesList) {
            Optional<DeviceState> op = deviceTable.stream()
                    .filter(vo -> Objects.equals(vo.getIp(), deviceState.getIp()))
                    .findFirst();
            op.ifPresent(state -> deviceState.setUrl(state.getUrl()));
        }
        deviceTable.clear();
        deviceTable.addAll(deviceTable);
    }

    public void task() {
        // 定时任务, 获取设备信息
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduledExecutor.scheduleAtFixedRate(this::getDevices, 10 * 60 * 1000, 10 * 60 * 1000, TimeUnit.SECONDS);

        // 定时任务, 拉设备信息
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(16);
        Runnable runnable = () -> {
            for (DeviceState o : deviceTable) {
                // 登陆 订阅
                if (checkAndLogin(o) && subEvent(o)) {
                    // 定时拉取
                    pullMeg(o);
                }
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);
    }

    // 自重启函数
    @Test
    public void selfStart() {
        Thread thread = new Thread(this::task);
        thread.setUncaughtExceptionHandler((thread1, throwable) -> {
            log.error("任务异常, 异常信息", throwable);
            ThreadUtils.sleep(5);
            selfStart();
        });
        thread.start();
    }


    /**
     * 失败策略: 检查失败次数,最多3次
     */
    public boolean checkAndLogin(DeviceState deviceState) {
        // 检查登陆
        if (Onvif.instance.isLogin()) {
            return true;
        }
        if (deviceState.loginCount > 3) {
            return false;
        }
        boolean isSuccess = Onvif.instance.login();
        if (deviceState.loginCount > 3) {
            return false;
        }
        // 策略一
        if (!isSuccess) {
            deviceState.loginCount += 1;
        }
        return isSuccess;
    }

    /**
     * 失败策略: 检查失败次数,最多3次; 立即重试,最多三次,每次多休眠一分钟时间
     */
    public boolean checkAndLoginV2(DeviceState deviceState) {
        // 检查登陆
        if (Onvif.instance.isLogin()) {
            return true;
        }
        if (deviceState.loginCount != 0) {
            ThreadUtils.sleep(deviceState.loginCount * 60);
        }
        if (deviceState.loginCount > 3) {
            return false;
        }
        boolean isSuccess = Onvif.instance.login();
        // 策略二
        if (!isSuccess) {
            deviceState.loginCount += 1;
            return checkAndLoginV2(deviceState);
        }
        deviceState.loginCount = 0;
        return true;
    }


    public boolean subEvent(DeviceState deviceState) {
        if (deviceState.sunTryCount > 3) {
            return false;
        }
        boolean isSuccess = Onvif.instance.subEvent();

        if (!isSuccess) {
            deviceState.loginCount += 1;
        }
        return isSuccess;
    }

    public void pullMeg(DeviceState deviceState) {
        if (deviceState.pullCount > 3) {
            return;
        }
        boolean isSuccess = Onvif.instance.pullMsg();

        if (!isSuccess) {
            deviceState.loginCount += 1;
        }
    }


    public void pullMegV2(DeviceState o) {
        if (checkAndLogin(o) && subEvent(o)) {
            // 定时拉取
            pullMeg(o);
        }
    }
}
