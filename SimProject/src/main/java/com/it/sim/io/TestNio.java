package com.it.sim.io;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @author zero DateTime 2018年5月30日 上午10:37:42
 * <pre>
 * Files:
 *      Files.readAllLines          List<String>    一次性读出
 *      Files.newBufferedReader     BufferedReader  可以遍历, 一行行读
 *      Files.lines                 Stream          可以遍历, 一行行读
 * Paths:
 *      Paths.get
 * </pre>
 */
public class TestNio {

    @Test
    public void testPaths() {
        Path path = Paths.get("D:", "app", "bin", "a.log");
        System.out.println(path.getNameCount());
        for (Path path1 : path) {
            System.out.println("Current: " + path1);
        }
        // true
        System.out.println(path.startsWith(path.getRoot()));
        System.out.println(path.startsWith("D:/app"));
        System.out.println(path.endsWith("a.log"));
        // false
        System.out.println(path.endsWith(".mp4"));
        System.out.println(path.startsWith("app"));

        // 所以get(..)就是获取其上一级路径
        // Path path = Paths.get("").toAbsolutePath().normalize();
        System.out.println(path);
        System.out.println(Paths.get("api/src/main", "..").toAbsolutePath().normalize());
        //===============
        Path base = Paths.get("D:", "app");
        Path fullPath = Paths.get("D:", "app", "a.log");
        // relative是从fullPath中将base部分截取掉
        System.out.println(base.relativize(fullPath));
        // 如果参数不是从根路径开始,那么base会完全拼接参数形成一个全新的路径
        System.out.println(base.resolve(Paths.get("app", "123")));
        // PS:如果base和fullPath从根路径下是重合的了,那么只会添加不重合的部分
        System.out.println(base.resolve(fullPath));
    }

    @Test
    public void testFiles() throws IOException {
        // Files.write(Path, byte[], OpenOption...)
        // Files.exists();
        // Files.copy(Path source, Path target, CopyOption...)
        // Files.createSymbolicLink();
        // Files.createTempFile();
        // Files.createTempDirectory();
        // Files.delete();
        // Files.walk();
        // Files.walkFileTree();
        // Files.find();
        // Files.lines();
        // Files.getAttribute();
    }

    @Test
    public void testReadWrite() throws IOException {

        String newTxt = "abc";
        String oPath = "out.txt"; // 项目目录下; 相对路径
        Path path = Paths.get(oPath);
        OpenOption[] openOptions = {StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};
        try (BufferedWriter bfw = Files.newBufferedWriter(path, openOptions)) {
            bfw.write(newTxt);
        }
        try (BufferedReader bfr = Files.newBufferedReader(path)) {
            bfr.lines().forEach(System.out::println);
        }
    }

    @Test
    public void testFileProp() throws IOException {
        // 返回以相对地址为基础的路径，不判断文件是否存在
        Path path = Paths.get("pom.xml").toAbsolutePath();
        System.out.println(path);
        System.out.println("文件是否存在: " + Files.exists(path));
        System.out.println("是否是目录: " + Files.isDirectory(path));
        System.out.println("是否是可执行文件: " + Files.isExecutable(path));
        System.out.println("是否可读: " + Files.isReadable(path));
        System.out.println("判断是否是一个文件: " + Files.isRegularFile(path));
        System.out.println("是否可写: " + Files.isWritable(path));
        System.out.println("文件是否不存在: " + Files.notExists(path));
        System.out.println("文件是否隐藏: " + Files.isHidden(path));
        System.out.println("文件大小: " + Files.size(path));
        System.out.println("文件存储在SSD还是HDD: " + Files.getFileStore(path));
        System.out.println("文件修改时间：" + Files.getLastModifiedTime(path));
        System.out.println("文件拥有者： " + Files.getOwner(path));
        System.out.println("文件类型: " + Files.probeContentType(path));

        System.out.println(System.getProperty("os.name"));
        FileSystem fileSystem = FileSystems.getDefault();
        // 获取逻辑磁盘信息
        for (FileStore fileStore : fileSystem.getFileStores()) {
            System.out.println("File Store :" + fileStore);
        }
        // 获取根目录
        for (Path path1 : fileSystem.getRootDirectories()) {
            System.out.println("Root Directory :" + path1);
        }
        // 获取文件路径的分隔符
        System.out.println(fileSystem.getSeparator());
    }

    @Test
    public void test_walk() throws IOException {
        Path test = Paths.get("test");
        // Creating a *directory*, not a file:
        Files.createDirectory(test.resolve("dir.tmp"));

        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");
        try (Stream<Path> paths = Files.walk(test)) {    // Only look for files
            paths.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .filter(matcher::matches)
                    .forEach(System.out::println);
        }

    }

    @Test
    public void test_walkFileTree() throws IOException {
        Path path = Paths.get("D:\\jdk1.8");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.getFileName().toString().contains(".jar")) {
                    System.out.println(file);
                }
                // Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attributes) {
                System.out.println(path);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path path, IOException exc) {
                System.out.println(path);
                System.out.println(exc.getMessage());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path path, IOException exc) {
                System.out.println(path);
                // Files.delete(path);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    public void test_watchDir() {
        Path dir = Paths.get("test");
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent<?> evt : key.pollEvents()) {
                        System.out.println("evt.context(): " + evt.context() +
                                "\nevt.count(): " + evt.count() +
                                "\nevt.kind(): " + evt.kind());
                        System.exit(0);
                    }
                } catch (InterruptedException ignored) {
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
