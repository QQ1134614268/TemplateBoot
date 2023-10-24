package com.it.sim.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * todo read
 *
 * @date 2022-09-30 11:46
 */
@Slf4j
public class TestReadFile {

    // 当前类的ClassLoader的getResourceAsStream方法，入参路径是从classpath开始。
    // 而类实例的入参是相对于包路径，但路径开始使用'/'符号， 也是绝对路径。
    @Test
    public void test() throws IOException {
        Class<TestReadFile> clazz = TestReadFile.class;
        InputStream inputStream = clazz.getResourceAsStream("/a.txt");
        String data = readFromInputStream(inputStream);
        System.out.println(data);
    }

    @Test
    public void test0() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("a.txt");
        String data = readFromInputStream(inputStream);
        log.info(data);
    }

    // 3.2 使用commons-io库
    @Test
    public void useCommonIO() throws IOException {
        String expectedData = "Hello,World!";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("a.txt")).getFile());
        String data = FileUtils.readFileToString(file, "UTF-8");

        Assert.assertEquals(expectedData, data.trim());
    }

    @Test
    public void useCommonIO2() throws IOException {
        String expectedData = "Hello,World!";

        FileInputStream fis = new FileInputStream("src/test/resources/a.txt");
        String data = IOUtils.toString(fis, "UTF-8");

        Assert.assertEquals(expectedData, data.trim());
    }

    // 4.BufferedReader
    @Test
    public void bufferedReader() throws IOException {
        String expected_value = "Hello,World!";
        String file = "src/test/resources/a.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();

        Assert.assertEquals(expected_value, currentLine);
    }

    // 5.Java NIO
    // 5.1读取小文件
    @Test
    public void readSmallFile() throws IOException {
        String expected_value = "Hello,World!";

        Path path = Paths.get("src/test/resources/a.txt");

        String read = Files.readAllLines(path).get(0);
        Assert.assertEquals(expected_value, read);
    }

    // 5.2读取大文件
    @Test
    public void readLargeFile() throws IOException {
        String expected_value = "Hello,World!";

        Path path = Paths.get("src/test/resources/a.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            Assert.assertEquals(expected_value, line);
        }

    }

    // 5.2读取大文件
    @Test
    public void readLargeFile2() throws IOException {
        Path path = Paths.get("src/test/resources/a.txt");
        try (Stream<String> data = Files.lines(path)) {
            List<String> lines = data.collect(Collectors.toList());
            System.out.println(lines);
        }

    }

    // 6 Scanner
    @Test
    public void whenReadWithScanner_thenCorrect() throws IOException {
        String file = "src/test/resources/a.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");

        Assert.assertTrue(scanner.hasNext());
        Assert.assertEquals("Hello", scanner.next());
        Assert.assertEquals("World!", scanner.next());

        scanner.close();
    }

    // 7.StreamTokenizer
    @Test
    public void readWithTokenize() throws IOException {
        String file = "src/test/resources/aTokenizer.txt";
        FileReader reader = new FileReader(file);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        //  1
        tokenizer.nextToken();
        Assert.assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
        Assert.assertEquals("Hello", tokenizer.sval);

        //  2
        tokenizer.nextToken();
        Assert.assertEquals(StreamTokenizer.TT_NUMBER, tokenizer.ttype);
        Assert.assertEquals(1, tokenizer.nval, 0.0000001);

        //  3
        tokenizer.nextToken();
        Assert.assertEquals(StreamTokenizer.TT_EOF, tokenizer.ttype);
        reader.close();
    }

    // 8.DataInputStream
    @Test
    public void whenReadWithDataInputStream() throws IOException {
        String expectedValue = "Hello,World!";
        String file = "src/test/resources/a.txt";
        String result = null;
        try (DataInputStream reader = new DataInputStream(Files.newInputStream(Paths.get(file)))) {
            int nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                result = new String(bytes);
            }

            Assert.assertEquals(expectedValue, result);
        }

    }

    // 9.FileChannel
    @Test
    public void whenReadWithFileChannel() throws IOException {
        String expected_value = "Hello,World!";
        String file = "src/test/resources/a.txt";
        RandomAccessFile reader = new RandomAccessFile(file, "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();

        Assert.assertEquals(expected_value, new String(buff.array()));
        channel.close();
        reader.close();
    }

    // 10.读取utf-8编码的文件
    @Test
    public void whenReadUTFEncodedFile() throws IOException {
        String expected_value = "你好，世界！";
        String file = "src/test/resources/fileTestUtf8.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(file)), StandardCharsets.UTF_8));
        String currentLine = reader.readLine();
        reader.close();

        Assert.assertEquals(expected_value, currentLine);
    }

    // 11.从URL读取数据
    @Test
    public void readFromURL() throws IOException {
        URL urlObject = new URL("https://www.baidu.com");
        URLConnection urlConnection = urlObject.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String data = readFromInputStream(inputStream);
        System.out.println(data);
    }

    // 12.从jar包中读取文件
    @Test
    public void readFromJar() throws IOException {
        String expectedData = "Eclipse Public License";

        Class<?> clazz = Test.class;
        InputStream inputStream = clazz.getResourceAsStream("/LICENSE-junit.txt");
        String data = readFromInputStream(inputStream);
        MatcherAssert.assertThat(data, CoreMatchers.containsString(expectedData));
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
    @Test
    public void readResourceDirFile() throws IOException, URISyntaxException {
        String path = "a.txt";
        // String path = "/a.txt";
        URI uri = this.getClass().getClassLoader().getResource(path).toURI();
        List<String> lines = Files.readAllLines(Paths.get(uri));
        lines.forEach(System.out::println);
    }

    @Test
    public void test_3() throws IOException {
        // 获取 resources 文件流
        Resource classPathResource = new ClassPathResource("a.txt");
        InputStream inputStream = classPathResource.getInputStream();

        String outFilePath = (new File(".")).getCanonicalPath().concat(String.format("/tmp-file-%s", System.currentTimeMillis()));
        // 将 InputStream 复制输出到 指定文件上
        File file = new File(outFilePath);
        Files.copy(inputStream, file.toPath());
        // 关闭输入流
        inputStream.close();
        System.out.printf("文件是否存在: %s%n", file.exists());
    }


    @Test
    public void test6() {
        System.out.println(TestReadFile.class);
        System.out.println(TestReadFile.class.getPackage().getName());
        System.out.println(TestReadFile.class.getName());
        System.out.println(TestReadFile.class.getSimpleName());
        System.out.println(System.getProperty("user.dir")); // 项目目录

        // Class.getResource() : 如果以 "/" 开头，就在classpath根目录下找;
        //      如果不以 "/" 开头，就在调用getResource的字节码对象所在目录下找
        // ClassLoader.getResource() ??
        // Class.getClassLoader() ??
        // URL.getPath
        // this.getClass() 与 TestFilePath.class 相同
        // Thread.currentThread().getContextClassLoader()
        String className = TestReadFile.class.getSimpleName();
        System.out.println(TestReadFile.class.getResource(""));
        System.out.println(TestReadFile.class.getResource("."));
        System.out.println(TestReadFile.class.getResource("/"));
        System.out.println(TestReadFile.class.getResource(className));
        System.out.println(TestReadFile.class.getResource("/" + className)); // null

        System.out.println(TestReadFile.class.getClassLoader());
        System.out.println(TestReadFile.class.getClassLoader().getResource(""));
        System.out.println(TestReadFile.class.getClassLoader().getResource(className));
        System.out.println(TestReadFile.class.getClassLoader().getResource("/")); // null

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

    }
}
