FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
WORKDIR /usr/local/dist/demo
COPY ./@project.build.finalName@.jar ./
COPY ./run.sh ./
RUN chmod +x run.sh
CMD ./run.sh
