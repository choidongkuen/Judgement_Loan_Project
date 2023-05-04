plugins {
    kotlin("plugin.jpa")
}


version = "0.0.1"


allprojects {

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("org.mariadb.jdbc:mariadb-java-client:2.1.2")
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}
