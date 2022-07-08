plugins {
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management") apply true
    id("org.hidetake.swagger.generator") version "2.18.1"
    kotlin("plugin.spring") apply true
}

group = "br.com.cbgomes"
val kluentVersion = "1.65"
val swaggerVersion = "2.9.2"
val resilience4J by extra { "1.7.1" }
val springCloudVersion = "2020.0.4"

dependencies {
    api(project(":entrypoint"))
    api(project(":core"))
    api(project(":presenters"))
    api(project(":gateway"))

    // Web
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:2.2.10.RELEASE")
    // Cloud
    implementation(platform(notation = "org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
    implementation(group = "org.springframework.cloud", name = "spring-cloud-starter-sleuth")

    // API Docs
    implementation("io.springfox:springfox-swagger2:$swaggerVersion")
    implementation("io.springfox:springfox-swagger-ui:$swaggerVersion")
    implementation("org.webjars:swagger-ui:3.23.0")
}

tasks {
    jar {
        enabled = false
    }
}
