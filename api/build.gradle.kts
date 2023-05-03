plugins {}

version = "0.0.1"
dependencies {

    // spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")

    implementation(project(":domain")) // domain gradle.kts 전부 받아서 사용
    implementation(project(":kafka"))

    // test
    testImplementation("io.mockk:mockk:1.12.0")
    runtimeOnly("com.h2database:h2") // test 사용할 데이터베이스

    // AOP
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // Kotlin Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

}
