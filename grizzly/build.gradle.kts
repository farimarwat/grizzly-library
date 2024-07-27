plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
    id("signing")
}
val PUBLISH_GROUP_ID by extra("io.github.farimarwat")
val PUBLISH_VERSION by extra("2.0")
val PUBLISH_ARTIFACT_ID by extra("grizzly")
val PUBLISH_DESCRIPTION by extra("An Android library to handle ANRs and crashes that occur from third parties and beyond our control.")
val PUBLISH_URL by extra("https://github.com/farimarwat/grizzly")
val PUBLISH_LICENSE_NAME by extra("Apache 2.0 License")
val PUBLISH_LICENSE_URL by extra("https://www.apache.org/licenses/LICENSE-2.0")
val PUBLISH_DEVELOPER_ID by extra("farimarwat")
val PUBLISH_DEVELOPER_NAME by extra("Farman Ullah Marwat")
val PUBLISH_DEVELOPER_EMAIL by extra("farimarwat@gmail.com")
val PUBLISH_SCM_CONNECTION by extra("scm:git:github.com/farimarwat/grizzly.git")
val PUBLISH_SCM_DEVELOPER_CONNECTION by extra("scm:git:ssh://github.com/farimarwat/grizzly.git")
val PUBLISH_SCM_URL by extra("https://github.com/farimarwat/grizzly/tree/master")

apply(from = "${rootProject.projectDir}/scripts/publish-module.gradle")

android {
    namespace = "com.farimarwat.grizzly"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))

    // Add the dependencies for the Crashlytics and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")
}