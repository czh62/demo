# demo

This is a demo project.

## 环境要求

- Maven latest version
- Spring Boot latest version
- JDK 22 or later

## 开始使用

- 打开Idea，选择从VCS导入项目，输入项目地址：https://github.com/czh62/demo.git
- 若已经打开界面，找不到clone from VCS，可以点击左上角项目名称，然后点击Get From Version Control，输入项目地址：https://github.com/czh62/demo.git

- --

- 等待代码拉取完成，然后在Idea中打开项目，等待Maven项目索引完成,右侧会出现Maven的图标
- 依次进入 src/main/java/com/example/demo/DemoApplication.java 启动类，点击运行按钮，项目会自动编译并启动

## 可能问题

- 项目启动失败，请检查Maven项目索引是否成功，可以点击右侧M标志的Maven界面，点击刷新按钮(Reload All Maven Projects)。
- 检查JDK配置，请确保JDK版本为22或以上，百度Idea的JDK配置教程，可以选择Download JDK，下载并安装。

## 项目结构

- src/main/java/com/example/demo/DemoApplication.java 启动类
- src/main/resources/application.properties 配置文件
- src/main/java/com/example/demo/controller 控制器
- src/main/java/com/example/demo/service 服务层
- ......

## 自定义

- 可以在src/main/java/com/example/demo/config/SystemConst.java中自定义一些基础信息，具体可以参考该类中的注释。
- 由于没有连接数据库，所以无法实现增删改，可以根据需求自定义增删改查的接口，然后在控制器中调用服务层的接口实现增删改查。
