package com.example.tugasakhir.model

import com.example.tugasakhir.R

data class Mainan(
    val id: Long,
    val image: Int,
    val title: String,
)
val dummyMainan = listOf(
    Mainan(1, R.drawable.mainan1, "Jeep Merah") ,
    Mainan(2,R.drawable.mainan2, "Jeep Putih"),
    Mainan(3,R.drawable.mainan3, "Jeep Hitam"),
    Mainan(4,R.drawable.mainan4, "Motor Merah"),
    Mainan(5,R.drawable.mainan5, "Motor Putih"),
    Mainan(6,R.drawable.mainan6, "Motor Hitam"),
)