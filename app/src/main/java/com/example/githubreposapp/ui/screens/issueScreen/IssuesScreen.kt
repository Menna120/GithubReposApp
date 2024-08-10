package com.example.githubreposapp.ui.screens.issueScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.common.IssuesUiModel
import com.example.githubreposapp.ui.theme.GithubReposAppTheme

@Composable
fun IssuesScreen(
    issuesList: List<IssuesUiModel>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentPadding: PaddingValues = PaddingValues(dimensionResource(R.dimen.small_padding)),
    onIssuesCardClicked: () -> Unit
) {
    LazyColumn(
        modifier = modifier.background(color = backgroundColor),
        contentPadding = contentPadding
    ) {
        items(issuesList) { item ->
            IssuesCard(
                issueItem = item,
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.small_padding),
                        horizontal = dimensionResource(R.dimen.medium_padding)
                    ),
                onIssuesCarsClicked = onIssuesCardClicked
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun IssuesScreenPreview() {
    GithubReposAppTheme {
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
                )
            ),
            onIssuesCardClicked = {}
        )
    }
}