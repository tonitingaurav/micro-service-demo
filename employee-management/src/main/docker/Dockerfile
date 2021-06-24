FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
EXPOSE 8080

ENV APP_HOME /usr/local/employee-app
ENV JAVA_OPTS=""

RUN mkdir -p ${APP_HOME}
RUN mkdir -p ${APP_HOME}/config
RUN mkdir -p ${APP_HOME}/log

WORKDIR ${APP_HOME}

COPY  @project.build.finalName@.jar ./
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar @project.build.finalName@.jar" ]