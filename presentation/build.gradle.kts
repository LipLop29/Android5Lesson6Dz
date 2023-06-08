plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinJvm)
    //Kapt
    kotlin(Plugins.kapt)
    //Safe args
    id(Plugins.safeArgs)
    //Hilt
    id(Plugins.hilt)
    id(Plugins.parcelize)
}

android {
    namespace = Config.applicationIdPresentation
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.AndroidCore.core)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)
    implementation(Dependencies.UIComponents.constraint)

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    kapt(Dependencies.Hilt.hiltCompiler)

    // NavigationComponent
    implementation(Dependencies.NavigationComponent.navigationFragment)
    implementation(Dependencies.NavigationComponent.navigationUI)

    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingPropertyDelegate)

    // Coroutines
    implementation(Dependencies.Coroutines.kotlinCoroutines)
    implementation(Dependencies.Coroutines.kotlinCoroutinesCore)

    // Gson
    implementation(Dependencies.Gson.gson)

    // Glide
    implementation(Dependencies.Glide.glide)

    //Domain
    implementation(project(":domain"))
}