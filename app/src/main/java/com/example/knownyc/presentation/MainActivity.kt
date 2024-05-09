package com.example.knownyc.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.knownyc.presentation.ui.navigation.AppNavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import com.example.knownyc.presentation.ui.theme.KnowNYCTheme
import com.example.knownyc.presentation.ui.util.AppEvents

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEvents(context = this)
            KnowNYCTheme {
                Surface(modifier =  Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppEntryPoint()
                }
            }
        }
    }
}
@Composable
fun AppEntryPoint(){
    AppNavigationGraph()
}
