plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("android")
}

android {
    namespace = "co.colombiaagro"
    compileSdk = 33

    defaultConfig {
        applicationId = "co.colombiaagro"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging.resources {
        excludes.add("META-INF/*")
    }
}

dependencies {

    // Android core libreries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose.implementation)

    // Coil
    implementation(libs.coil.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)

    // Dagger-hilt
    implementation(libs.bundles.dagger.hilt.implementation)
    kapt(libs.bundles.dagger.hilt.kapt)

    // Ktor
    implementation(libs.bundles.ktor.implementation)

    // Splash screen
    implementation(libs.androidx.splash.screen)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase.implementation)

    // Unit testing
    testImplementation(libs.junit)

    // Instrumentation testing
    androidTestImplementation(libs.bundles.espresso.androidTestImplementation)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.bundles.compose.androidTestImplementation)
    debugImplementation(libs.bundles.compose.debugImplementation)
}