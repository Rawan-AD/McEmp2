package sa.gov.mc.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import sa.gov.mc.R
import androidx.compose.ui.res.painterResource

import android.content.ContentValues
import android.os.Handler
import android.os.Looper
import android.util.Log


import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint

import sa.gov.mc.Screens


@Composable
fun SplashScreen(navController:NavHostController) {

    val scrollState = rememberScrollState()
    Log.d(ContentValues.TAG, "Splash: $scrollState")

    Box(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            SplashDesign()
            Handler(Looper.getMainLooper()).postDelayed({
              navigate(navController)
            }, 3000)
        }
    }
}

@Composable
fun SplashDesign() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // replace text with splash design


        Image(modifier = Modifier.fillMaxWidth(),
            painter= painterResource(id = R.drawable.splash),
            contentDescription = "splash",contentScale= ContentScale.FillWidth)
    }
}

fun navigate(navController: NavController) {
        navController.navigate(route = Screens.OnboardScreen.route)
}

//@Preview
//@Composable
//fun defaultPreview(){
//
//
//
//}
