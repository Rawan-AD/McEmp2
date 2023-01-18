package sa.gov.mc.utility

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sa.gov.mc.ui.theme.*

@Composable
fun AppBar (title:String,subTitle:String,navController: NavController,route:String){
    Card(    modifier = Modifier
        .fillMaxWidth()
        .padding(9.dp)

        .height(48.dp), elevation = 6.dp, backgroundColor = White,

    )
    {


        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp)
                .height(45.dp)
        ) {
            Icon(

                Icons.Default.KeyboardArrowRight, tint = Medium_Gray,
                contentDescription = "image_back", modifier = Modifier.clickable { navController.navigate(route)}

                )

            Text(
                text = "عودة",
                fontFamily = frutiger,
                textAlign = TextAlign.Left,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Medium_Gray
            )

Spacer(Modifier.width(70.dp))
                Text(
                    text = title,
                    fontFamily = frutiger,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,


                    )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = subTitle,
                    fontFamily = frutiger,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark_Green
                )
            }


        }

}

@Preview
@Composable
fun defaultPreview8(){
//   AppBar ("ggg","gggg")
}