plugins {
    idea
    java
    `maven-publish`
}

group = "me.elephant1214.ccfutils"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17-R0.1-SNAPSHOT")
    compileOnly("cloud.commandframework:cloud-paper:1.8.3")
    compileOnly("cloud.commandframework:cloud-annotations:1.8.3")
    compileOnly("cloud.commandframework:cloud-minecraft-extras:1.8.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }

    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])
        }
    }
}