FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY ejb-module/target/ejb-module-1.0-SNAPSHOT.ejb ejb-module/target/ejb-module-1.0-SNAPSHOT.ejb

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ejb-module/target/ejb-module-1.0-SNAPSHOT.ejb"]
