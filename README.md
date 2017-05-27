# redis-java-client

A demo Java client for Redis cluster.

## Prerequisites

### 1. Set up a Redis cluster
You need set up a Redis cluster first, for example using this [vagrant](https://github.com/gengwg/redis-cluster-vagrant), which this client uses. Or you may use an existing one. If you use existing cluster, remember to change the IPs in the Java class.

### 2. Install Maven

On CentOS 7:
```bash
$ sudo yum install maven
$ mvn -version
Apache Maven 3.0.5 (Red Hat 3.0.5-17)
Maven home: /usr/share/maven
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.131-3.b12.el7_3.x86_64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.10.0-514.16.1.el7.x86_64", arch: "amd64", family: "unix"
```
### 3. Install Java
```
$ sudo yum install java
$ java -version
openjdk version "1.8.0_131"
OpenJDK Runtime Environment (build 1.8.0_131-b12)
OpenJDK 64-Bit Server VM (build 25.131-b12, mixed mode)
```

## Usage

```bash
$ mvn clean package
$ java -cp target/redis-client-1.0-SNAPSHOT.jar com.mycompany.app.RedisClient
```

## Example

```
$ mvn clean package
// first time run will download a lot of packages

$ java -cp target/redis-client-1.0-SNAPSHOT.jar  com.mycompany.app.RedisClient
Connection to server sucessfully
The number of nodes in cluster is: 6
foo: bar
hello: world
```
