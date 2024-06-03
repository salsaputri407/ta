package com.example.tugasakhir.navigation

sealed class Screen (val route: String){
    object Home : Screen("home")
    object Item : Screen ("item")
    object ItemSepeda : Screen ("itemsepeda")
    object ItemMainan : Screen ("itemmainan")
    object Detail : Screen ("detail")
    object Keranjang : Screen ("keranjang")
    object Checkout : Screen ("checkout")
    object Timer : Screen ("timer")
    object Spinner : Screen ("spinner")
    object Badge : Screen ("badge")
    object History : Screen ("history")
}