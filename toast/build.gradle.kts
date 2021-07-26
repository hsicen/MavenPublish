plugins {
    id("com.android.library")
    id("kotlin-android")
    id("signing")
    id("maven-publish")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
        versionCode = 5
        versionName = "1.0.5"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("com.github.hsicen:Extensions:1.0.6")
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release buildTypes.
                from(components["release"])

                // You can then customize attributes of the publication as shown below.
                groupId = "io.github.hsicen"
                artifactId = "toast"
                version = "1.0.5"

                pom {
                    name.set("toast")
                    description.set("A concise description of my library")
                    url.set("http://www.example.com/library")
                    properties.set(
                        mapOf(
                            "myProp" to "value",
                            "prop.with.dots" to "anotherValue"
                        )
                    )
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("hsicen")
                            name.set("hsicen")
                            email.set("hsiceni@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:git://example.com/my-library.git")
                        developerConnection.set("scm:git:ssh://example.com/my-library.git")
                        url.set("http://example.com/my-library/")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "toast"
                url = uri(properties["mavenUrl"].toString())
                credentials {
                    username = properties["mavenName"].toString()
                    password = properties["mavenPwd"].toString()
                }
            }
        }
    }

    signing {
        sign(publishing.publications.getByName("release"))
    }
}