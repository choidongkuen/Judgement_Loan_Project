plugins {}

version = "0.0.1"
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")

    implementation(project(":domain")) // domain gradle.kts 전부 받아서 사용

    testImplementation("io.mockk:mockk:1.12.0")
    runtimeOnly("com.h2database:h2") // test 사용할 데이터베이스

}
