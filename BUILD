load("@rules_java//java:defs.bzl", "java_library", "java_binary")

java_library(
    name = "java-maven-lib",
    srcs = glob(["src/main/java/com/demo/*.java"]),
    deps = [
      "@maven//:org_apache_thrift_libthrift",
      "@maven//:org_slf4j_slf4j_api",
      "@maven//:javax_annotation_javax_annotation_api",
      "@maven//:ch_qos_logback_logback_classic",
    ],
)

java_binary(
  name = "thrift-server",
  main_class = "com.demo.HelloServiceServer",
  runtime_deps = [":java-maven-lib"],
)

java_binary(
  name = "thrift-client",
  main_class = "com.demo.HelloServiceClient",
  runtime_deps = [":java-maven-lib"],
)