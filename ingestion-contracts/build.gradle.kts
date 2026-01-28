plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

kotlin { jvmToolchain(17) }

dependencies {
    api(project(":domain"))
    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test { useJUnitPlatform() }
