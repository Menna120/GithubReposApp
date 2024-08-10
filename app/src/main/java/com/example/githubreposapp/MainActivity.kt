package com.example.githubreposapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.githubreposapp.ui.screens.common.IssuesUiModel
import com.example.githubreposapp.ui.screens.common.RepoAppBar
import com.example.githubreposapp.ui.screens.common.RepoScreen
import com.example.githubreposapp.ui.screens.common.RepoUiModel
import com.example.githubreposapp.ui.screens.detailsScreen.DetailsScreen
import com.example.githubreposapp.ui.screens.homeScreen.HomeScreen
import com.example.githubreposapp.ui.screens.issueScreen.IssuesScreen
import com.example.githubreposapp.ui.theme.GithubReposAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubReposAppTheme(dynamicColor = false) {
                RepoApp()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun RepoApp(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = RepoScreen.valueOf(
        backStackEntry?.destination?.route ?: RepoScreen.HOME.name
    )

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        RepoAppBar(
            title = currentScreen.title,
            showBackButton = navController.previousBackStackEntry != null,
            onBackButtonClicked = { navController.navigateUp() })
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RepoScreen.HOME.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = RepoScreen.HOME.name) {
                HomeScreen(onNavToDetailsClicked = { navController.navigate(RepoScreen.DETAILS.name) })
            }
            composable(route = RepoScreen.DETAILS.name) {
                DetailsScreen(
                    repo = RepoUiModel(
                        imageUrl = R.drawable.google,
                        name = "language",
                        language = "Python",
                        stars = 1525,
                        forks = 347,
                        description = "Shared repository for open-sourced projects from the Google AI Language team."
                    ),
                    onShowIssuesClicked = { navController.navigate(RepoScreen.ISSUES.name) }
                )
            }
            composable(route = RepoScreen.ISSUES.name) {
                IssuesScreen(
                    issuesList = listOf(
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        ),
                        IssuesUiModel(
                            title = "Bump pyarrow from 7 Bump pyarrow from 7",
                            description = "NONE",
                            date = 1678886400000
                        )
                    ),
                    onIssuesCardClicked = {}
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GithubReposAppTheme {
        RepoApp()
    }
}