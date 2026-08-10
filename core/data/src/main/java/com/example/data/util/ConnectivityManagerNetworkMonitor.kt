package com.example.data.util

import kotlinx.coroutines.flow.Flow

class ConnectivityManagerNetworkMonitor(override val isOnline: Flow<Boolean>) : NetworkMonitor {
}