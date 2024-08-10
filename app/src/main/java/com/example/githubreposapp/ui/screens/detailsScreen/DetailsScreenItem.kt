package com.example.githubreposapp.ui.screens.detailsScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubreposapp.R

@Composable
fun DetailsScreenItem(
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    icon: @Composable (() -> Unit)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            style = textStyle,
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.small_padding)),
            color = MaterialTheme.colorScheme.onBackground
        )
        icon()
    }
}


@Preview(showBackground = true)
@Composable
private fun StarsItemPreview() {
    DetailsScreenItem(
        text = "1525",
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.star),
                tint = Color.Yellow,
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_40))
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun LanguageItemPreview() {
    DetailsScreenItem(
        text = "Python",
        icon = {
            Canvas(modifier = Modifier.size(dimensionResource(id = R.dimen.circle_icon_size))) {
                drawCircle(color = Color.Blue)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ForkItemPreview() {
    DetailsScreenItem(
        text = "347",
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.repo_forked),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_40))
            )
        }
    )
}