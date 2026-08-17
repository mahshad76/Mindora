package com.mahshad.impl

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.mahshad.api.navigation.InterestsNavKey


@Composable
fun EntryProviderScope<NavKey>.InterestsEntry() {
    entry(InterestsNavKey) {
        InterestsScreen()
    }
}

@Composable
private fun InterestsScreen() {
    Text("InterestsScreen")
}