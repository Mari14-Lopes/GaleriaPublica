plugins {
    id("com.android.application")
}

android {
    namespace = "gouvea.lopes.mariana.galeriapublica"
    compileSdk = 33

    defaultConfig {
        applicationId = "gouvea.lopes.mariana.galeriapublica"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation fileTree(dir: "libs", include: ["*.jar"])
    def paging_version = "3.1.1"
    implementation "androidx.paging:paging-guava:$paging_version"
    implementation "androidx.paging:paging-runtime:$paging_version"
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.mediarouter:mediarouter:1.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}