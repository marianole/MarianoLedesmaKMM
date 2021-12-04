import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import java.io.*
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    // Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")

    // Kotlin Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    val lifecycle_version = "2.4.0-alpha03"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    // Retrofit
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.example.tp_kmm.android"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug"){
            val localProperties = Properties()
            localProperties.load(FileInputStream(rootProject.file("local.properties")))

            buildConfigField("String", "PRIVATE_KEY", "\"" + localProperties["privateKey"] + "\"")
            buildConfigField("String", "PUBLIC_KEY", "\"" + localProperties["publicKey"] + "\"")

        }
    }
    buildFeatures{
        viewBinding = true
    }


}