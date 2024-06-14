package com.example.tugasakhir

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.GrayLight500
import com.example.tugasakhir.ui.theme.PastelBlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.screen.HistoryScreen
import com.example.tugasakhir.view.screen.HomeScreen
import com.example.tugasakhir.view.screen.ItemScreen
import com.example.tugasakhir.view.screen.CartItemScreen
import com.example.tugasakhir.view.screen.DetailBarangScreen
import com.example.tugasakhir.view.screen.DetailCheckContent
import com.example.tugasakhir.view.screen.ReedemPointScreen
import com.example.tugasakhir.view.screen.WheelSpinScreen

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == Screen.Home.route ||
                currentRoute == Screen.Item.route ||
                currentRoute == Screen.History.route
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
                HomeScreen(
                    navigateToWheelspinScreen = { navController.navigate(Screen.Spinner.route) },
                    navigateToItemScreen = {navController.navigate(Screen.Item.route){
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        restoreState = true
                        launchSingleTop = true
                        }
                    }
                )
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
                DetailBarangScreen(
                    barangId = barangId,
                    image = image,
                    title = title,
                    navigateBack = {navController.navigateUp()},
                    navigateToCartItemScreen = {navController.navigate(Screen.Cart.route)})
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Cart.route) {
                CartItemScreen(
                    navigateBack = {navController.navigateUp()},
                    navigateToDetailCheckoutScreen = { navController.navigate(Screen.Checkout.route)}
                )
            }
            composable(Screen.Checkout.route) {
                DetailCheckContent(
                    navigateBack = {navController.navigateUp()},
                    navigateToReedemPointScreen = {navController.navigate(Screen.Reedem.route)}
                )
            }
            composable(Screen.Spinner.route) {
                WheelSpinScreen(
                    navigateBack = {navController.navigateUp()},
                )
            }
            composable(Screen.Reedem.route){
                ReedemPointScreen(
                    navigateBack = {navController.navigateUp()},
                    navigateToDetailCheckoutScreen = {navController.navigate(Screen.Checkout.route)}
                )
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
            .border(2.dp, PastelBlueColor500)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                iconSelected = painterResource(id = R.drawable.beranda),
                iconUnselected = painterResource(id = R.drawable.beranda_outline),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_barang),
                iconSelected = painterResource(id = R.drawable.delivery_full),
                iconUnselected = painterResource(id = R.drawable.delivery_outline),
                screen = Screen.Item
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_riwayat),
                iconSelected = painterResource(id = R.drawable.document_full),
                iconUnselected = painterResource(id = R.drawable.document_outline),
                screen = Screen.History
            ),

            )
        navigationItems.map { item ->
            val selected = currentRoute == item.screen.route
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = if (selected) item.iconSelected else item.iconUnselected,
                        contentDescription = item.title,
                        tint = if (selected) BlueColor500 else Color.LightGray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color =if (selected) BlueColor500 else Color.LightGray)
                },
                selected = selected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
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