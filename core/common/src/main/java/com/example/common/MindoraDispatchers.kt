package com.example.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME


@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val mindoraDispatcher: MindoraDispatchers)

enum class MindoraDispatchers {
    IO,
    MAIN,
    DEFAULT
}

