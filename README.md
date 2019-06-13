# ladygaga

基于Bytebuddy实现无侵入检测类方法执行时长的代码示例。

## 配置文件
```
agent:
  include:
    - com.test
  exculde:
    - com.sun
    - java
    - net.bytebuddy.
    - org.slf4j.
    - org.apache.logging.
    - org.groovy.
    - javassist
    - .asm.
    - sun.reflect
  exclude-class:
    - .*EnhancerByCGLIB.*
    - .*FastClassByCGLIB.*
  log:
    path: ladygg/

```
* include 需要检测包名
* exculde 不需要检测包名
* log 日志或过程类生成路径

## 如何运行
* maven install 构建项目，生成jar包
* 设置运行参数

设置-javaagent参数
```
-javaagent:/Documents/workspace/ladygaga/target/com.gwill.agent-1.0-SNAPSHOT-jar-with-dependencies.jar=/Documents/workspace/ladygaga/src/main/resources/agent_conf.yml
```
* 执行com.test.Application