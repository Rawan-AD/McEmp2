package sa.gov.mc.utility

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import sa.gov.mc.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")





@Composable
fun CustomButton(title: String, navController: NavController, route:String,modifier: Modifier,color:Color) {


        OutlinedButton(
            modifier =modifier.fillMaxWidth()



                .clip(Shapes.ExtraExtraSmall), onClick = {
                navController.navigate(route)

            },
            colors = ButtonDefaults.buttonColors(backgroundColor =color)
        )

        {
            Text(
                text = title,
                style = Typography.subtitle5,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
