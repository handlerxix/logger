plugins {
    java
}

group = "org.example.demin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val lombok = "org.projectlombok:lombok:1.18.4"

dependencies {
    compileOnly(lombok)
    annotationProcessor(lombok)
}