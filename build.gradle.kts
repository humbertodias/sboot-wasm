import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.8.20"
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.8.20"
}

repositories {
    mavenCentral()
	mavenLocal()
    google()
}

kotlin {
   	wasm32("wasm") {
        binaries {
           executable {
               entryPoint = "wasm.main"
           }
       }
    }

    jvm("sboot")
    
    sourceSets {
       val wasmMain by getting {
          dependencies {
	         implementation(kotlin("stdlib"))
	         implementation(kotlin("stdlib-common"))
          }
       }

       val sbootMain by getting {
          dependencies {
             implementation("org.springframework.boot:spring-boot-starter")
             implementation("org.springframework.boot:spring-boot-starter-web")
			 implementation("org.springframework:spring-webmvc")
			 implementation("javax.servlet:javax.servlet-api:4.0.1")
			 implementation(kotlin("reflect"))
			 implementation(kotlin("stdlib-jdk8"))
          }
       }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

val run by tasks.creating(JavaExec::class) {
    val sboot: KotlinJvmTarget by kotlin.targets
    val sbootMain = sboot.compilations["main"]
    mainClass.set("sboot.AppKt")
    classpath = files(sbootMain.output) + sbootMain.runtimeDependencyFiles
}
