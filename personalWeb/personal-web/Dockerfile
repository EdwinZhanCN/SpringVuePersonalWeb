# 使用官方镜像
FROM amazoncorretto:17.0.9

# 从构建阶段复制打包好的jar文件
COPY  target/personal-web-0.0.1-SNAPSHOT.jar app.jar

# 指定容器启动时要运行的命令
ENTRYPOINT ["java","-jar","app.jar"]

# 对外暴露的端口号应与应用程序的端口号相同
EXPOSE 8080
