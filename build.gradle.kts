plugins {
    id("java-platform")
    id("maven-publish")
}

description = "Brewery library BOM"

var mapstructVersion = "1.6.3"
var lombokVersion = "1.18.36"
var lombokMapstructBindingVersion = "0.2.0"
var jaxbVersion = "4.0.5"
var jakartaVersion = "4.0.2"
var awaitibilityVersion = "4.3.0"

javaPlatform.allowDependencies()

dependencies{
    api(platform("org.springframework.boot:spring-boot-dependencies:3.4.4"))
}


dependencies.constraints {

    api("jakarta.xml.bind:jakarta.xml.bind-api:${jakartaVersion}")
    api("com.sun.xml.bind:jaxb-core:${jaxbVersion}")
    api("com.sun.xml.bind:jaxb-impl:${jaxbVersion}")

    // MapStruct
    api("org.mapstruct:mapstruct:${mapstructVersion}")

    // Awaitility (test)
    api("org.awaitility:awaitility:${awaitibilityVersion}")

    // Otros útiles en el proyecto
    api("org.projectlombok:lombok:${lombokVersion}")
    api("org.junit.jupiter:junit-jupiter-api")
    api("org.junit.jupiter:junit-jupiter-engine")
    api("org.mockito:mockito-junit-jupiter")

    // Spring Starters (sin versiones explícitas gracias al BOM de Spring Boot)
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-actuator")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-devtools")
    api("org.springframework.boot:spring-boot-starter-test")

    // Drivers
    api("com.h2database:h2")
    api("mysql:mysql-connector-java")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}