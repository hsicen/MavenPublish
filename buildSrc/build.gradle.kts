plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object Plugins {
    const val AGP = "4.2.2"
    const val KOTLIN = "1.5.21"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
}