package com.example.poemy.network

data class Poetry(
    val title : String,
    val author : String,
    val lines : List<String>,
    val linecount : Int
)