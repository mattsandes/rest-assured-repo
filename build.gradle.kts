plugins {
    id("java")
}

group = "br.com.sandes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:5.5.1")
    testImplementation("io.rest-assured:json-path:5.5.1")
    testImplementation("io.rest-assured:json-schema-validator:5.5.1")
}

tasks.test {
    useJUnitPlatform()
}