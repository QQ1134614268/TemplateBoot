package com.it.sim.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date 2022-09-30 11:46 todo 阅读io nio socket uri url 整理
 * Nio:
 *      Files.readAllLines          List<String>    一次性读出
 *      Files.newBufferedReader     BufferedReader  可以遍历, 一行行读
 *      Files.lines                 Stream          可以遍历, 一行行读
 * JavaIO:
 *     InputStream:
 *         FileInputStream             从文件系统获取输入流（字节）
 *         FilterInputStream           包含一些其他输入流，用于基础数据转换或其他。只是简单重写了InputStream的所有方法，其子类会根据不同情况进一步重写，并提供其他字段和方法。
 *             BufferedInputStream     应用：断点续传。新功能，即缓冲输入并支持标记和重置功能。会在内部创建一个缓冲区数组，当读取或跳过流中的字节时，将根据需要从包含的输入流中重新填充内部缓冲区，每次填充多个字节。标记操作会记录输入流的一个点，重置操作会从包含的输入流中读取新字节之前重新读取最近标记的所有字节。
 *             DataInputStream         允许应用程序以独立于机器的方式从输入流读取原始Java数据类型。
 *             PushbackInputStream     为输入流添加新功能，即“推回”或“未读”一个字节的能力。在代码片段中读取特定字节分隔的无限数量字节的场景中非常有用;在读取终止字节后，代码片段可以“未读”，这样在输入流下一次读取时，会重新读取被推回的字节。如，由字符构成的字节可以使用运算符标识流终止，方法仅读取可以读取的，遇到运算符时，然后将运算符推回，存入数组中，下次重新读取。
 *         ObjectInputStream           反序列化之前使用ObjectOutputStream编写的原始数据和对象。用于恢复以前序列化的对象。其他应用，如套接字流在主机之间传递对象，或远程通信系统中对参数的封装和解析。
 *         PipedInputStream            管道输入流应与管道输出流连接，管道输入流提供写入管道输出流的（字节）数据。通常，一个线程从PipedInputStream对象读取数据，另一个线程将数据写入PipedOutputStream。不推荐单线程同时使用这两个对象，可能导致死锁。管道输入流包含一个缓冲区，在限制范围内将读操作和写操作分离。如果向连接的管道输出流提供（字节）数据的线程不再存活，则称管道断开。
 *         SequenceInputStream         表示其他输入流的逻辑连接。从输入流的有序集合开始，从第一个流开始读取，直到最后文件结尾，然后读取第二个流，以此类推，直到读取到包含的输入流文件结尾。
 *         ByteArrayInputStream        含一个内部缓冲区，该缓冲区包含可从流中读取的字节。读取方法提供内部计数器用于跟踪下一个字节。关闭是无效的，可以在流关闭后调用方法而不抛出异常IOException。
 *     OutputStream:
 *         FileOutputStream            文件输出流是将数据写入文件或文件描述的输出流。文件是否可用或是否可以创建取决于底层平台。一些平台中，一次只允许一个FileOutputStream（或其他文件写入对象）打开文件进行写入。这种情况下，如果涉及的文件已经打开，此类的构造函数会失败。用于原始字节流写入，如图像数据，对于字符流写入，可使用FileWriter。
 *         FilterOutputStream          是过滤输出流类的父类。
 *             BufferedOutputStream    实现缓存输出流。通过设置缓存输出流，应用程序可以向底层输出流写入字节，而不用依赖底层系统。
 *             DataOutputStream        数据输出流可以方便地将原始Java数据类型写入输出流。
 *             PrintStream             为输出流添加了新的功能，可以方便地打印各种数值。并且提供了其他两个功能，不像其他的输出流，PrintStream不会抛出异常IOException。异常会在内部设置一个标识，可以通过checkError方法进行测试;可以自动刷新，意味着，当写入字节数组、调用println方法或者写入换行符后会自动调用flush方法。
 *         ObjectOutputStream          将Java对象的原始数据类型和图写入OutputStream，可以使用ObjectInputStream读取（重建）对象;对象的持久化可以通过流文件实现，如果流是网络套接字，可以在另一个主机或另一个进程中重建对象。只有支持java.io.Serializable接口的对象才能写入流。每个可序列化的对象被编码，包括类名和类的签名、对象的属性值、数组值以及初始化对象时引用其他对象的闭包。
 *         PipedOutputStream           管道输出流通过连接到管道输入流建立通信管道。管道输出流是管道的发送端，一般，一个线程将数据写入PipedOutputStream对象，不建议使用单个线程同时使用者两个对象（PipedInputStream和PipedOutputStream），可能导致死锁。
 *         ByteArrayOutputStream       实现输出流，其中数据被写入数组。
 *     Reader:
 *         BufferedReader              从字符输入读取文本，缓冲字符，以便有效读取字符、数组和行数据。可以指定缓冲区大小，也可以使用默认大小，对于大多数场景，默认大小（尺寸）足够使用。通常，Reader发出的每个读取请求都会有对应的底层字符或字节流进行读取，因此，建议使用BufferedReader包装高消耗的read()，如FileReader和InputStreamReader。
 *         InputStreamReader           字节流转换为字符流的桥梁：通过指定的字符集将字节转换为字符。字符集可以通过名称指定，也可以显式指定或者使用平台可使用的默认字符集。每次调用InputStreamReader的read方法可能从底层字节输入流中读取一个或多个字节，为了实现字节到字符的高效转换，可以从底层流中提前读取更多的字节。为获取最高的读取转换效率，可使用BufferedReader包装InputStreamReader，如：
 *         FileReader                  读取字符文件的类。该类的构造函数假定默认字符编码和默认字节缓冲尺寸是合适的。如要指定字符编码和缓存大小，可在FileInputStream中构造InputStreamReader。FileReader用于读取字符流，对于原始字节流，可使用FileInputStream。
 *         StringReader                读取源为字符串的字符流。
 *         PipedReader                 管道字符输入流。
 *         FilterReader                读取过滤字符流的抽象类。提供将所有请求传递到包含流的默认方法，子类会覆盖这些方法，可能提供其他的方法和字段。
 *         PushbackReader              字符流读取器，允许字符推回到字符流中。
 *     Writer: 子类必须实现的方法为write(char[], int, int)、flush()和close()。大多数子类可以覆盖一些方法，以提高性能或提供更多功能。
 *         BufferedWriter              将文本写入字符输入流，缓冲字符可以高效写入单个字符、数组和字符串。
 *         CharArrayWriter             CharArrayWriter实现了可以用作Writer的字符缓存。当数据写入流时，缓存区会自动增长，可以使用toCharArray()和toString()检索数据。close方法是无效的，当关闭流后调用其他方法，不会抛出异常IOException。
 *         FilterWriter                FilterWriter是编写过滤字符流的抽象类。提供将请求传递到包含流的默认方法，FilterWriter子类会覆盖部分方法，甚至提供其他的方法和属性。
 *         OutputStreamWriter          OutputStreamWriter是字符流转换为字节流的桥梁：写入OutputStreamWriter的字符使用指定的字符集编码为字节。
 *         FileWriter                  FileWriter可以非常方便地写入字符文件，FileWriter类的构造函数假定默认字符编码和默认字节缓存大小是可以接受的。如要指定编码和缓存大小，可以在FileOutputStream上构造OutputStreamWriter。文件是否可用或是否可以创建取决于底层平台，特别是一些平台，一次只允许一个FileWriter（或其他文件写入对象）打开文件进行写入，
 *         PrintWriter                 PrintWriter将对象格式化打印到文本输出流。
 *         PipedWriter                 管道化字符输出流。
 *         StringWriter                StringWriter是一种字符流，将输出收集到字符串缓冲区，然后用于构造字符串。关闭StringWriter是无效的，StringWriter关闭后调用方法，不会抛出异常IOException。
 *     File:
 *         File文件和目录路径的抽象表达。
 *         用户接口和操作系统依赖路径名称命名文件和目录。File提供抽象、系统独立的层次路径名视图。
 *     RandomAccessFile:
 *         RandomAccessFile实例支持随机写入和读取文件。
 */
