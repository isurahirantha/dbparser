FROM java:8
RUN mkdir /libs
COPY /target/mvn-project.jar .
COPY /target/libs/mysql-connector-java-8.0.16.jar /libs
CMD ["java","-jar","mvn-project.jar"]