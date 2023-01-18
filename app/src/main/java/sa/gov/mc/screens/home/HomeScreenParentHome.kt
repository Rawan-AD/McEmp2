package sa.gov.mc.screens.home

import android.annotation.SuppressLint
import androidx.annotation.RestrictTo
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

import sa.gov.mc.screens.chat.ChatUI
import sa.gov.mc.screens.contacts.ContactsScreen
import sa.gov.mc.screens.news.NewsUI
import sa.gov.mc.screens.profile.ProfileUi
import sa.gov.mc.utility.BottomBar
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@OptIn(ExperimentalPagerApi::class)
@Composable
 fun HomeScreenParentHome (navController: NavController){
    var bottomState by remember { mutableStateOf("Home") }
    val pagerState = rememberPagerState()
    Scaffold(
        modifier = Modifier

            .background(Gray),
        content = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

                HomeScreen(navController = navController)
                
                
                
                if(bottomState.equals("بياناتي")){
                    ProfileUi(navController)
                } else if(bottomState.equals("دردشة")){
                    ChatUI(navController  )
                }
                else if(bottomState.equals("اخبار")){
                    NewsUI(navController)
                }
                else if(bottomState.equals("الدليل")){
                    ContactsScreen(navController)
                }
                else if(bottomState.equals("الرئيسية")){
                    HomeScreen(navController )

                }





            }},
        bottomBar = {
           BottomBar({bottomState=it},bottomState)
        }
    )

}




