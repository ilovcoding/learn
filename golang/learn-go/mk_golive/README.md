# Go高级工程师实战营
> [https://class.imooc.com/sale/golive](https://class.imooc.com/sale/golive)
# 第一节
---
# 语言
调度原理
调试技巧
汇编反汇编
内部数据结构实现
常见是 sys_call
函数调用规定
内存管理和回收
并发编程

# 深度
框架原理
社区框架分析
模块分层
linter 规范
中台场景实现
性能调优

# 架构广度
模块拆分
CI/CD 实战
监控和可观测性
服务发现/信息搜索
定时任务/MQ 等基础设施
稳定性保障
未来架构
语言前沿

# 信息
GitHub Trending 
reddit
hacker news
https://www.acm.org/
oreily
OSDI SOSP VLDB 论文

# GO 优势
API 居多 网络IO密集， 运行底 无 VM。 网络连接数不多内存占用低，上手成本低技术菜也能写出性能较好的代码

# 编译过程
go build -x 可以查看详细过程 
> https://github.com/corkami/pics/blob/master/binary/elf101/elf101.pdf

# GO 初始化
Scheduler 调度管理所有的 G、M、P 在后台执行 （GMP 运行原理动画）
 - 本地队列 全局队列
 - 如何处理用户阻塞，一部分go runtime 处理，其他 sysmon system monitor， 检查当前是不是所有线程都被锁住了死锁报错，
 - netpoll 插入一个 G
 - retake syscall 卡了很久将 p 剥离，如果执行了很久大概10ms 通知抢占。
Netpoll 网络轮询负责管理网络 FD 相关的读写就绪事
Memory 当代码需要内存时，负责内存分配工作
Garbage 当内存不在需要的时候，负责回收内存

## 其他资料
- https://github.com/golang-design/history
- https://www.geeksforgeeks.org/golang-goroutine-vs-thread/
- 