plugins { kotlin("jvm") }

kotlin { jvmToolchain(17) }

dependencies {
    api(project(":domain"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

tasks.test { useJUnitPlatform() }
