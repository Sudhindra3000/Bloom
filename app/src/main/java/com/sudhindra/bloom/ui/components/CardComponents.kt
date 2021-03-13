package com.sudhindra.bloom.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sudhindra.bloom.models.GardenTheme
import com.sudhindra.bloom.models.ThemeInfo
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ThemeCard(
    themeInfo: ThemeInfo
) {
    Card(
        Modifier
            .padding(10.dp)
            .clickable {},
        shape = MaterialTheme.shapes.small
    ) {
        Column {
            CoilImage(
                modifier = Modifier.size(width = 160.dp, height = 136.dp),
                data = themeInfo.imageUrl,
                contentDescription = "",
                fadeIn = true,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = themeInfo.name,
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Composable
fun GardenThemeCard(
    gardenTheme: GardenTheme
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(64.dp)
    ) {
        CoilImage(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .size(64.dp),
            data = gardenTheme.imageUrl,
            contentDescription = "",
            fadeIn = true,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(10.dp))
        Column(
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.padding(start = 10.dp)) {
                    Text(
                        text = gardenTheme.title,
                        style = MaterialTheme.typography.h2
                    )

                    Text(
                        text = gardenTheme.description,
                        style = MaterialTheme.typography.body1
                    )
                }
                Checkbox(
                    checked = gardenTheme.checked,
                    onCheckedChange = { },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colors.background
                    )
                )
            }

            Divider(thickness = 2.dp)
        }
    }
}
