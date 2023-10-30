<<<<<<<< HEAD:SimProject/src/main/java/com/it/sim/io/TestJava8Paths.java
package com.it.sim.io;
========
package com.it.sim.test.io;
>>>>>>>> e49c470e19e7ec0187968ffbdf3a56092728427c:SimProject/src/main/java/com/it/sim/test/io/TestNioPaths.java


import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zero DateTime 2018年5月30日 上午10:37:42
 */

public class TestNioPaths {
    @Test
    public void test1() {
        Path path = Paths.get("F:", "迅雷下载", "寄生虫", "寄生虫/Parasite.寄生虫.2019.中文字幕.BDrip.1080P-BR.mp4");
        //String path = "F:\迅雷下载\寄生虫\寄生虫\Parasite.寄生虫.2019.中文字幕.BDrip.1080P-BR.mp4"
        System.out.println(path.getNameCount());
        for (Path path1 : path) {
            System.out.println("Current: " + path1);
        }
        //true
        System.out.println(path.startsWith(path.getRoot()));
        System.out.println(path.startsWith("F:/迅雷下载"));
        System.out.println(path.endsWith("Parasite.寄生虫.2019.中文字幕.BDrip.1080P-BR.mp4"));
        //false
        System.out.println(path.endsWith(".mp4"));
        System.out.println(path.startsWith("迅雷下载"));

    }

    @Test
    public void test3() {
        //所以get(..)就是获取其上一级路径
        Path path = Paths.get("").toAbsolutePath().normalize();
        System.out.println(path);
        System.out.println(Paths.get("api/src/main", "..").toAbsolutePath().normalize());
        //===============
        Path base = Paths.get("F:", "迅雷下载");
        Path fullPath = Paths.get("F:", "迅雷下载", "寄生虫", "寄生虫", "Parasite.寄生虫.2019.中文字幕.BDrip.1080P-BR.mp4");
        //relative是从fullPath中将base部分截取掉
        System.out.println(base.relativize(fullPath));
        //如果参数不是从根路径开始,那么base会完全拼接参数形成一个全新的路径
        System.out.println(base.resolve(Paths.get("迅雷下载", "123")));
        //PS:如果base和fullPath从根路径下是重合的了,那么只会添加不重合的部分
        System.out.println(base.resolve(fullPath));
    }
}