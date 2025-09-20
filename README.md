# JavaWeb 实验二源码

本仓库包含了JavaWeb课程实验二的源代码，包含三个Servlet相关实验项目。

## 项目结构

```
shiyan2/
├── Count/          # 计数器相关实验
├── FirstServlet/   # 第一个Servlet示例
└── login/          # 登录功能实验
```

## 项目说明

### 1. Count 项目
包含Servlet计数器实现，演示了Servlet的生命周期和会话管理相关功能。

### 2. FirstServlet 项目
第一个Servlet程序示例，展示了Servlet的基本结构和请求处理流程，包含请求转发和页面跳转功能。

### 3. login 项目
登录功能实验，实现了简单的用户名密码验证功能。

## 开发环境
- IDE：IntelliJ IDEA
- JDK：Java SE
- Servlet：Servlet API
- 应用服务器：Tomcat

## 使用说明
1. 使用IntelliJ IDEA打开对应项目
2. 配置Tomcat服务器
3. 将项目部署到Tomcat并运行
4. 通过浏览器访问对应功能

## 注意事项
- 项目中的class文件为编译后的字节码文件
- lib目录下包含了Servlet API依赖库
- 每个项目的web.xml文件包含了Servlet的配置信息