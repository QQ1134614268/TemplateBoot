package com.it.sim.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdUtil {
    public static void main(String[] args) {
        // String or = "ipconfig";
        String or = "netstat -ano";
        // String or = "netstat -ano|findstr ";
        String ret = execCMDCommand(or, "GBK");
        System.out.println(ret);
    }

    /**
     * 执行一个cmd命令
     *
     * @param cmdCommand  cmd命令
     * @param charsetName
     * @return 命令执行结果字符串，如出现异常返回null
     */
    public static String execCMDCommand(String cmdCommand, String charsetName) {
        StringBuilder stringBuilder = new StringBuilder();
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmdCommand);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), charsetName))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                return stringBuilder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行bat文件，
     *
     * @param file          bat文件路径
     * @param isCloseWindow 执行完毕后是否关闭cmd窗口
     * @return bat文件输出log
     */
    public static String execBatFile(String file, boolean isCloseWindow) {
        String cmdCommand;
        if (isCloseWindow) {
            cmdCommand = "cmd.exe /c " + file;
        } else {
            cmdCommand = "cmd.exe /k " + file;
        }
        return execCMDCommand(cmdCommand, "GBK");
    }

    /**
     * 执行bat文件,新开窗口
     *
     * @param file          bat文件路径
     * @param isCloseWindow 执行完毕后是否关闭cmd窗口
     * @return bat文件输出log
     */
    public static String execBatFileWithNewWindow(String file, boolean isCloseWindow) {
        String cmdCommand;
        if (isCloseWindow) {
            cmdCommand = "cmd.exe /c start" + file;
        } else {
            cmdCommand = "cmd.exe /k start" + file;
        }
        return execCMDCommand(cmdCommand, "GBK");
    }
}