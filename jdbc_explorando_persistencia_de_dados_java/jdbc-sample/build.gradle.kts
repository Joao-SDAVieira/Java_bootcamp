plugins {
    id("java")
    id("application") // <-- adiciona esse plugin
    id("org.flywaydb.flyway") version "10.11.1"
}

group = "br.com.dio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.flywaydb:flyway-core:10.11.1")
    implementation("org.flywaydb:flyway-mysql:10.11.1")

    implementation("net.datafaker:datafaker:2.2.2")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}


flyway {
    url = "jdbc:mysql://localhost:3306/jdbc-sample"
    user = "jdbc-sample"
    password = "jdbc-sample"
}


application {
    // Se sua classe Main está em src/main/java/br/com/project/Main.java
    mainClass = "br.com.project.Main"
}
