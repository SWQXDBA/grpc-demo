# grpc-demo
## 原理：
```
根据.proto文件生成相应语言的代码 拷贝到项目中运行
```
因为已经预先拷贝好了生成的代码，所以可以直接运行  

src/main/java/example/Main/demo中的客户端和服务端案例


# 如果想要修改proto重新编译 :
```
 在protoBuild项目中运行 mvn clean install 来生成java代码
 然后将protoBuild项目中的target/generated-sources/protobuf中生成的代码，
 拷贝到 grpc-demo项目的src/main/java/example/protobuf目录下进行替换
 
```
