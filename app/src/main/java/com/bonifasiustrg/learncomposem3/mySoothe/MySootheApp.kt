package com.bonifasiustrg.learncomposem3.mySoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.learncomposem3.R
import com.bonifasiustrg.learncomposem3.mySoothe.ui.theme.MySootheTheme
import java.util.*

class MySootheApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShootheApp(modifier: Modifier=Modifier) {
    MySootheTheme() {
        Scaffold(bottomBar = { SootheBottomNavigation()}) {paddingValues ->
            Column(modifier.padding(paddingValues).verticalScroll(rememberScrollState())  //can scroll if home have many items
            ) {
                Spacer(Modifier.height(16.dp))
                SearchBar(Modifier.padding(horizontal = 16.dp))
                HomeSection(title = R.string.align_your_body) {
                    AlignYourBodyRow()
                }
                HomeSection(title = R.string.favorite_collection) {
                    FavoriteCollectionsGrid()
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }


}

// SLOT API (alignyourbody and favoritecollection have tha same pattern)
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier.background(Color.Gray)) {
        items(ShootheMockData.alignYourBodyDataLists) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {

    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .height(120.dp)
            .background(Color.Gray)
            .padding(vertical = 4.dp)
    ) {
        items(ShootheMockData.favoriteCollectionsDataList) {
            FavoriteCollectionCard(drawable = it.drawable, text = it.text,  modifier = Modifier.height(56.dp))
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySootheTheme {
//        AlignYourBodyRow()
//        FavoriteCollectionsGrid()
        ShootheApp()
    }
}