plugins {
    id(Plugins.application)
    id(Plugins.kotlinJvm)
    //Kapt
    kotlin(Plugins.kapt)
    //Hilt
    id(Plugins.hilt)
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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
}

dependencies {

    implementation(Dependencies.AndroidCore.core)
    implementation(Dependencies.UIComponents.appCompat)
    implementation(Dependencies.UIComponents.material)
    implementation(Dependencies.UIComponents.constraint)

    implementation(Dependencies.ViewPager.viewPagerLegacySupport)
    implementation(Dependencies.Lifecycles.liveData)
    implementation(Dependencies.Lifecycles.viewModel)

    //hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)

    //Presentation
    implementation(project(":presentation"))
    //Data
    implementation(project(":data"))
}