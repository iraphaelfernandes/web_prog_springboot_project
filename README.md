
# Spring Boot Sensors System


## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Build](#build)
- [Test](#test)
- [Run](#run)
- [Packaging](#packaging)

---

## Introduction

This project is a Spring Boot application built using Gradle. It demonstrates how to manage dependencies, compile code, run tests, and package the application into a JAR file. The project uses Gradle as the build tool and Spring Boot for the application framework.

---

## Prerequisites

Before you can build, test, or run this project, make sure you have the following installed:

- **Java 21** (or a compatible version)
- **Gradle** (or use the Gradle Wrapper included in the project)

To check if Java is installed, you can run:

```bash
java -version
```

To check if Gradle is installed, you can run:

```bash
gradle -v
```

Alternatively, you can use the Gradle Wrapper included in the project (`./gradlew` or `gradlew.bat` for Windows).

---

## Setup

1. **Clone the repository** to your local machine:

   ```bash
   git clone https://github.com/iraphaelfernandes/web_prog_springboot_project.git
   cd web_prog_springboot_project
   ```

2. **Ensure Java and Gradle are set up**:
    - If you are using the Gradle Wrapper, ensure the wrapper scripts (`gradlew` or `gradlew.bat`) are executable.
    - Make sure your Java version is set to Java 21 (as specified in the `build.gradle` file).

---

## Build

To build the project, run the following command:

```bash
./gradlew build
```

### This will:

- Download the required dependencies.
- Compile the source code.
- Run any tests (unless skipped).
- Package the application into an executable JAR file located in the `build/libs` directory.

---

## Test

By default, the tests will be run during the build process. If you want to skip the tests for a faster build (for example, during development), you can run the following command:

```bash
./gradlew build -x test
```

### Running Tests Only

To run tests separately without building the entire project, use:

```bash
./gradlew test
```

This will execute the tests and show the results in the terminal.

---

## Run

Once the project is built, you can run the application directly from the generated JAR file.

1. Locate the JAR file in the `build/libs/` directory. The file should be named something like `yourprojectname-0.0.1-SNAPSHOT.jar`.

2. Run the JAR file:

   ```bash
   java -jar build/libs/yourprojectname-0.0.1-SNAPSHOT.jar
   ```

3. The Spring Boot application will start, and you can access it at `http://localhost:8080` (or another port, if configured differently).

---

## Packaging

By default, the `./gradlew build` command will package the application as an executable JAR file. If you'd like to change the output format or configure packaging options, you can modify the `build.gradle` file accordingly.

### Customize JAR Name

You can customize the JAR file name by adding the following to your `build.gradle` file:

```gradle
tasks.bootJar {
    archiveFileName = "my-custom-application.jar"
}
```

Then run the build command again:

```bash
./gradlew build
```

This will produce a JAR file named `my-custom-application.jar`.

---

## Additional Commands

### Clean the Build

To remove all generated files and start fresh, use the `clean` task:

```bash
./gradlew clean
```

This will delete the `build/` directory and force Gradle to regenerate all files on the next build.

---

## Conclusion

You now have all the steps needed to build, test, and run the project with Gradle. Use `./gradlew build` for a full build and packaging process, or run individual tasks like `./gradlew test` and `./gradlew run` as needed.

For any questions or issues, feel free to open an issue in the project's repository.

---

### License

Open