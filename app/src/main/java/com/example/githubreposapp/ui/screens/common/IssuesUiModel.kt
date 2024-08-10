package com.example.githubreposapp.ui.screens.common

data class IssuesUiModel(
    val title: String,
    val description: String,
    val date: Long,
    val issueUiState: IssueUiState = IssueUiState.Open
)
