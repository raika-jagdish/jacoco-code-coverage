# README: How to Execute the Program

This README file provides step-by-step instructions to execute the program and generate code coverage reports using JaCoCo.

---

## Prerequisites

Before running the program, ensure the following prerequisites are met:

1. **Java Development Kit (JDK)**: Install JDK 17 or higher.
2. **Maven**: Install Maven for building the project.
3. **Spring Boot**: Ensure the Spring Boot framework is set up.
4. **JaCoCo Agent and CLI**: Download the JaCoCo agent (`jacocoagent.jar`) and CLI (`jacococli.jar`) files and place them in the `target/lib` directory.
5. **Curl**: Install Curl for hitting REST endpoints (optional; Postman or browser can also be used).

---

## Steps to Execute the Program

### 1. Build the Project
Run the following command to clean and build the project:
```bash
mvn clean install
```

---

### 2. Start the Application
Run the application with the JaCoCo agent enabled:
```bash
java -javaagent:target/lib/jacocoagent.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver -jar target/jacoco-code-coverage-example-0.0.1-SNAPSHOT.jar
```

---

### 3. Hit REST Endpoints
Use Curl, Postman, or a browser to hit the REST endpoints and generate runtime data for code coverage.

Example using Curl:
```bash
curl -X GET http://localhost:8080/test/9
curl -X GET http://localhost:8080/test/50
```

---

### 4. Dump Coverage Data
Dump the collected coverage data into an `.exec` file using the following command:
```bash
java -jar target/lib/jacococli.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec
```

---

### 5. Generate Coverage Report
Convert the `.exec` file into a readable report format (e.g., HTML) using the following command:
```bash
java -jar target/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report
```

---

### 6. View the Report
Open the generated HTML report located at:
```
target/jacoco-report/index.html
```
Analyze the code coverage using the color-coded diamonds and background colors:
- **Red Diamond**: No branch executed.
- **Yellow Diamond**: Partial branch coverage.
- **Green Diamond**: Full branch coverage.

---

## Automating the Steps
To automate the above steps, use the provided shell script:

```bash
#!/bin/bash
mvn clean install
sleep 5
java -javaagent:target/lib/jacocoagent.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver -jar target/jacoco-code-coverage-example-0.0.1-SNAPSHOT.jar
sleep 5
curl -X GET http://localhost:8080/test/9
curl -X GET http://localhost:8080/test/50
sleep 5
java -jar target/lib/jacococli.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec
sleep 5
java -jar target/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report
```

Run the script from the project directory:
```bash
bash script.sh
```

---

## Notes
- Ensure the terminal is in the project directory before running commands.
- Modify paths in commands if your directory structure differs.

---

## Troubleshooting
- **Application not starting**: Verify the `jacocoagent.jar` path and ensure the application builds successfully.
- **Coverage data not dumped**: Check the port and address configuration in the `javaagent` argument.
- **Report not generated**: Ensure the `.exec` file exists in the `target` directory.

---

Enjoy analyzing your code coverage at runtime! 😊