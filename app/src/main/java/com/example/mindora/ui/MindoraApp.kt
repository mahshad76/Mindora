package com.example.mindora.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.data.util.NetworkMonitor
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MindoraApp(networkMonitor: NetworkMonitor) {
    val isOnline by networkMonitor.isOnline.collectAsStateWithLifecycle(true)
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(isOnline) {
        if (!isOnline) {
            snackbarHostState.showSnackbar("No network", duration = Indefinite)
        }
    }
    Box(modifier = Modifier.fillMaxWidth()) {
        SnackbarHost(
            snackbarHostState,
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing.exclude(
                    WindowInsets.ime,
                ),
            ),
        )
    }
}