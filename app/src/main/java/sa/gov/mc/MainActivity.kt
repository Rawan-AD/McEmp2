package sa.gov.mc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import sa.gov.mc.screens.contacts.ContactsScreen
import sa.gov.mc.screens.login.LoginScreen
import sa.gov.mc.screens.login.OptScreen
import sa.gov.mc.screens.news.NewsUI
import sa.gov.mc.screens.profile.ProfileUi
import sa.gov.mc.ui.theme.GrayBackground
import sa.gov.mc.ui.theme.McEmpTheme
import sa.gov.mc.utility.BottomBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // TODO 2: declare a var
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            McEmpTheme {
//Modifier.background(GrayBackground)
                var bottomState by remember { mutableStateOf("Home") }

                // TODO 3: to remember which screen
                navController = rememberNavController()

                // TODO 5: Navigation setup
                SetupNavGraph(navController = navController)




            }
        }
    }
    
}