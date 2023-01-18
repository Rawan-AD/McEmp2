package sa.gov.mc.screens.login

import androidx.annotation.DrawableRes

data class Login2(
    val title: String,
    val description: String,
    @DrawableRes val image:Int,
    val userName: String,
    val password: String,
    val captcha: String


)


object Captcha{
    var captcha:String=""
    var uuid:String=""
}
