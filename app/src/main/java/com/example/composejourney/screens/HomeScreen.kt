package com.example.composejourney.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composejourney.R
import com.example.composejourney.models.Category
import com.example.composejourney.models.Outlet
import com.example.composejourney.ui.theme.Blue_100
import com.example.composejourney.ui.theme.ComposeJourneyTheme
import com.example.composejourney.ui.theme.Light_80
import com.example.composejourney.ui.theme.Pink_12
import com.example.composejourney.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val categories: State<List<Category>> = homeViewModel.categories
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Good Evening Zohaib",
            style = MaterialTheme.typography.headlineMedium
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = "",
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = stringResource(R.string.search_food_restaurants_etc))
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Light_80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_normal),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp),
                    tint = Blue_100
                )
            },
            onValueChange = {

            },
        )

        HomeSection(title = R.string.categories) {
            CategoriesGrid(categories.value, homeViewModel.isLoading.value)
        }

        HomeSection(title = R.string.offers_near_your) {
            OfferItemList()
        }

        HomeSection(title = R.string.new_trending) {
            TrendingOutletList(homeViewModel.outlets.value, homeViewModel.isLoadingOutlet.value)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    ComposeJourneyTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()

        Divider(color = Light_80, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
    }
}


val categories = listOf(
    Category("Burgers", R.drawable.burgers),
    Category("Grocery", R.drawable.grocery),
    Category("Salads", R.drawable.salads),
    Category("Sweets", R.drawable.sweets),
    Category("Utensils", R.drawable.utensils),
    Category("Salads", R.drawable.salads),
    Category("Sweets", R.drawable.sweets),
    Category("Utensils", R.drawable.utensils),
)

@Composable
fun CategoriesGrid(categories: List<Category>, isLoading: Boolean) {
    Box(
        Modifier
            .height(220.dp)
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .height(220.dp)

            ) {
                items(categories) {
                    CategoryItem(it)
                }
                item {
                    Text(text = "See all")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoriesGridPreview() {
    CategoriesGrid(categories = categories, isLoading = false)
}

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape, color = Pink_12, modifier = modifier
            .size(103.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = category.iconId),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            Text(
                text = category.name,
                style = TextStyle(fontSize = 12.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    CategoryItem(Category("Burgers", R.drawable.burgers))
}

@Composable
fun OffersItem(@DrawableRes imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .width(315.dp)
            .height(180.dp)
            .padding(start = 8.dp, end = 8.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun OfferItemPreview() {
    OffersItem(R.drawable.rectangle_burgers)
}


@Composable
fun OfferItemList() {
    LazyRow {
        item {
            OffersItem(R.drawable.rectangle_burgers)
        }
        item {
            OffersItem(R.drawable.kfc_banner)
        }
        item {
            OffersItem(R.drawable.rectangle_burgers)
        }
        item {
            OffersItem(R.drawable.rectangle_burgers)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OfferItemListPreview() {
    OfferItemList()
}

@Composable
fun TrendingOutletList(outlets: List<Outlet>, isLoading: Boolean) {

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        if (isLoading) {
            CircularProgressIndicator()
        }
        LazyRow {
            items(outlets) {
                TrendingOutletListItem(offerImage = it.cover, logo = it.logo, outletName = it.name)
            }
        }
    }

}

@Composable
fun TrendingOutletListItem(
    @DrawableRes offerImage: Int,
    @DrawableRes logo: Int,
    outletName: String
) {

    Column (modifier = Modifier.height(160.dp).width(260.dp)) {
        Image(
            painter = painterResource(id = offerImage),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .height(115.dp)
                .padding(start = 8.dp, end = 8.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = null,
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(text = outletName, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "2.1 mi",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun TrendingOutletListItemPreview() {
    TrendingOutletListItem(R.drawable.kfc_banner, R.drawable.kfc, "KFC")
}