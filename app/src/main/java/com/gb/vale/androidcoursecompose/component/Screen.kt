package com.gb.vale.androidcoursecompose.component

const val ROOT_GRAPH_ROUTE = "root"

sealed class Screen (open val route: String) {
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object SplashScreen : Screen("splash_screen")


    fun withArgs(vararg args: String = emptyArray(), optional: Map<String, String?> = emptyMap()): String {
    return buildString {
            append(route)
            args.forEach { append("/$it") }

            if(optional.isNotEmpty()) {
                append("?")
            }

            optional.entries.forEachIndexed { index, map ->
                map.value?.let {
                    if(index != 0) append("&")

                    append("${map.key}=${map.value}")
                }
            }
        }
    }


}


