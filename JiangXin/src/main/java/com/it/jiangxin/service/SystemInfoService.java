package com.it.jiangxin.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.it.jiangxin.config.Conf.FMT_DATE_TIME;

@Service
public class SystemInfoService {

    /**
     * 设置CPU信息
     */
    public static CpuDto getCpu(SystemInfo systemInfo) throws InterruptedException {

        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long sys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + sys + idle + iowait + irq + softirq + steal;
        CpuDto cpuDto = new CpuDto();
        cpuDto.setCpuNum(processor.getPhysicalProcessorCount());
        cpuDto.setSys(sys);
        cpuDto.setUser(user);
        cpuDto.setWait(iowait);
        cpuDto.setTotal(totalCpu);
        return cpuDto;
    }


    public ServeInfoDTO getSystemInfo() throws InterruptedException {

        SystemInfo si = new SystemInfo();

        ServeInfoDTO dto = new ServeInfoDTO();
        dto.setSysInfoDTO(getSysInfo());
        dto.setCpuDto(getCpu(si));
        dto.setMemoryDTO(getMemoryDTO(si));
        dto.setSysFiles(getDisk(si));
        dto.setJvmMemoryDTO(getJvm());
        return dto;
    }

    /**
     * 设置服务器信息
     */
    private SysInfoDTO getSysInfo() {
        SysInfoDTO dto = new SysInfoDTO();
        Properties props = System.getProperties();
        dto.setComputerName(getHostName());
        dto.setComputerIp(getHostIp());
        dto.setOsName(props.getProperty("os.name"));
        dto.setOsArch(props.getProperty("os.arch"));
        dto.setUserDir(props.getProperty("user.dir"));
        return dto;
    }

    /**
     * 获取IP地址
     *
     * @return 本地IP地址
     */
    public static String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ignored) {
        }
        return "127.0.0.1";
    }

    /**
     * 获取主机名
     *
     * @return 本地主机名
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ignored) {
        }
        return "未知";
    }

    public JvmMemoryDTO getJvm() {

        Properties props = System.getProperties();
        JvmMemoryDTO jvm = new JvmMemoryDTO();
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        jvm.setMax(Runtime.getRuntime().maxMemory());
        jvm.setFree(Runtime.getRuntime().freeMemory());
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));
        return jvm;
    }

    private static MemoryDTO getMemoryDTO(SystemInfo si) {
        HardwareAbstractionLayer hal = si.getHardware();

        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        long usedMemory = totalMemory - availableMemory;
        return new MemoryDTO(totalMemory, usedMemory, availableMemory);
    }

    private static List<SysFile> getDisk(SystemInfo si) {
        // 获取磁盘信息
        OperatingSystem os = si.getOperatingSystem();
        // 根据 操作系统（OS） 获取 FileSystem
        FileSystem fileSystem = os.getFileSystem();
        // 根据 FileSystem 获取主机磁盘信息list集合
        List<OSFileStore> fileStores = fileSystem.getFileStores();
        List<SysFile> sysFiles = new ArrayList<>();
        for (OSFileStore fs : fileStores) {
            long free = fs.getUsableSpace();// 磁盘空闲容量
            long total = fs.getTotalSpace();// 磁盘总容量
            long used = total - free;// 磁盘已使用容量
            SysFile sysFile = new SysFile();
            sysFile.setDirName(fs.getMount());// 磁盘符号 C:\
            sysFile.setSysTypeName(fs.getType());// 磁盘类型 NTFS
            sysFile.setTypeName(fs.getName());// 磁盘名称 本地固定磁盘 (C:)
            sysFile.setTotal(String.valueOf(total));// 磁盘总容量
            sysFile.setFree(String.valueOf(free));// 磁盘空闲容量
            sysFile.setUsed(String.valueOf(used));// 磁盘已使用容量
            sysFile.setUsage(used * 1.0 / total);// 磁盘资源的使用率
            sysFiles.add(sysFile);
        }
        return sysFiles;
    }

    @Data
    public static class ServeInfoDTO {
        private SysInfoDTO sysInfoDTO;
        private CpuDto cpuDto;
        private MemoryDTO memoryDTO;
        private List<SysFile> sysFiles;
        private JvmMemoryDTO jvmMemoryDTO;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class MemoryDTO {
        /**
         * 内存总量
         */
        private double total;

        /**
         * 已用内存
         */
        private double used;

        /**
         * 剩余内存
         */
        private double free;
    }

    @Data
    public static class SysInfoDTO {
        /**
         * 服务器名称
         */
        private String computerName;

        /**
         * 服务器Ip
         */
        private String computerIp;

        /**
         * 项目路径
         */
        private String userDir;

        /**
         * 操作系统
         */
        private String osName;

        /**
         * 系统架构
         */
        private String osArch;

    }


    @Data
    public static class CpuDto {
        /**
         * 核心数
         */
        private int cpuNum;

        /**
         * CPU总的使用率
         */
        private double total;

        /**
         * CPU系统使用率
         */
        private double sys;

        /**
         * CPU用户使用率
         */
        private double user;

        /**
         * CPU当前等待率
         */
        private double wait;

        /**
         * CPU当前空闲率
         */
        private double free;
    }

    @Data
    static class SysFile {
        /**
         * 盘符路径
         */
        private String dirName;

        /**
         * 盘符类型
         */
        private String sysTypeName;

        /**
         * 文件类型
         */
        private String typeName;

        /**
         * 总大小
         */
        private String total;

        /**
         * 剩余大小
         */
        private String free;

        /**
         * 已经使用量
         */
        private String used;

        /**
         * 资源的使用率
         */
        private double usage;
    }

    @Data
    public static class JvmMemoryDTO {
        /**
         * 当前JVM占用的内存总数(M)
         */
        private double total;

        /**
         * JVM最大可用内存总数(M)
         */
        private double max;

        /**
         * JVM空闲内存(M)
         */
        private double free;

        /**
         * JDK版本
         */
        private String version;

        /**
         * JDK路径
         */
        private String home;

        /**
         * JDK启动时间
         */
        private String startTime = LocalDateTime.now().format(FMT_DATE_TIME);

        /**
         * 获取JDK名称
         */
        private String name = ManagementFactory.getRuntimeMXBean().getVmName();

        /**
         * 运行参数
         */
        private String inputArgs = ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
    }

}