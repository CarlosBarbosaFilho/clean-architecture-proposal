plugins {
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management") apply true
    id("org.hidetake.swagger.generator") version "2.18.1"
    kotlin("plugin.spring") apply true
}

group = "br.com.cbgomes"
version = "0.0.1-SNAPSHOT"

val versionSpringDataJPA = "2.5.5"

dependencies {

    api(project(":core"))

    //JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$versionSpringDataJPA")

    // Database
    runtimeOnly(group = "org.postgresql", name = "postgresql")
    //implementation(group = "org.flywaydb", name = "flyway-core")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.7.2")
    testImplementation(group = "io.mockk", name = "mockk", version = "1.12.0")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.7.2")
}

tasks {
    bootJar {
        enabled = false
    }
}
