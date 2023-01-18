package sa.gov.mc.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sa.gov.mc.R
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import sa.gov.mc.ui.theme.Dark_Green
import sa.gov.mc.ui.theme.Larg_Medium
import sa.gov.mc.ui.theme.Shapes
import sa.gov.mc.ui.theme.subtitle5

@Composable
fun CardFactory(width: Dp,height:Dp,Image: Painter,title:String,subtitle:String,description:String,image2:Painter?) {


       return  Card(modifier = Modifier.size(170.dp,65.dp),shape= Shapes.Larg_Medium, elevation = 2.dp){

                       Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                       Image,
                                        contentDescription = null,modifier = Modifier

                                        .size(width, height)
                                        .absolutePadding( right = 14.dp))
                           Spacer(modifier = Modifier.width(9.3.dp))
                           Column(Modifier.absolutePadding(top=9.dp,left=8.dp)){

Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                           Text(title,style= MaterialTheme.typography.subtitle5)
                            Spacer(modifier = Modifier.width(3.dp))
                           Text(subtitle,style= MaterialTheme.typography.subtitle5,color= Dark_Green, fontWeight = FontWeight.Bold)}


                         Text(description,style=MaterialTheme.typography.subtitle5,fontSize=13.sp)
                }

                           if (image2 != null) {
                               Image(image2, contentDescription = null)
                           }
                       }
        }






}


