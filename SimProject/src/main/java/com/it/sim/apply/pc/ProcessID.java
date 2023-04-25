package com.it.sim.apply.pc;

import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

import java.util.HashSet;

public class ProcessID {

    public static void main(String[] args) throws Exception {
        // 获取监控主机
        MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
        // 取得所有在活动的虚拟机集合
        HashSet<Integer> hashSet = new HashSet<>(local.activeVms());
        // 遍历集合，输出PID和进程名
        for (Integer process : hashSet) {
            MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
            // 获取类名
            String processName = MonitoredVmUtil.mainClass(vm, true);
            System.out.println(process + " ------> " + processName);
        }
    }
}