todo
bit byte bool int 
对象: 对象头 实例数据 对齐补全

    java 虚拟内存占用很多,Java 进程占用 VIRT 虚拟内存超高的问题
    http://hk.javashuo.com/article/p-upjkgupi-bo.html
    
    java内存分析：
    打印gc
    垃圾收集器
    回收算法

	VisualVM
	
	内存转储
	
	虚拟机参数：
		打印配置
		
		
		
	
	案例分析：
		内存高：
		卡顿
	
	+PrintGCDetails
	PrintCommandLineFlags
	–verbose:jni gc class
	
	打印gc收集器
	直接内存  通道 nio
	
	
	测试：
		对象 占用内存
		
	
	新生代 ( Young ) 与老年代 ( Old ) 的比例的值为 1:2 ( 该值可以通过参数 –XX:NewRatio 来指定 )即：新生代 ( Young ) = 1/3 的堆空间大小。老年代 ( Old ) = 2/3 的堆空间大小。其中，新生代 ( Young ) 被细分为 Eden 和 两个 Survivor 区域，这两个 Survivor 区域分别被命名为 from 和 to，以示区分。
