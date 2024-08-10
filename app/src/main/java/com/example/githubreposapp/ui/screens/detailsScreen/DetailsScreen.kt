package com.example.githubreposapp.ui.screens.detailsScreen


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.githubreposapp.R
import com.example.githubreposapp.ui.screens.common.RepoUiModel
import com.example.githubreposapp.ui.theme.GithubReposAppTheme


@Composable
fun DetailsScreen(
    repo: RepoUiModel,
    modifier: Modifier = Modifier,
    contentPadding: Dp = dimensionResource(id = R.dimen.extra_large_padding),
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    imageSize: Dp = dimensionResource(id = R.dimen.image_size),
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    buttonTextStyle: TextStyle = MaterialTheme.typography.titleLarge,
    buttonShape: Shape = MaterialTheme.shapes.small,
    buttonBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    descriptionStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    onShowIssuesClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(contentPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = repo.imageUrl),
            contentDescription = repo.name,
            modifier = Modifier.size(imageSize)
        )
        Text(
            text = repo.name,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.extra_large_padding)),
            color = MaterialTheme.colorScheme.onBackground,
            style = titleStyle
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(FILL_WIDTH_FRACTION_9)
                .padding(bottom = dimensionResource(id = R.dimen.extra_large_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DetailsScreenItem(
                text = repo.stars.toString(),
                textStyle = descriptionStyle,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = repo.stars.toString() + " stars",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_40)),
                        tint = Color.Yellow
                    )
                }
            )
            DetailsScreenItem(
                text = repo.language,
                textStyle = descriptionStyle,
                icon = {
                    Canvas(modifier = Modifier.size(dimensionResource(id = R.dimen.circle_icon_size))) {
                        drawCircle(color = Color.Blue)
                    }
                }
            )
            DetailsScreenItem(
                text = repo.forks.toString(),
                textStyle = descriptionStyle,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.repo_forked),
                        contentDescription = repo.forks.toString() + " forks",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_40)),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            )
        }
        Text(
            text = repo.description,
            modifier = Modifier.fillMaxWidth(FILL_WIDTH_FRACTION_9),
            color = MaterialTheme.colorScheme.onBackground,
            style = descriptionStyle,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.weight(FILL_MAX_WIDTH_FRACTION))
        Button(
            onClick = onShowIssuesClicked,
            modifier = Modifier.fillMaxWidth(FILL_WIDTH_FRACTION_9),
            shape = buttonShape,
            colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroundColor)
        ) {
            Text(
                text = stringResource(R.string.show_issues),
                style = buttonTextStyle
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    GithubReposAppTheme {
        DetailsScreen(
            repo = RepoUiModel(
                imageUrl = R.drawable.google,
                name = "language",
                language = "Python",
                stars = 1525,
                forks = 347,
                description = "Shared repository for open-sourced projects from the Google AI Language team."
            ),
            onShowIssuesClicked = {}
        )
    }
}