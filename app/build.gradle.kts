import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
}

tasks {
    check.dependsOn("assembleDebugAndroidTest")
}

android {
    namespace = "com.ash.firebasepushapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ash.firebasepushapp"
        minSdk = 19
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources.excludes.add("LICENSE.txt")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.vectordrawable:vectordrawable-animated:1.1.0")
    implementation("androidx.core:core-ktx:1.12.0")

    // Required when asking for permission to post notifications (starting in Android 13)
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    implementation("com.google.android.material:material:1.11.0")

    // Import the Firebase BoM (see: https://firebase.google.com/docs/android/learn-more#bom)
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))

    // Firebase Cloud Messaging
    implementation("com.google.firebase:firebase-messaging")

    // For an optimal experience using FCM, add the Firebase SDK
    // for Google Analytics. This is recommended, but not required.
    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.firebase:firebase-installations:17.2.0")

    implementation("androidx.work:work-runtime:2.9.0")

    // Testing dependencies
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.annotation:annotation:1.7.1")
}
