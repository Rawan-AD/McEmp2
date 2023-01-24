package sa.gov.mc.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import sa.gov.mc.R
@Composable
fun Background (){
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(id = R.drawable.on_boarding_png),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
    }
}