package com.example.githubreposapp.ui.screens.common

data class RepoUiModel(
    val imageUrl : Int,
    val name : String,
    val language : String,
    val stars : Int,
    val forks : Int,
    val description : String,
)
