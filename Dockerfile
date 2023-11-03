FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/5BI6-G3-Kaddem-1.0.jar 5BI6-G3-Kaddem-1.0.jar
ENTRYPOINT ["java","-jar","/5BI6-G3-Kaddem-1.0.jar"]
