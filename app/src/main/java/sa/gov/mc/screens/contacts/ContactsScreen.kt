package sa.gov.mc.screens.contacts



import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.Color.Companion.White

import androidx.compose.ui.graphics.painter.Painter

import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalLayoutDirection

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.utility.AppHeader




import sa.gov.mc.ui.theme.*

import sa.gov.mc.utility.Search





@Composable
fun ContactsScreen(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 10.dp)
        ) {
            val (header, content, bottomBar) = createRefs()


            AppHeader("دليل", "الموظفون",
               navController = navController, modifier = Modifier

                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },"homeScreen"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(bottomBar.top)
                        height = Dimension.fillToConstraints
                    },

                ) {

                Search("بحث")


                var contactsList = mutableListOf<Contact>()

                for (i in 0..14) {
                    contactsList.add(
                        Contact(
                            painterResource(R.drawable.person),
                            "فلان الفلان الفلاني",
                            ".Net Developer",
                            "05555555",
                            "ttt@gmail.com"
                        )
                    )

                }



                Spacer(modifier = Modifier.padding(3.dp))
                LazyColumn {
                    items(contactsList.size) { item ->
                        ContactCard(contactsList[item])
                    }
                }
            }


        }
    }

}



@Composable
fun ContactCard(contact: Contact) {

    Card(
        Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()
            .size(356.dp, 91.dp),
        shape = Shapes.ExtraSmall, backgroundColor = White,
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(
                contact.image, contentDescription = null, contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(vertical = 22.dp, horizontal = 11.dp)
                    .clip(
                        Shapes.Larg_Medium
                    )
            )

            Column(
                modifier = Modifier
                    .absolutePadding(top = 17.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("فلان الفلان الفلاني", style = MaterialTheme.typography.subtitle2)
                Text(".Net Developer", style = MaterialTheme.typography.subtitle3)}




                Column(  modifier = Modifier
                    .absolutePadding(top = 17.dp)
                    .align(Alignment.CenterVertically)){
                Box(modifier=Modifier.size(30.dp) ,contentAlignment = Alignment.Center){
                    Custom_Draw_Call_Contact(painterResource(id = R.drawable.callcontact),170.dp,
                    (-7).dp, Light_Blue,30.dp,17.dp)}
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(modifier=Modifier.size(30.dp),contentAlignment = Alignment.Center){
                        Custom_Draw_Call_Contact(painterResource(id = R.drawable.email),170.dp,
                            (-5).dp, Green_Eald,30.dp,17.dp)}
                }



        }




    }}



@Preview
@Composable

fun DefaultPreview5() {
    ContactsScreen(rememberNavController())
}


@Composable
fun Custom_Draw_Call_Contact(
    image: Painter,
    x: Dp,
    y: Dp,
    background: Color,
    size: Dp,
    imageSize: Dp
) {

    Box(
        modifier = Modifier
            .size(size)
            .offset(x, y)
            .drawBehind {
                drawCircle(
                    color = background,
                    radius = 40F
                )
            }, contentAlignment = Alignment.Center
    ) {
        Image(
            image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(imageSize)
        )
    }

}




@Composable
fun cirlcle(image: Painter, x: Dp, y: Dp, background: Color, size: Dp, imageSize: Dp) {

   Box(
      modifier = Modifier
          .size(size)
          .offset(x, y)
          .drawBehind {
              drawCircle(
                  color = background,
                  radius = 20F
              )
          },contentAlignment = Alignment.Center
    ) {
        Image(
            image, contentDescription = null, modifier = Modifier
                .background(background)
                .size(imageSize), contentScale = ContentScale.FillBounds
        )
    }

}
