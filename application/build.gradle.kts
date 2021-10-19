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

    val pack = "org.example.demin.log"
    val loggers = listOf(
        "ConsoleLogger",
        "FileLogger",
        "CombinedLogger")
        .map { "$pack.$it" }

    args = listOf(loggers[2], "<a>%s</a>")
}