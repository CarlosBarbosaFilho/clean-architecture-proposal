plugins {
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management") apply true
    kotlin("plugin.spring") apply true
}

group = "br.com.cbgomes"
version = "0.0.1-SNAPSHOT"

val versionSpringDataJPA = "2.5.5"

dependencies {

    implementation(group = "org.springframework", name = "spring-context", version = "5.3.10")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.7.2")
    testImplementation(group = "io.mockk", name = "mockk", version = "1.12.0")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.7.2")
}

tasks {
    bootJar {
        enabled = false
    }
}
