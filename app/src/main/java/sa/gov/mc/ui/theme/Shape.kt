package sa.gov.mc.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

val Shapes = Shapes(

    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(15.dp),
    large = RoundedCornerShape(20.dp)
)

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomEnd = 0.dp,
    bottomStart = 0.dp
)
@get:Composable
val Shapes.ExtraMedium:CornerBasedShape
get() =RoundedCornerShape(12.dp)
val Shapes.Larg_Medium:CornerBasedShape
    get() =RoundedCornerShape(13.dp)
val Shapes.ExtraSmall:CornerBasedShape
    get() =RoundedCornerShape(8.dp)
val Shapes.ExtraExtraExtraSmall:CornerBasedShape
get() = RoundedCornerShape(7.dp)
val Shapes.ExtraExtraSmall:CornerBasedShape
    get() =RoundedCornerShape(6.dp)