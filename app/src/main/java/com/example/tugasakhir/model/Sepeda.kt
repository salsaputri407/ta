package com.example.tugasakhir.model

data class Sepeda(
    val id: Long,
    val image: Int,
    val title: String,
)
val dummySepeda = listOf(
    Sepeda(1,com.example.tugasakhir.R.drawable.sepeda1, "Biru"),
    Sepeda(2,com.example.tugasakhir.R.drawable.sepeda2, "Orange"),
    Sepeda(3,com.example.tugasakhir.R.drawable.sepeda3, "Kuning"),
    Sepeda(4,com.example.tugasakhir.R.drawable.sepeda4, "Merah"),
    Sepeda(5,com.example.tugasakhir.R.drawable.sepeda5, "Biru Tua"),
    Sepeda(6,com.example.tugasakhir.R.drawable.sepeda6, "Hijau"),
)