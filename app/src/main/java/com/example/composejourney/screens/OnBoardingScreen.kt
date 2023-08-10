package com.example.composejourney.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composejourney.AppNavigator
import com.example.composejourney.composables.AppButton
import com.example.composejourney.composables.onBoarding
import com.example.composejourney.models.OnBoardingInfo
import kotlinx.coroutines.launch

val pagerData = listOf(
    OnBoardingInfo(
        "Wide range of Food Categories & more",
        "Browse through our extensive list of restaurants and dishes, and when you're ready to order, simply add your desired items to your cart and checkout. It's that easy!"
    ),
    OnBoardingInfo(
        "Free Deliveries for ONE MONTH!!",
        "Get your favorite meals delivered to your doorstep for free with our online food delivery app - enjoy a whole month of complimentary delivery!"
    ),
    OnBoardingInfo(
        "Get started on Ordering your Food",
        "Please create an account or sign in to your existing account to start browsing our selection of delicious meals from your favorite restaurants."
    )
)

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun OnBoardingScreen(navController: NavController) {
    val pageIndex = remember {
        mutableStateOf(0)
    }
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            pageCount = pagerData.size,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            state = pagerState
        ) { pagerIndex ->
            pageIndex.value = pagerIndex
            onBoarding(
                pagerData[pagerIndex].title,
                pagerData[pagerIndex].body,
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalArrangement = Arrangement.Center
        ) {
            AppButton(
                "Skip", modifier = Modifier
                    .height(50.dp)
                    .weight(1f), hideIcon = false
            ) {
                scope.launch {
                    navController.navigate(AppNavigator.Routes.AUTHENTICATION)
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
            AppButton(
                "Next", modifier = Modifier
                    .height(50.dp)
                    .weight(1f),
                hideIcon = false
            ) {
                scope.launch {
                    if (pageIndex.value == pagerData.size) {
                    } else {
                        pageIndex.value = pageIndex.value + 1
                    }
                    pagerState.animateScrollToPage(pageIndex.value)
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview() {
    //OnBoardingScreen()
}