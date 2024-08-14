package com.example.yujie.movie_module



import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.yujie.Major.MajorViewModel
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yujie.DetailPage
import com.example.yujie.Legend.CinemaPage
import com.example.yujie.Legend.ComingSoonPage
import com.example.yujie.Legend.DetailPageLegend
import com.example.yujie.Legend.FBPage
import com.example.yujie.Legend.FoodPage
//import com.example.yujie.Legend.FoodPage
import com.example.yujie.Legend.LegendBody

import com.example.yujie.Legend.LegendViewModel
import com.example.yujie.Legend.OfferPage
import com.example.yujie.Legend.SearchPage
import com.example.yujie.Legend.SettingPage
import com.example.yujie.Legend.User


import com.example.yujie.R
import com.example.yujie.model.FoodItems
import com.example.yujie.model.OfferItem
import com.example.yujie.model.OfferItems
import com.example.yujie.model.cinemaItems
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LegendScaffold(vm: LegendViewModel, navController: NavHostController, legendViewModel: LegendViewModel) {
    var expanded by remember { mutableStateOf(false) }
    Scaffold(


        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = {
                                navController.navigate("home")
                            }
                        ) {
                            Icon(
                                Icons.Rounded.Home,
                                contentDescription = "Home",
                                tint = Color.White
                            )
                        }
                        Text("Home", color = Color.White)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = {
                                navController.navigate("offer")
                            }
                        ) {
                            Icon(
                                Icons.Rounded.LocalOffer,
                                contentDescription = "Offer",
                                tint = Color.White
                            )
                        }
                        Text("Offer", color = Color.White)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = {
                                navController.navigate("cinema")
                            }
                        ) {
                            Icon(
                                Icons.Rounded.LocationOn,
                                contentDescription = "Cinema",
                                tint = Color.White
                            )
                        }
                        Text("Cinema", color = Color.White)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = {
                                navController.navigate("F&B")
                            }
                        ) {
                            Icon(
                                Icons.Rounded.Fastfood,
                                contentDescription = "F&B",
                                tint = Color.White
                            )
                        }
                        Text("F&B", color = Color.White)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = {
                                navController.navigate("setting")
                            }
                        ) {
                            Icon(
                                Icons.Rounded.Settings,
                                contentDescription = "Settings",
                                tint = Color.White
                            )
                        }
                        Text("Settings", color = Color.White)
                    }
                }
            }
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    LegendBody(vm, navController)
                }
                composable("coming_soon") {
                    ComingSoonPage(vm,navController = navController)
                }
                composable("userScreenRoute") { User(navController) }

                composable("search") {
                    val viewModel: LegendViewModel = viewModel()
                    LaunchedEffect(Unit) {
                        viewModel.getResultList()
                    }
                    SearchPage(
                        navController = navController,
                        viewModel = viewModel,
                        movies = viewModel.resultList
                    )
                }

                composable("notification") {
                    NotificationPage(navController = navController)
                }
                composable(
                    route = "detail/{movieId}",
                    arguments = listOf(navArgument("movieId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
                    DetailPageLegend(vm = legendViewModel, nc = navController, movieId = movieId)
                }
                composable("Nowshowing") {
                    NowShowingPage(navController = navController)
                }
                composable("offer") {
                    OfferPage(navController = navController, offerItems = OfferItems)
                }
                composable("cinema") {
                    CinemaPage(navController = navController)
                }
                composable("F&B") {
                    FBPage(navController = navController, cinemaItems = cinemaItems)
                }
                composable("food") {
                    FoodPage(navController = navController, FoodItems = FoodItems)
                }
                composable("setting") {
                    SettingPage(navController = navController)
                }
            }
        }


    }

}








@Composable
fun NowShowingPage(navController: NavHostController) {

}





@Composable
fun NotificationPage(navController: NavController) {

}

@Composable
fun MonthBox( month: String, borderColor: Color = Color.Gray) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 30.dp) // Fixed small size
            .background(Color.Black, shape = RoundedCornerShape(4.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(4.dp)) // Use borderColor parameter
            .padding(4.dp) // Adjust padding inside the box
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = month,
                fontSize = 14.sp, // Small font size
                color = Color.White
            )
        }
    }
}


@Composable
fun DateBox(dayOfWeek: String, day: Int, month: String, borderColor: Color = Color.Gray) {
    Box(
        modifier = Modifier
            .size(width = 60.dp, height = 80.dp) // Fixed small size
            .background(Color.Black, shape = RoundedCornerShape(4.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(4.dp)) // Use borderColor parameter
            .padding(4.dp) // Adjust padding inside the box
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = dayOfWeek,
                fontSize = 14.sp, // Small font size
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = day.toString(),
                fontSize = 18.sp, // Small font size
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = month,
                fontSize = 14.sp, // Small font size
                color = Color.White
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun composeTopBar(navController: NavController, vm: LegendViewModel) {
    CenterAlignedTopAppBar(
        title = {
            Text("Legend", color = Color.White)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
        actions = {
            IconButton(
                onClick = {
                    navController.navigate("search")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    vm.getResultList()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notification",
                    tint = Color.White
                )
            }
        }
    )
}
