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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasakhir.model.NavigationItem
import com.example.tugasakhir.navigation.Screen
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.screen.HistoryScreen
import com.example.tugasakhir.view.screen.HomeScreen
import com.example.tugasakhir.view.screen.ItemScreen
import com.example.tugasakhir.view.screen.CartItemContent
import com.example.tugasakhir.view.screen.CartItemScreen
import com.example.tugasakhir.view.screen.DetailBarangScreen
import com.example.tugasakhir.view.screen.DetailCheckContent

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route &&
                currentRoute != Screen.Cart.route &&
                currentRoute != Screen.Checkout.route &&
                currentRoute != Screen.Reedem.route
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPading ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPading)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Item.route) {
                ItemScreen(
                    navigateToDetailItemScreen = { barangId, image, title ->
                        navController.navigate(Screen.Detail.createRoute(barangId, image, title))
                    },
                    navigateToCartItemScreen = { navController.navigate(Screen.Cart.route) }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("barangId") { type = NavType.LongType },
                    navArgument("image") { type = NavType.IntType },
                    navArgument("title") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val barangId = backStackEntry.arguments?.getLong("barangId")
                val image = backStackEntry.arguments?.getInt("image")
                val title = backStackEntry.arguments?.getString("title")
                DetailBarangScreen(barangId = barangId, image = image, title = title)
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Cart.route) {
                CartItemScreen(
                    navigateToDetailCheckoutScreen = { navController.navigate(Screen.Checkout.route) }
                )
            }
            composable(Screen.Checkout.route) {
                DetailCheckContent()
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
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
                        imageVector = item.icon,
                        contentDescription = item.title
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