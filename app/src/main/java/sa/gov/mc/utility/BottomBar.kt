package sa.gov.mc.utility

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import sa.gov.mc.R
import sa.gov.mc.ui.theme.GrayBackground
import sa.gov.mc.ui.theme.Text_Gray


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomBar( onclick:(String)->Unit,bottomState:String) {
    BottomAppBar(modifier = Modifier.background(Transparent),
//        contentColorFor(backgroundColor = GrayBackground ),
        colorResource(id = R.color.GrayBackground)) {


    var bottomState by remember { mutableStateOf("الرئيسية") }

    BottomNavigation(
elevation=5.dp,
        backgroundColor =White,
        contentColor = Color(0xfff999999),
        modifier = Modifier
            .background(GrayBackground)

            .clip(
                shape = RoundedCornerShape(
                  30.dp
                )
            )
    ) {


        BottomNavigationItem(
            selected =bottomState== "بيناتي",
            onClick = {
                onclick("بياناتي")

            },
            label = { Text(text = "بياناتي",color=Text_Gray) },
            icon = {
             Icon(
                  painter=  painterResource(id = R.drawable.icon_feather_user),
                    contentDescription = null)

            },

            )

        BottomNavigationItem(selected = bottomState == "دردشة", onClick = {
            onclick("دردشة")
        },
            label = { Text(text = "دردشة",color=Text_Gray) },
            icon = {
                Icon(
                   painter= painterResource(id = R.drawable.icon_material_chat_bubble_outline),
                    contentDescription = null
                )
            }
        )

        BottomNavigationItem(selected = bottomState == "اخبار", onClick = {
            onclick("اخبار")
        },
            label = { Text(text = "اخبار", color = Text_Gray) },
            icon = {
                Icon(
                   painter= painterResource(id = R.drawable.mc_news ),
                    contentDescription = null
                )

            }
        )


        BottomNavigationItem(selected = bottomState == "الدليل", onClick = {
//
            onclick("الدليل")
        },
            label = { Text(text = "الدليل",color=Text_Gray) },
            icon = {
                Icon(
                   painter= painterResource(id = R.drawable.icon_awesome_address_book),
                    contentDescription = null
                )
            }
        )
        BottomNavigationItem(selected = bottomState == "الرئيسية", onClick = {
            onclick("الرئيسية")
        },
            label = { Text(text = "الرئيسية",color=Text_Gray) },
            icon = {
                Icon(
                   painter= painterResource(id = R.drawable.icon_open_home ),
                    contentDescription = null
                )
            }
        )


    }}}

@Preview
@Composable
fun defaultPreview7(){

//    BottomBar ()
}




