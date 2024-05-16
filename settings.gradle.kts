pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven2.bai.lol")
        maven("https://maven.fabricmc.net/") { name = "Fabric" }
        maven("https://maven.quiltmc.org/repository/release") { name = "Quilt" }
        maven("https://maven.minecraftforge.net/") { name = "Forge" }
        maven("https://repo.spongepowered.org/repository/maven-public/") { name = "Sponge" }
    }
}

dependencyResolutionManagement.versionCatalogs.create("catalog") {
    // https://github.com/jmongard/Git.SemVersioning.Gradle
    plugin("semver", "com.github.jmongard.git-semver-plugin").version("0.12.6")

    // https://github.com/openrewrite/rewrite-gradle-plugin
    plugin("rewrite", "org.openrewrite.rewrite").version("6.13.0")
    library("rewrite-kotlin", "org.openrewrite", "rewrite-kotlin").version("1.15.0")
    library("rewrite-static-analysis", "org.openrewrite.recipe", "rewrite-static-analysis").version("1.6.0")
    library("rewrite-migrate-java", "org.openrewrite.recipe", "rewrite-migrate-java").version("2.13.0")

    val kotlin = "1.9.23"
    val minecraft = "1.20.6"
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    version("kotlin", kotlin)
    plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlin)
    plugin("kotlin-plugin-serialization", "org.jetbrains.kotlin.plugin.serialization").version(kotlin)

    version("minecraft", minecraft)
    library("minecraft", "com.mojang", "minecraft").version(minecraft)

    // https://github.com/badasintended/explosion
    plugin("explosion", "lol.bai.explosion").version("0.1.0")

    // https://fabricmc.net/develop/
    plugin("fabric-loom", "fabric-loom").version("1.6.+")
    library("yarn", "net.fabricmc", "yarn").version("$minecraft+build.1")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "DatapackGeneratorTemplate"

