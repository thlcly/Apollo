# PREFACE
StatisticsDisk用于统计mac中目录的大小, 以便找出占用比较大的目录, 底层依赖的是shell的`du -sh`这个命令

# StatisticsDisk

 - 基于JDK 8

 - 基于MAVEN 3

# INSTALL

 - 安装[jdk 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [git](https://git-scm.com/download), [maven](https://maven.apache.org/download.cgi)

 - 下载项目源代码: `git clone https://github.com/thlcly/CodeStatistics.git`

 - 打包可运行jar文件: `mvn package`

 - 运行: `java -jar <jar-file-path> <file-path>`


# VERSION TRACE

 - 0.0.1-SNAPSHOT: 完成基本功能, 可以统计目录大小, 结果输出到控制台

