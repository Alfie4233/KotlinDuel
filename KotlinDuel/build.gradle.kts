plugins {
    kotlin("jvm") version "2.3.21"
    id("org.sonarqube") version "5.0.0.4638"
    id("org.jetbrains.kotlinx.kover") version "0.8.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(25) // Or 26, depending on your installed JDK
}

sonar {
    properties {
        property("sonar.projectKey", "Alfie4233_KotlinDuel")
        property("sonar.organization", "alfie4233")
        property("sonar.host.url", "https://sonarcloud.io")
        // Tells SonarQube where to find the coverage data Kover generates
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/kover/report.xml")
    }
}

tasks.check {
    dependsOn("koverXmlReport")
}