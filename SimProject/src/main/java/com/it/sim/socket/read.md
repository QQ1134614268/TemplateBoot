socket流关闭:
    socket 内有 inputStream, outputStream
    包装嵌套流只用close 最外层, 自动调用内层close 方法
    socket只用调用close 即可释放 inputStream, outputStream

socket的 close方法与 shutdownInput shutdownOutput 表示流已经发送完毕;
