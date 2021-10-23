plugins {
    java
}

group = "org.example.demin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":log"))
}

task<JavaExec>("startApplication") {
    standardInput = System.`in`
    group = "launch"
    workingDir = rootProject.projectDir
    classpath = sourceSets["main"].runtimeClasspath
    main = "org.example.demin.Application"

    val loggers = listOf(
        "ConsoleLogger1",
        "FileLogger",
        "CombinedLogger")

    args = listOf(loggers[0], "<a>%s</a>")
}