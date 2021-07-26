plugins {
    id("maven-publish")
    id("signing")
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release buildTypes.
                if (plugins.hasPlugin("com.android.library")) {
                    from(components["release"]) // android-aar include code file and res
                } else {
                    from(components["java"]) //java-jar include code file
                }

                // You can then customize attributes of the publication as shown below.
                groupId = "io.github.hsicen"
                artifactId = "toast"
                version = Sdk.versionName

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