学习笔记
## 周四
1. java是一种面向对象、静态类型、编译运行、有VM/GC和运行时、跨平台的高级语言.  
2. 每一次方法调用，JVM都会自动创建一个栈帧，由操作数栈(用于计算等)，本地变量表以及一个class引用组成. 
3. 类的生命周期:     
	*  加载：找class文件
	*  验证：验证格式、依赖
	*  准备：静态字段、方法表
	*  解析：符号解析为引用
	*  初始化：构造器、静态变量赋值、静态代码块 
	*  使用
	*  卸载
4. 类不回初始化的情况：
	*  通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化
	*  定义对象数组，不会触发该类的初始化
	*  常量在编译期间会存入调用类的常量池中，本质上并没有直接引用定义常量的类，不会触发定义常量所在的类
	*  通过类名获取Class对象，不会触发类的初始化，Hello.class不会让Hello类初始化
	*  通过Class.forName加载指定类时，如果指定参数initialize为false时，也不会触发类初始化，其实这个参数是告诉虚拟机，是否要对类进行初始化。Class.forName(“jvm.Hello”)默认会加载Hello类
	*  通过ClassLoader默认的loadClass方法，也不会触发初始化动作（加载了，但是不初始化）
5. JVM启动参数-堆内存
	*  -Xmx, 指定最大堆内存。 如 -Xmx4g. 
	*  -Xms, 指定堆内存空间的初始大小.
	*  -Xmn, 等价于 -XX:NewSize，使用G1垃圾收集器 不应该 设置该选项，在其他的某些业务场景下可以设置。官方建议设置为 -Xmx 的 1/2 ~ 1/4.	
	*  -Xss, 设置每个线程栈的字节数。
6. JVM启动参数-分析诊断
	*  -XX:+-HeapDumpOnOutOfMemoryError 选项, 当OutOfMemoryError 产生，即内存溢出(堆内存或持久代)时，自动Dump堆内存。 	
	*  -XX:HeapDumpPath 选项, 与HeapDumpOnOutOfMemoryError搭配使用, 指定内存溢出时Dump文件的目录。如果没有指定则默认为启动Java程序的工作目录。
	*  -XX:OnError 选项, 发生致命错误时(fatal error)执行的脚本。
	*  -XX:OnOutOfMemoryError 选项, 抛出 OutOfMemoryError 错误时执行的脚本。
	*  -XX:ErrorFile=filename 选项, 致命错误的日志文件名,绝对路径或者相对路径。


周六  

1. JVM命令行工具  
	*  jps/jinfo 查看java进程(jinfo -flags 可修改线上JVM参数)  
	*  jstat 查看JVM内部gc相关信息(常用参数：-gc、-gcutil、-gcnew、-gcold等)  
	*  jmap 查看heap(-heap)或类占用空间统计(-histo)
	*  jstack 查看线程信息
	*  jcmd 执行JVM相关分析命令(整合命令)
	*  jrunscript/jjs 执行js命令 	
2. JDK内置图形化工具
	*  jconsole
	*  jvisualvm
	*  visualGC
	*  jmc 
3. GC算法
	*  引用计数法(存在循环引用无法被GC问题)
	*  可达性算法 
	*  复制
	*  标记清除
	*  标记整理
4. 可以作为GC Roots的对象
	*  当前正在执行的方法里的局部变量和输入参数
	*  活动线程
	*  所有类的静态字段
	*  JNI 引用	 



