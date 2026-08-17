package com.mahshad.impl

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.mahshad.api.navigation.BookmarkNavKey

@Composable
fun EntryProviderScope<NavKey>.BookmarkEntry() {
    entry(BookmarkNavKey) {
        BookmarkScreen()
    }
}

@Composable
private fun BookmarkScreen() {
    Text("BookmarkScreen")
}