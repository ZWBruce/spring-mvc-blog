# 开发
命令都在 boot.sh 中

# 开发环境
直接使用 spring-boot-maven-plugin 启动项目，不需要 tomcat

# 生产环境
1. 切到 tomcat 安装目录（/usr/local/Cellar/tomcat/10.1.14/libexec/webapps），运行 ./catalina.sh run（应该也可以通过设置 zsh 环境变量方式全局执行命令）
2. 将 war 包 copy 到指定目录下，tomcat 每次启动时会自动解压并部署 war
3. 手动解压：
```
jar -xf xxx.war
```

# 附录
本地安装完成后日志：
```
tomcat
Configuration files: /usr/local/etc/tomcat

To start tomcat now and restart at login:
  brew services start tomcat
Or, if you don't want/need a background service you can just run:
  /usr/local/opt/tomcat/bin/catalina run
```

常用的 Tomcat 命令：

1. 启动 Tomcat 服务器：
   ````
   ./catalina.sh start
   ```

2. 停止 Tomcat 服务器：
   ````
   ./catalina.sh stop
   ```

3. 重启 Tomcat 服务器：
   ````
   ./catalina.sh restart
   ```

4. 查看 Tomcat 服务器状态：
   ````
   ./catalina.sh status
   ```

5. 查看 Tomcat 服务器日志：
   ````
   tail -f /usr/local/Cellar/tomcat/10.1.14/libexec/logs/catalina.out
   ```

6. 部署 WAR 文件：
   将 WAR 文件复制到 Tomcat 的 `webapps` 目录下即可自动部署。

7. 清理 Tomcat 工作目录：
   ````
   ./catalina.sh clean
   ```

结合 docker 使用：

在Docker容器中安装的Tomcat，Webapps目录位于Tomcat容器内的`/usr/local/tomcat/webapps`路径下。您可以将WAR文件放置在该目录中，以便Tomcat自动部署您的应用程序。

要将WAR文件复制到Tomcat容器的Webapps目录中，可以使用Docker命令或Dockerfile中的指令。下面是一些示例：

1. 使用Docker命令复制WAR文件：
   ````bash
   docker cp your-app.war container_name:/usr/local/tomcat/webapps/
   ```
   其中，`your-app.war`是您的WAR文件名，`container_name`是Tomcat容器的名称或容器ID。

2. 在Dockerfile中复制WAR文件：
   在您的Dockerfile中添加以下指令，将WAR文件复制到Webapps目录：
   ````Dockerfile
   COPY your-app.war /usr/local/tomcat/webapps/
   ```
   在构建镜像时，Docker将会将WAR文件复制到指定的路径。

请注意，这些示例假定您的Tomcat容器已正确配置，并且您已经在Docker环境中启动了Tomcat容器。确保您已经正确设置了Tomcat容器，并遵循适用于您环境的Docker相关指南。

一旦WAR文件位于Tomcat容器的Webapps目录中，Tomcat将自动部署该应用程序，并您可以通过访问`http://localhost:8080/your-app`来访问您的应用程序（其中`your-app`是WAR文件名去除`.war`后的部分）。