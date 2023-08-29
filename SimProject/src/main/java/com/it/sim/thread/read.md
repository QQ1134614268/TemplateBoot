todo 多线程 

    Runnable 执行
    Thread   执行 捕获异常
    Callable 执行 捕获异常 返回值
    Future   执行 捕获异常 返回值 取消,查询完成
         RunnableFuture -> FutureTask -> ScheduledFutureTask
         ScheduledFuture -> RunnableScheduledFuture
         ForkJoinFuture -> RecursiveTask; RecursiveAction ??
         CompletableFuture java8推荐
    CompletionService -> ExecutorCompletionService 异步 解耦?? 避免 FutureTask 阻塞
    ThreadPool -> execute(无返回值) submit(取结果)

    锁
      读写
      重入
      synchronized

    Condition
    线程工厂
    
    concurrent 包 源码
