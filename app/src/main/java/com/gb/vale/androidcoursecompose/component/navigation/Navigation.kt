package com.gb.vale.androidcoursecompose.component.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gb.vale.androidcoursecompose.component.ROOT_GRAPH_ROUTE
import com.gb.vale.androidcoursecompose.component.Screen
import com.gb.vale.androidcoursecompose.ui.init.login.ScreenLogin
import com.gb.vale.androidcoursecompose.ui.init.register.ScreenRegister
import com.gb.vale.androidcoursecompose.ui.init.splash.ScreenSplash

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        route = ROOT_GRAPH_ROUTE) {

        composable(route = Screen.SplashScreen.route) {
            ScreenSplash(hiltViewModel(), navController = navController)
        }

        composable(route = Screen.LoginScreen.route) {
          ScreenLogin(hiltViewModel(),navController)
        }

        composable(route = Screen.RegisterScreen.route) {
            ScreenRegister(hiltViewModel(),navController) }
    }

}