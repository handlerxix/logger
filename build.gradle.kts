plugins {
    java
    kotlin("jvm") version "1.4.31"
}

group = "org.example.demin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        compileOnly("com.intellij:annotations:12.0")
        implementation("com.google.inject:guice:4.1.0")
    }
}