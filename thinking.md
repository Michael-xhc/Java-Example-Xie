<p align="center">
    <img src="https://img.shields.io/badge/Spring%20Boot-2.0.4.RELEASE-blue.svg" alt="Downloads">
</p>

## 2020技术总结：
- 1、java基础：基础不太夯实 java核心卷（一）
- 2、数据库：连接池c3p0、druid 数据访问jdbc
   未解决：mysql底层原理？怎么存储数据？怎么优化sql？优化数据库？怎么调优？
- 3、前端技术：js css javascript jsp html 框架：VUE、REACT（安排时间学习）
- 4、动态网页技术：
    编程强化：多线程高级、涉及线程内存、线程通信 jvm优化、对JVM底层进行调优来提高项目执行效率、NIO 同步非阻塞IO来提高效率
    1、网络优化 网络怎么优化？三次握手四次挥手？
        域名转换：<img src="/D:/Workspaces/Haxb-Outsource-Xie/xie-common/target/classes/images"/>  
    2、设计模式 （继续看+归纳总结）
    3.多线程高级 （涉及线程内存、线程通信）（需要学习）
    4、数据结构与算法 （继续看+归纳总结）
    5、JVM优化（栈、堆、方法区、程序计算器）（需要学习）
- 5、软件项目管理 项目自动化集成 Jenkins 项目代码检查 sonar 项目研发管理 maven 项目协同管理 码云 svn git
- 6、热门技术框架：spring（aop与ioc） springmvc（请求流程） mybatis /plus（orm）--》springboot
- 7、分布式架构方案：
    dubbo 高性能的RPC服务发布和调用框架 springboot 简化spring应用的初始搭建以及开发过程、springcould 一系列框架的有序集合、如：服务发现注册、配置中心、负载均衡、断路器、数据监控等
    该板块的学习 可以具备大型互联网项目开发的必备技术和实际经验。为进入BATJ打下基础
- 8、服务器中间件：
    nosql存储：redis mongodb neo4j
    数据库中间件：sharding jdbc、mycat
    消息队列：rabbitmq、rocketmq kafka jms
- 9、服务器技术：Vmware虚拟机软件、Linux专门用于服务器的系统、Nginx集群部署时反向代理服务器、Tomcat项目发布时主要使用的服务器
   操作系统：Linux系统：centos与Ubuntu
          虚拟化：VMware与Virtualbox
          web服务器：jetty与Tomcat与Nginx
- 10、容器技术：Docker Kubernetes
- 11、业务解决方案：
搜素业务场景解决方案、日志收集与分析场景解决方案、工作流引擎场景解决方案、任务调度场景解决方案、地图开发平台场景解决方案、支付开放平台场景解决方案、图表可视化场景解决方案

## Java
- [x] 操作系统
- [x] 计算机网络
- [x] 编程原理
- [x] 数据结构与算法
- [x] 数据库

## 摘录
- 1、聪明人 都是依据事实做决策判断 而非凭感觉 ：依据细节事实做判断，而非凭感觉臆断
- 2、聪明人 都具备从1到N的演绎能力
- 3、聪明人 还具备复杂事物的简化能力
- 4、《教父》 半秒钟就看透事物本质的人，和花一辈子都看不清事物本质的人 注定是截然不同的命运

**重启服务器脚本:**
```shell
#!/bin/sh
kill -9 $(ps -ef|grep -i HAXB-Rest-Agent-Api.jar|grep -v grep|awk '{print $2}')
sleep 2

export JAVA_HOME=/app/jdk1.8.0_11
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

**远程调试参数（执行脚本）:**
```shell
cd /app/Agent-Api-uat/
java -Xdebug -Xrunjdwp:transport=dt_socket,address=3007,server=y,suspend=n  -jar HAXB-Rest-Agent-Api.jar --spring.profiles.active=uat&
```

```java
/** 
 *（标签）
 */
public class NettyServerMain {
} 
```

> 网址：
[rabbitmq教程链接](https://blog.csdn.net/hellozpc/article/details/81436980)
[dubbo文档](http://dubbo.apache.org/zh-cn/docs/user/new-features-in-a-glance.html)
[下载IDEA、PyCharm、PhpStorm免费激活码](http://idea.94goo.com/key)
[使用Hibernate-Validator优雅的验证参数](https://blog.csdn.net/qq_32258777/article/details/86743416)


