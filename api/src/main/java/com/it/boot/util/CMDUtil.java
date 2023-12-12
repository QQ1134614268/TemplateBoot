package com.it.boot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 执行windows的cmd命令工具类
 */
public class CMDUtil {

    /**
     * 执行一个cmd命令
     *
     * @param cmdCommand cmd命令
     * @return 命令执行结果字符串，如出现异常返回null
     */
    public static String executeCMDCommand(String cmdCommand) {
        return getString(cmdCommand);
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
        return getString(cmdCommand);
    }

    private static String getString(String cmdCommand) {
        StringBuilder stringBuilder = new StringBuilder();
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmdCommand);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
        return getString(cmdCommand);
    }

    public static void main(String[] args) {
        //	Sun的doc里其实说明还有其他的用法：
        //
        //	exec(String[] cmdArray, String[] env, File dir)
        //
        //	Executes the specified command and arguments in a separate process with the specified environment and working directory.
        //	那个dir就是调用的程序的工作目录，这句其实还是很有用的。
        //
        //	eg1: 下调用程序
        //	Process proc =Runtime.getRuntime().exec("exeFile"); // windows
        //	Process proc =Runtime.getRuntime().exec("./exeFile"); // Linux

        //	eg2: 调用系统命令
        // 	Process proc =Runtime.getRuntime().exec({"cmd","/C","copy exe1 exe2"});// windows
        // 	Process proc =Runtime.getRuntime().exec({"/bin/sh","-c","ln -s exe1 exe2"}); // Linux

        //	eg3: 调用系统命令并弹出命令行窗口
        //	Process proc =Runtime.getRuntime().exec({"cmd","/C","start copy exe1 exe2"}); // windows
        //	Process proc =Runtime.getRuntime().exec({"/bin/sh","-c","xterm -e ln -s exe1 exe2"});  // Linux

        //	还有要设置调用程序的工作目录就要
        //	Process proc =Runtime.getRuntime().exec("exeFile",null, new File("workPath"));
        String cmd = "ping www.baidu.com";
        String result = CMDUtil.executeCMDCommand(cmd);
        System.out.println(result);
    }
}
