package com.it.sim.test.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class TestJna {
    public interface CLibrary extends Library {
        // 加载路径 1.绝对路径; 2.jar包下 win32-x86-64 linux-x86-64; 3. 系统Path路径?
        // 没有前后缀会自动添加 (win下: .dll; linux: 前缀 lib 后缀 .so)
        CLibrary INSTANCE = Native.load(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);

        void printf(String format, Object... args);
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("%s, %s\n", "Hello", "world");
    }
}