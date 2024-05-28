# TAS Java Native Image Demo

## Deployment Options

### Cf push "jar" archive, JIT compiled execution (normal "cf push")
mvn package
cf push tas-jit-java-demo

### Cf push "jar" archive, natively compiled on platform using v3 buildpack
```
mvn clean package -Pnative
cf push    tas-native-java-jar-demo -p target/demo-0.0.1-SNAPSHOT.jar -b java_native_image_cnb_beta -s tanzu-jammy-full-stack -m 4G --no-start
cf set-env tas-native-java-jar-demo BP_MAVEN_ACTIVE_PROFILES native
cf set-env tas-native-java-jar-demo BP_JVM_VERSION 17
cf start   tas-native-java-jar-demo
```

#### Cf push source directory, natively compiled on platform using v3 buildpack
```
mvn clean
cf push    tas-native-java-source-demo -b java_native_image_cnb_beta -s tanzu-jammy-full-stack -m 4G --no-start
cf set-env tas-native-java-source-demo BP_MAVEN_ACTIVE_PROFILES native
cf set-env tas-native-java-source-demo BP_JVM_VERSION 17
cf start   tas-native-java-source-demo
```

