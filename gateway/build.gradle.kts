plugins {
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management") apply true
    kotlin("plugin.spring") apply true
}

group = "br.com.cbgomes"
val jacksonVersion by extra { "2.10.3" }
val springVersion by extra { "2.2.5.RELEASE" }
val feignOkhttpVersion by extra { "11.0" }
val mockkVersion by extra { "1.9.3" }
val resilience4J by extra { "1.7.1" }

dependencies {
    api(project(":core"))
    implementation(kotlin("stdlib"))

    // Serialization
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:$springVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("io.github.openfeign:feign-okhttp:$feignOkhttpVersion")

    implementation("io.github.resilience4j:resilience4j-spring-boot2:${resilience4J}")
    implementation("io.github.resilience4j:resilience4j-all:${resilience4J}") // Optional, only required when you want to use the Decorators class
    implementation("io.github.resilience4j:resilience4j-reactor:${resilience4J}")
    implementation("io.micrometer:micrometer-registry-prometheus")

    // Tests
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("junit:junit:4.13.2")
}

tasks {
    bootJar {
        enabled = false
    }
}
