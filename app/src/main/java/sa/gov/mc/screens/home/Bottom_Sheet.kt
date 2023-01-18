package sa.gov.mc.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import sa.gov.mc.screens.jobs.EmpJob


sealed class BottomSheetScreen (){
    object VocationRequest: BottomSheetScreen()
    object EmpJob: BottomSheetScreen()
}

@Composable
fun SheetLayout(currentScreen: BottomSheetScreen,onCloseBottomSheet :()->Unit,navController: NavController) {
    BottomSheetWithCloseDialog(onCloseBottomSheet){
        when(currentScreen){
            BottomSheetScreen.VocationRequest-> VocationRequest(navController)
            BottomSheetScreen.EmpJob-> EmpJob(navController)

        }

    }
}

@Composable
fun BottomSheetWithCloseDialog(
    onClosePressed: () -> Unit,
    modifier: Modifier = Modifier,
    closeButtonColor: Color = Color.Gray,
    content: @Composable() () -> Unit
) {
    Box(modifier.fillMaxWidth()) {
        content()

        IconButton(
            onClick = onClosePressed,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(29.dp)

        ) {
            Icon(Icons.Filled.Close, tint = closeButtonColor, contentDescription = null)
        }

    }
}


