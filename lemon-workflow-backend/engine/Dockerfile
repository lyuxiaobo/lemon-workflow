# 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM openjdk:8u201-jdk-alpine3.9

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME ["/opt/LemonWorkflowFiles"]

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/engine-1.0-SNAPSHOT.jar app.jar
#启动容器时的进程
ENTRYPOINT ["java","-jar","/app.jar"]
#暴露8081端口
EXPOSE 8081
