package com.example.poemy.network

data class Poetry(
    val title : String,
    val author : String,
    val lines : List<String>,
    val linecount : Int
)

data class Poetry1(
    val title1 : String,
    val author1 : String,
    val lines1 : List<String>,
    val linecount1 : Int
)