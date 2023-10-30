todo socket

    socket流关闭:
        socket 内有 inputStream, outputStream
        包装嵌套流只用close 最外层, 自动调用内层close 方法
        socket只用调用close 即可释放 inputStream, outputStream
    
    socket的 close方法与 shutdownInput shutdownOutput 表示流已经发送完毕;
    
    关于流的结尾 -1的问题
        一，java中在处理short,byte类型时都是按照int存储和计算的，运算后再进行强制类型转换。
        二，由于java读取的一字节按照int型是没有负数的，故可以用-1作为返回值标志文件字节流的结束
        1. 这是read()方法中的注释，意识就是read()从输入流中读取下一个字节。如果没有字节可读（也就是read()读到文件最后了）read()返回-1.
    
    
    
    读取字节两种方法:
        readByte==-1
        readLine 读取一行,直到遇到\n
    
    stream:
        OutputStream
        BufferOutputStream 效果相同, 都需要flush
        BufferedReader 有readLine
    
    flush:
        刷新数据,对方socket可以readByte, 但是readByte不会有-1,readline没有\n
    
    shutdownOutput: 
        readByte有 -1
        
    buffer 需要flush outputStream不需要
    
    close 会调用flush; try resource 会调用close