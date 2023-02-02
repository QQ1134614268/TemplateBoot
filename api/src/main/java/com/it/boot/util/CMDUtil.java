package com.it.boot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 执行windows的cmd命令工具类
 *
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
    public static String excuteBatFile(String file, boolean isCloseWindow) {
        String cmdCommand = null;
        if (isCloseWindow) {
            cmdCommand = "cmd.exe /c " + file;
        } else {
            cmdCommand = "cmd.exe /k " + file;
        }
        return getString(cmdCommand);
    }

    private static String getString(String cmdCommand) {
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmdCommand);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
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
    public static String excuteBatFileWithNewWindow(String file, boolean isCloseWindow) {
        String cmdCommand = null;
        if (isCloseWindow) {
            cmdCommand = "cmd.exe /c start" + file;
        } else {
            cmdCommand = "cmd.exe /k start" + file;
        }
        return getString(cmdCommand);
    }

    public static void main(String[] args) {
//		Process process = Runtime.getRuntime().exec("E:/Java/AAA/budgeting_center/web_rest/mvnPackage2.bat", null,
//				new File("E:/Java/AAA/budgeting_center/web_rest"));
        String cmd = "ping www.baidu.com";
        String result = CMDUtil.executeCMDCommand(cmd);
        System.out.println(result);
    }
}
//	Sun的doc里其实说明还有其他的用法：
//
//	exec(String[] cmdarray, String[] envp, File dir)
//
//	Executes the specified command and arguments in a separate process with the specified environment and working directory.
//	那个dir就是调用的程序的工作目录，这句其实还是很有用的。
//
//	Windows下调用程序
//
//	Process proc =Runtime.getRuntime().exec("exefile");
//	Linux下调用程序就要改成下面的格式
//
//	Process proc =Runtime.getRuntime().exec("./exefile");
//	Windows下调用系统命令
//
//	String [] cmd={"cmd","/C","copy exe1 exe2"}; 
//	Process proc =Runtime.getRuntime().exec(cmd);
//	Linux下调用系统命令就要改成下面的格式
//
//	String [] cmd={"/bin/sh","-c","ln -s exe1 exe2"}; 
//	Process proc =Runtime.getRuntime().exec(cmd);
//	Windows下调用系统命令并弹出命令行窗口
//
//	String [] cmd={"cmd","/C","start copy exe1 exe2"}; 
//	Process proc =Runtime.getRuntime().exec(cmd);

//	Linux下调用系统命令并弹出终端窗口就要改成下面的格式
//
//	String [] cmd={"/bin/sh","-c","xterm -e ln -s exe1 exe2"};
//	Process proc =Runtime.getRuntime().exec(cmd);
//	还有要设置调用程序的工作目录就要
//
//	Process proc =Runtime.getRuntime().exec("exeflie",null, new File("workpath"));
