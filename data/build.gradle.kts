plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinJvm)
    //Kapt
    kotlin(Plugins.kapt)
    //Hilt
    id(Plugins.hilt)
}

android {
    namespace = Config.applicationIdData
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "\"https://kitsu.io/api/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://kitsu.io/api/\"")
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
        buildConfig = true
    }
}

dependencies {

    implementation(Dependencies.AndroidCore.core)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)

    //hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)

    // Coroutines
    implementation(Dependencies.Coroutines.kotlinCoroutines)
    implementation(Dependencies.Coroutines.kotlinCoroutinesCore)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)

    // Gson
    implementation(Dependencies.Gson.gson)

    // OkHttp
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.okHttpBom)
    implementation(Dependencies.OkHttp.okHttpLoggingInterceptor)

    //Domain
    api(project(":domain"))
}