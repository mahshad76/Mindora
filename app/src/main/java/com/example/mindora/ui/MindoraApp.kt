package com.example.mindora.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.data.util.NetworkMonitor
import com.example.mindora.R
import com.mahshad.api.navigation.InterestsNavKey
import com.mahshad.impl.BookmarkEntry
import com.mahshad.impl.InterestsEntry

const val EMPTY_LOCAL_PROVIDER_MESSAGE = "SnackbarHostState state should be initialized at runtime"

@Composable
fun MindoraApp(networkMonitor: NetworkMonitor) {
    val isOnline by networkMonitor.isOnline.collectAsStateWithLifecycle(true)
    val snackbarHostState = remember { SnackbarHostState() }
    val notConnected = stringResource(R.string.not_connected)
    val entryProvider = entryProvider {
        InterestsEntry()
        BookmarkEntry()
    }
    val backStack = remember { mutableStateListOf<NavKey>(InterestsNavKey) }

    LaunchedEffect(isOnline) {
        if (!isOnline) {
            snackbarHostState.showSnackbar(
                message = notConnected,
                duration = Indefinite
            )
        }
    }
    CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = {
                SnackbarHost(
                    snackbarHostState,
                    modifier = Modifier.windowInsetsPadding(
                        WindowInsets.safeDrawing.exclude(
                            WindowInsets.ime,
                        ),
                    ),
                )
            }) { padding ->
            NavDisplay<NavKey>(
                entryProvider = entryProvider,
                modifier = Modifier.padding(padding),
                backStack = backStack,
                entryDecorators = listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator(),
                ),
            )

        }
    }
}

val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> {
    error(EMPTY_LOCAL_PROVIDER_MESSAGE)
}