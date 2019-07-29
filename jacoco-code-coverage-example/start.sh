export MAVEN_OPTS=-javaagent:src/main/resources/lib/jacocoagent.jar=address=*,ort=36320,destfile=jacoco-it.exec,output=tcpserver
mvn clean install
mvn spring-boot:run

curl -X GET http://localhost:8080/test/9
curl -X GET http://localhost:8080/test/50

java -jar src/main/resources/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/report
java -jar src/main/resources/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/report 
