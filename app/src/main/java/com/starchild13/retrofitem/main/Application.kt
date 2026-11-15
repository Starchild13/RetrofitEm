package com.starchild13.retrofitem.main

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom application base class annotated with [@HiltAndroidApp] to trigger
 * Hilt's compile-time dependency injection code generation and container lifecycle management.
 */
@HiltAndroidApp
class Application : Application()
