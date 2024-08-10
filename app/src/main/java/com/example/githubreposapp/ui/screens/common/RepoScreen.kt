package com.example.githubreposapp.ui.screens.common

import androidx.annotation.StringRes
import com.example.githubreposapp.R

enum class RepoScreen(@StringRes val title: Int) {
    HOME(title = R.string.home),
    DETAILS(title = R.string.details),
    ISSUES(title = R.string.issues)
}
