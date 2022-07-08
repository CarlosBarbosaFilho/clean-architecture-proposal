plugins {
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management") apply true
    id("org.hidetake.swagger.generator") version "2.18.1"
    kotlin("plugin.spring") apply true
}

group = "br.com.cbgomes"
val springCloudVersion = "2020.0.4"

val kluentVersion = "1.65"
val swaggerVersion = "2.9.2"

dependencies {

    api(project(":core"))
    api(project(":gateway"))

    // Web
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-actuator")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-validation")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin")

    // Cloud
    implementation(platform(notation = "org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
    implementation(group = "org.springframework.cloud", name = "spring-cloud-starter-sleuth")

    // API Docs
    implementation("io.springfox:springfox-swagger2:$swaggerVersion")
    implementation("io.springfox:springfox-swagger-ui:$swaggerVersion")
    implementation("org.webjars:swagger-ui:3.23.0")

    // Tests
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
}

tasks {
    bootJar {
        enabled = false
    }
}
