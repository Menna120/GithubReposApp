package com.example.githubreposapp.ui.screens.common

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.theme.GithubReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun RepoAppBar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    color: Color = MaterialTheme.colorScheme.surface,
    elevation: Dp = dimensionResource(R.dimen.top_app_bar_elevation),
    showBackButton: Boolean = true,
    onBackButtonClicked: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(title),
                style = titleStyle,
            )
        },
        modifier = modifier.shadow(elevation),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = color),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_arrow)
                    )
                }
            }
        }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewRepoAppBar() {
    GithubReposAppTheme {
        RepoAppBar(title = R.string.details) {

        }
    }
}