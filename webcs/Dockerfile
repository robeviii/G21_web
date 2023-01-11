FROM maven:latest as maven_builder

WORKDIR /app

COPY . /app

RUN mvn clean install

FROM tomcat:10.0


RUN mv webapps webapps2
RUN mv webapps.dist/ webapps

COPY --from=maven_builder /app/target/webcs-1.war /usr/local/tomcat/webapps

COPY ./src/main/webapp/WEB-INF/lib /usr/local/tomcat/lib

EXPOSE 8080

CMD ["catalina.sh", "run"]