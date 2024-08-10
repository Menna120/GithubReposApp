package com.example.githubreposapp.ui.screens.issueScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.common.IssueUiState
import com.example.githubreposapp.ui.screens.common.IssuesUiModel
import com.example.githubreposapp.ui.theme.GithubReposAppTheme


@Composable
fun IssuesCard(
    issueItem: IssuesUiModel,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    contentPadding: Dp = dimensionResource(R.dimen.medium_padding),
    icon: Painter = painterResource(R.drawable.circle_dot),
    iconSize: Dp = dimensionResource(R.dimen.icon_size_36),
    elevation: Dp = dimensionResource(R.dimen.card_elevation),
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    descriptionStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    dateStyle: TextStyle = MaterialTheme.typography.labelLarge,
    stateStyle: TextStyle = MaterialTheme.typography.titleMedium,
    onIssuesCarsClicked: () -> Unit
) {
    ElevatedCard(
        onClick = onIssuesCarsClicked,
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(elevation),
    ) {
        Row(
            modifier = Modifier
                .background(color)
                .fillMaxWidth()
                .padding(contentPadding),
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                Modifier.size(iconSize)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        horizontal = dimensionResource(R.dimen.large_padding),
                        vertical = dimensionResource(R.dimen.small_padding),
                    )
            ) {
                Text(
                    text = issueItem.title,
                    style = titleStyle,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = issueItem.description,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.medium_padding),
                        bottom = dimensionResource(R.dimen.large_padding)
                    ),
                    style = descriptionStyle,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.wrapContentWidth(align = Alignment.Start, unbounded = true)
                ) {
                    Text(
                        text = "Created At: ",
                        style = dateStyle
                    )
                    Text(
                        text = formatDate(issueItem.date),
                        style = dateStyle,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Text(
                text = issueItem.issueUiState.name,
                modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding)),
                style = stateStyle
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun IssuesCardPreview() {
    GithubReposAppTheme {
        IssuesCard(
            issueItem = IssuesUiModel(
                title = "Bump pyarrow from 7 Bump pyarrow from 7",
                description = "None",
                date = 1699563600000,
                issueUiState = IssueUiState.Open
            ),
            modifier = Modifier.padding(dimensionResource(R.dimen.large_padding)),
            onIssuesCarsClicked = {}
        )
    }
}