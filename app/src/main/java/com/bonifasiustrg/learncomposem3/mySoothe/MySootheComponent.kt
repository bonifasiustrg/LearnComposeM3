package com.bonifasiustrg.learncomposem3.mySoothe

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.learncomposem3.R
import com.bonifasiustrg.learncomposem3.mySoothe.ui.theme.MySootheTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        value = "",
        onValueChange = {},
        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.surface),
        placeholder = { Text("Search here...")},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null)},
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int/*drawable: Int*/,
    @StringRes text: Int /*text: String*/,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text) /*text*/,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    NavigationBar(modifier, containerColor = MaterialTheme.colorScheme.background) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null)},
            label = { Text(text = "HOME")},
            selected = isSelected,
            onClick = { /*TODO*/ }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null)},
            label = { Text(text = "PROFILE")},
            selected = isSelected,
            onClick = { /*TODO*/ }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun MySoothePrev() {
    MySootheTheme {
//    SearchBar()

        /*AlignYourBodyElement(
            text = R.string.nature_meditations,
            drawable = R.drawable.align_your_body_1,
            modifier = Modifier.padding(8.dp)
        )*/

        /*FavoriteCollectionCard(
            text = R.string.nature_meditations,
            drawable = R.drawable.news_img4,
            modifier = Modifier.padding(8.dp)
        )*/

        SootheBottomNavigation()
    }


}