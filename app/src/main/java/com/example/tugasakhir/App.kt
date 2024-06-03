package com.example.tugasakhir

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasakhir.navigation.NavigationItem
import com.example.tugasakhir.navigation.Screen
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.screen.history.HistoryScreen
import com.example.tugasakhir.view.screen.home.HomeScreen
import com.example.tugasakhir.view.screen.item_sepeda.ItemSepedaScreen

@Composable
fun App(
    modifier: Modifier =Modifier,
    navController : NavHostController = rememberNavController()
    ) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        innerPading->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPading)
        ){
            composable(Screen.Home.route){
                HomeScreen()
            }
            composable(Screen.Item.route){
                ItemSepedaScreen()
            }
            composable(Screen.History.route){
                HistoryScreen()
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier =Modifier
){
    NavigationBar (
        containerColor = Color.White,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_barang),
                icon = Icons.Default.Favorite,
                screen = Screen.Item
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_riwayat),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.History
            ),

        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector= item.icon,
                        contentDescription= item.title
                    )
                },
                label = {
                    Text(item.title)
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TugasAkhirreview() {
    TugasAkhirTheme {
        App()
    }
}