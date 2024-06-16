package com.example.tugasakhir.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Item : Screen("item")

    data object Detail : Screen("item/{barangId}-{image}-{title}") {
        fun createRoute(barangId: Long, image: Int, title: String) =
            "item/$barangId-$image-$title"
    }

    data object Cart : Screen("cart")

    data object Checkout : Screen("checkout")

    data object Reedem : Screen("reedem")

    data object Timer : Screen("timer/{durationText}") {
        fun createRoute(durationText: String) =
            "timer/$durationText"
    }

    data object Spinner : Screen("spinner")

    data object Badge : Screen("badge")

    data object History : Screen("history")
}