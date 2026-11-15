// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.60.1")
    }
}

plugins {
    id("com.android.application") version "9.5.1" apply false
    id("com.google.devtools.ksp") version "2.3.14" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.4.21" apply false
}
