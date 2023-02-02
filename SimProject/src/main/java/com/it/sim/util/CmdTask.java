package com.it.sim.util;

import java.io.*;

public class CmdTask implements Runnable {
    private String command;
    private String dirPath;

    public static void main(String[] args) {
        String command = "cmd.exe /c ffmpeg -i video.m4s -i audio.m4s -codec copy ";
        new CmdTask("videoPath", command).run();
    }

    public CmdTask(String dirPath, String command) {
        this.dirPath = dirPath;
        this.command = "cmd.exe /c " + command;
    }

    @Override
    public void run() {
        Process process;
        int exitVal = 0;
        try {
            process = Runtime.getRuntime().exec(command, null, new File(dirPath));
            // Runtime.exec()创建的子进程公用父进程的流，不同平台上，父进程的stream buffer可能被打满导致子进程阻塞，从而永远无法返回。
            //针对这种情况，我们只需要将子进程的stream重定向出来即可。
            new RedisCmdStreamThread(process.getInputStream(), "INFO").start();
            new RedisCmdStreamThread(process.getErrorStream(), "ERR").start();

            exitVal = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (exitVal != 0) {
            throw new RuntimeException("cmd任务执行失败");
        }
    }

    static class RedisCmdStreamThread extends Thread {
        InputStream is;
        String printType;

        RedisCmdStreamThread(InputStream is, String printType) {
            this.is = is;
            this.printType = printType;
        }

        public void run() {
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(printType + ">" + line);
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}