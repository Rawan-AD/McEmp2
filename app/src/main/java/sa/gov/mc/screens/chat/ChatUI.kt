package sa.gov.mc.screens.chat

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.utility.AppHeader
import sa.gov.mc.ui.theme.*

import sa.gov.mc.utility.Search

@Composable
fun ChatUI (navController: NavController){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 10.dp)
        ){
             val (header, content, bottomBar) = createRefs()

            AppHeader("صفحة","المراسلات",navController = navController,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },"homeScreen")
            Column (    modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .constrainAs(content) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomBar.top)
                    height = Dimension.fillToConstraints
                },){

                Search("بحث في المراسلات")

                var chatList = mutableListOf<Chat>()

                for( i in 0..14){
                    chatList.add(
                        Chat(
                            painterResource(R.drawable.person),
                            "فلان الفلان الفلاني",
                            "مساك الله بالخير"
                        )
                    )

                }




                Spacer(Modifier.height(13.dp))
                LazyColumn {
                    items(  chatList.size) { item ->
                        chatCard(chatList[item])
                    }
                }

            }



        }
        }



    
}



@Composable
fun chatCard(chat:Chat) {
    Card(
        Modifier
            .padding(vertical = 9.dp, horizontal = 2.dp)
            .fillMaxWidth()
            .height(91.dp),
        shape = Shapes.ExtraSmall, backgroundColor = White,
    ) {
        Row( Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(
                chat.image, contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 22.dp, horizontal = 11.dp)
                    .clip(
                        Shapes.medium
                    )
            )


            Column(
                modifier = Modifier
                    .absolutePadding(top = 17.dp)
                    .align(Alignment.CenterVertically),
            ) {
                Text("فلان الفلان الفلاني", style = typography.subtitle2)
                Text("مساك الله بالخير ياطيب", style = typography.subtitle3)
            }

            Spacer(modifier = Modifier.width(40.dp))

            Text(
                modifier = Modifier
                    .absolutePadding(top = 20.dp)

                    .drawBehind {
                        drawCircle(
                            color = PrimaryColor,
                            radius = 30F
                        )
                    },
                text = "3", color = White
            )



        }
    }
}

@Preview
@Composable
fun DefaultPreview9(){
    ChatUI (rememberNavController())
}