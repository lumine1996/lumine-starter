# 开发日志-1

## 使用Spring Initalizr初始化项目

[Spring Initalizr](https://start.spring.io/)是Spring官方提供的初始化工具，可以从网页访问，IDEA中也进行了集成。  
除了Spring的核心组件，此工具还能帮助用户选择一些常用的组件，如开发工具、Web相关、数据库相关。此工具会提供一份可以直接运行的服务端，基于此，开发者可以在几分钟内开发第一个接口。

::: tip Maven
Spring可以使用Maven或者Gradle构建，目前以Maven居多。Maven不仅仅是一款构建工具，开发者经常使用Maven来管理Java项目的依赖。  
初次拉取项目时，会消耗较多时间下载依赖，可在pom.xml中配置国内镜像仓库以加快速度。
:::

## 从GitHub创建项目

在GitHub创建项目时，GitHub会帮助开发者选择License文件，填写项目基本信息并添加一份自述文件，还有一些gitignore模板可以选择。

::: tip License
开源协议，用于规定其他用户使用此软件时的权利和义务。
:::

::: tip 自述文件
即README.md，可以帮助其他用户快速了解你的项目。md作为一种文档格式被广泛支持，它的优点是在纯文本时依然具有良好的可读性。
:::

::: tip gitignore
git会忽略在gitignore文件中标记的文件，从而避免一些不必要的信息被上传至git，例如仅在本地生效的文件、调试性的临时文件、重要信息等。
:::

## 在IDEA中创建项目
IDEA可以借助Spring Initalizr初始化项目，也可以从GitHub等网站拉取代码。本项目最初在GitHub创建，然后使用IDEA登录GitHub并拉取代码，
然后将Spring Initalizr的内容粘贴了进来。当然，登录GitHub后只能选择自己的项目，其他人的项目需要输入git地址。

项目初始化完成后，等待Maven下载依赖，IDEA创建索引，所有的后台任务完成后，即可启动项目。

以下代码是SpringBoot的启动入口，IDEA会在左侧提供启动按钮，通常我们选择Debug。

```java
package com.lumine.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LumineStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LumineStarterApplication.class, args);
	}

}
```

第一次启动后，IDEA的顶栏便会新增一份配置，之后我们可以从顶栏启动。
成功启动后，控制台会输出以下内容：
```
o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8500 (http) with context path ''  
c.l.starter.LumineStarterApplication     : Started LumineStarterApplication in 2.133 seconds (JVM running for 2.655)
```
