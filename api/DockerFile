FROM openjdk:11
RUN mkdir -p deploy
WORKDIR /deploy
# api.jar 이름 변경
COPY ./build/libs/api-0.0.1.jar api.jar
ENTRYPOINT ["java","-jar","/deploy/api.jar"]