@Slf4j
public class TestIoFile {

    public static final String FILE = "src/main/resources/test/test.txt";
    public static final String EXPECTED_VALUE = "Hello,World!";

    // nio读取小文件
    @Test
    public void readSmallFile() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), FILE);
        String read = Files.readAllLines(path).get(0);
        Assert.assertEquals(EXPECTED_VALUE, read);
    }

    // nio读取大文件
    @Test
    public void readLargeFile() throws IOException {
        Path path = Paths.get(FILE);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            Assert.assertEquals(EXPECTED_VALUE, line);
        }
    }

    // nio读取大文件
    @Test
    public void readLargeFile2() throws IOException {
        Path path = Paths.get(FILE);
        try (Stream<String> data = Files.lines(path)) {
            List<String> lines = data.collect(Collectors.toList());
            Assert.assertEquals(EXPECTED_VALUE, lines.get(0));
        }
    }

    @Test
    public void testInputStream() throws IOException {
        Path path = Paths.get(FILE);
        InputStream in = Files.newInputStream(path);
        InputStreamReader in1 = new InputStreamReader(in, StandardCharsets.UTF_8);
        try (BufferedReader reader = new BufferedReader(in1)) {
            String currentLine = reader.readLine();
            Assert.assertEquals(EXPECTED_VALUE, currentLine);
        }
    }

    @Test
    public void testFileReader() throws IOException {
        FileReader in = new FileReader(FILE);
        try (BufferedReader reader = new BufferedReader(in)) {
            String currentLine = reader.readLine();
            Assert.assertEquals(EXPECTED_VALUE, currentLine);
        }
    }

    @Test
    public void testDataInputStream() throws IOException {
        String result = null;
        try (DataInputStream reader = new DataInputStream(Files.newInputStream(Paths.get(FILE)))) {
            int nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                result = new String(bytes);
            }
            Assert.assertEquals(EXPECTED_VALUE, result);
        }
    }

    @Test
    public void whenReadWithFileChannel() throws IOException {
        try (RandomAccessFile reader = new RandomAccessFile(FILE, "r");
             FileChannel channel = reader.getChannel()) {
            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);
            channel.read(buff);
            buff.flip();
            Assert.assertEquals(EXPECTED_VALUE, new String(buff.array()));
        }
    }

    // 6 Scanner
    @Test
    public void testScanner() throws IOException {
        try (Scanner scanner = new Scanner(new File(FILE))) {
            scanner.useDelimiter(",");
            Assert.assertTrue(scanner.hasNext());
            Assert.assertEquals("Hello", scanner.next());
            Assert.assertEquals("World!", scanner.next());
        }
    }


    @Test
    public void useCommonIO() throws IOException {
        FileInputStream fis = new FileInputStream(FILE);
        String data = IOUtils.toString(fis, "UTF-8");
        Assert.assertEquals(EXPECTED_VALUE, data.trim());
    }
}
