学习笔记  
## 周四
1. 常用的GC参数
	* -XX:+PrintGCDetails：打印GC回收日志
	* -XX:+PrintGCTimeStamps：打印GC发生时间
	* -Xloggc:file ：将每次 GC 事件的相关情况记录到一个文件中(指定 ‐Xloggc: 参数，自动加上了 ‐XX:+PrintGCTimeStamps 配置)
	* -XX:+UseSerialGC：使用串行垃圾回收器
	* -XX:+UseParallelGC：使用并行垃圾回收器
	* -XX:+UseConcMarkSweepGC：使用 CMS 垃圾回收器(和 ‐XX:+UseParNewGC ‐XX:+UseConcMarkSweepGC 是等价的, 但如果只指定 ‐XX:+UseParNewGC 参 数则老年代GC会使用SerialGC。使用CMS时，命令行参数中会自动计算出年轻 代、老年代的初始值和最大值，以及最大晋升阈值等信息（例如 ‐ XX:MaxNewSize=178958336 ‐XX:NewSize=178958336 ‐ XX:OldSize=357912576 ）)
	* -XX:+UseG1GC：使用 G1 垃圾回收器    
2. 内存溢出分析
	* OutOfMemoryError: Java heap space(创建新的对象时，堆内存中的空间不足以存放新创建的对象) :  

		• 超出预期的访问量/数据量：应用系统设计时，一般是有 “容量” 定义的，部署这么多机器，用来处理一定流量的数据/业务。 如果访问量突然飙升，超过预期的阈值，类似于时间坐标系中针尖形状的图谱。那么在峰值所在的时间段，程序很可能就会卡死、并触发java.lang.OutOfMemoryError: Java heap space错误。  
		• 内存泄露(Memory leak)：这也是一种经常出现的情形。由于代码中的某些隐蔽错误，导致系统占用的内存越来越多。如果某个方法/某段代码存在内存泄漏，每执行一次，就会（有更多的垃圾对象）占用更多的内存。随着运行时间的推移，泄漏的对象耗光了堆中的所有内存，那么java.lang.OutOfMemoryError: Java heap space 错误就爆发了。
	* OutOfMemoryError: PermGen space/OutOfMemoryError: Metaspace：  
	java.lang.OutOfMemoryError: PermGen space 的主要原因，是加载到内存中的class 数量太多或体积太大，超过了 PermGen 区的大小。  
解决办法：增大 PermGen/Metaspace
-XX:MaxPermSize=512m  
-XX:MaxMetaspaceSize=512m  
高版本 JVM 也可以：  
-XX:+CMSClassUnloadingEnabled
	* OutOfMemoryError: Unable to create new native thread  
	java.lang.OutOfMemoryError: Unable to create new native thread 错误是程序创建的线程数量已达到上限值的异常信息。  
	解决思路：  
	调整系统参数 ulimit -a，echo 120000 > /proc/sys/kernel/threads-max  
	降低 xss 等参数  
	调整代码，改变线程创建和使用方式
	* 内存Dump分析工具  
	• Eclipse MAT  
	• jhat(需抽时间学习用法)	
3. JVM 问题分析调优
	* 高分配速率：  
	分配速率(Allocation rate)表示单位时间内分配的内存量。通常使用 MB/sec 作为单位。上一次垃圾收集之后，与下一次 GC 开始之前的年轻代使用量，两者的差值除以时间,就是分配速率。  
	正常系统：分配速率较低 ~ 回收速率 -> 健康  
	内存泄漏：分配速率 持续大于 回收速率 -> OOM  
	性能劣化：分配速率较高 ~ 回收速率 -> 压健康   
	
	蓄水池效应：通过增加年轻代大小，虽然不回降低分配速率，但是会减少GC的频率。如果每次 GC 后只有少量对象存活，minor GC 的暂停时间就不会明显增加。  

	* 过早提升：  
	提升速率（promotion rate）用于衡量单位时间内从年轻代提升到老年代的数据量。一般使用 MB/sec 作为单位, 和分配速率类似。   
	症状：  
	短时间内频繁地执行 full GC  
	每次 full GC 后老年代的使用率都很低，在10-20%或以下  
	提升速率接近于分配速率  
	解决方案：  
	一是增加年轻代的大小，设置 JVM 启动参数  
	二是减少每次批处理的数量，减少大对象
	   		
	
   