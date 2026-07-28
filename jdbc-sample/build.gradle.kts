plugins {
    id("java")
}

group = "br.com.dio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.flywaydb:flyway-core:10.11.1")
    implementation("org.flywaydb:flyway-mysql:10.11.1")

    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")

}

tasks.test {
    useJUnitPlatform()
}