FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} /openweatherapp.war
COPY src/main/resources/application.properties /application.properties
ENTRYPOINT ["java","-jar","/openweatherapp.war", "-Dspring.config.location=classpath:/application.properties"]
