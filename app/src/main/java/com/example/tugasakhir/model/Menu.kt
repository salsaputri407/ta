package com.example.tugasakhir.model

data class Menu(
    val image: Int,
    val title: String,
)

val dummyMenu = listOf(
    Menu(com.example.tugasakhir.R.drawable.menu1, "Sepeda Listrik"),
    Menu(com.example.tugasakhir.R.drawable.menu2, "Mainan Anak"),
)