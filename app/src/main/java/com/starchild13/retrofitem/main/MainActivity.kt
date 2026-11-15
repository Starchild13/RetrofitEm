package com.starchild13.retrofitem.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.starchild13.retrofitem.presentation.HomeScreen
import com.starchild13.retrofitem.ui.theme.RetrofitEmTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main entry point Activity of the application, annotated with [@AndroidEntryPoint]
 * to enable field and ViewModel dependency injection via Hilt.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting. Sets up the Jetpack Compose UI content
     * wrapped within [RetrofitEmTheme] and [HomeScreen].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitEmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   HomeScreen()
                }
            }
        }
    }
}
