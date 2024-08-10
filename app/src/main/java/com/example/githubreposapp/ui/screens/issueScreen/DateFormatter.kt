package com.example.githubreposapp.ui.screens.issueScreen

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(date: Long): String =
    SimpleDateFormat("yyyy-MM-dd, HH:mm a", Locale.getDefault()).format(Date(date))