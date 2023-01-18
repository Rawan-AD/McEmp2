package sa.gov.mc.screens.contacts

import androidx.compose.ui.graphics.painter.Painter

data class Contact(val image: Painter,val name:String,val job:String , val phoneNum:String,val email:String)
