plugins {
    alias(catalog.plugins.kotlin.jvm)
    alias(catalog.plugins.kotlin.plugin.serialization)

    alias(catalog.plugins.semver)
    alias(catalog.plugins.rewrite)

    alias(catalog.plugins.fabric.loom)
}

group = "settingdust"
version = semver.semVersion.toString()

allprojects {
    apply(plugin = catalog.plugins.fabric.loom.get().pluginId)
}

rewrite {
    activeStyle("settingdust.RewriteStyle")
    activeRecipe("settingdust.Recipes")
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft(catalog.minecraft)
    mappings(variantOf(catalog.yarn) { classifier("v2") })

    rewrite(catalog.rewrite.kotlin)
    rewrite(catalog.rewrite.static.analysis)
    rewrite(catalog.rewrite.migrate.java)
}

kotlin {
    jvmToolchain(21)
}
