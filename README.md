# event-orchestration-framework
event-orchestration-framework using solace pubsub

[![Java CI with Maven](https://github.com/imdadareeph/event-orchestration-framework/actions/workflows/maven.yml/badge.svg?branch=main&event=push)](https://github.com/imdadareeph/event-orchestration-framework/actions/workflows/maven.yml)


## Dependency

### Maven

Add the library as dependency in the project

```xml
<dependency>
  <groupId>com.imdadareeph</groupId>
  <artifactId>event-orchestration-framework</artifactId>
  <version>1.0</version>
</dependency>
```

### BUILD and RUN
```
mvn clean install -Dmaven.test.skip=true
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5007 -jar target/event-orchestration-framework-1.0.1.jar --spring.profiles.active=local --server.port=8888
```


Usefull links

[distributing-your-public-key](https://central.sonatype.org/publish/publish-maven/#distributing-your-public-key).

[JIRA](https://issues.sonatype.org/browse/OSSRH-82748).


