plugins {
	java
	id("org.springframework.boot") version "2.7.6"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.projectlombok:lombok:1.18.20")
	annotationProcessor("org.projectlombok:lombok:1.18.20")
	testCompileOnly ("org.projectlombok:lombok:1.18.12")
	testAnnotationProcessor ("org.projectlombok:lombok:1.18.12")

	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.oracle.database.jdbc:ojdbc8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
