plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvmDomain)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(Dependencies.Coroutines.kotlinCoroutinesCore)
    implementation(Dependencies.Inject.inject)
}