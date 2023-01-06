package com.it.sim.jvm.javamemory;

import java.util.ArrayList;
import java.util.List;
//堆溢出

// -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
public class HeapOOM {
    static class OOMObject {

    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        //大约创建 787046个对象
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
//java.lang.OutOfMemoryError: Java heap space
// Dumping heap to java_pid46228.hprof ...
// Heap dump file created [28101268 bytes in 0.081 secs]
// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
// 	at java.nio.CharBuffer.wrap(CharBuffer.java:373)
// 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:265)
// 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
// 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
// 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
// 	at java.io.PrintStream.write(PrintStream.java:526)
// 	at java.io.PrintStream.print(PrintStream.java:597)
// 	at java.io.PrintStream.println(PrintStream.java:736)
// 	at com.it.JavaMemory.HeapOOM.main(com.it.JavaMemory.HeapOOM.java:12)
// *** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message can't create name string at JPLISAgent.c line: 807
//
// Process finished with exit code 1