package sa.gov.mc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun McEmpTheme(content: @Composable () -> Unit) {

    // hide the status bar
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
        Color.Transparent
        )
    }


    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}