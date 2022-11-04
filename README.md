# thrift-demo
-------
## 安装thrift
```shell
brew install thrift
```
or
```shell
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## 用thrift生成java代码
```shell
thrift -r -gen java src/main/thrift/HelloService.thrift
```

## Build

```shell
bazel build //:thrift-server
bazel build //:thrift-client
```


## Run
需要先运行server再运行client
```shell
bazel-bin/thrift-server
bazel-bin/thrift-client
```

## Result

server
```text
server start success with port 5001!
```
client
```text
LINYING
false
YINGLIN
```
