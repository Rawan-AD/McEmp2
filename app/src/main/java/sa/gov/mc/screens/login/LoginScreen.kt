package sa.gov.mc.screens.login


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.model.Captcha
import sa.gov.mc.model.Login
import sa.gov.mc.model.LoginResponse
import sa.gov.mc.network.AccountApiService

import sa.gov.mc.screens.login.Captcha.uuid

import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Background
import sa.gov.mc.utility.Constants.retrofitBuilder

import sa.gov.mc.utility.CustomButton



@Composable
fun LoginScreen(navController: NavHostController) {

Background()
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {


            Image(
                painter = painterResource(R.drawable.group_72),
                contentDescription = null,
                modifier = Modifier

                    .size( 170.dp,120.dp)

                    ,
                contentScale = ContentScale.Fit
            )


        Spacer(Modifier.height(25.dp))
        SimpleFilledTextFieldSample(navController)

        }




}

@SuppressLint("SuspiciousIndentation")
@Composable
fun SimpleFilledTextFieldSample(navController:NavController) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var captcha by remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(value = userName, onValueChange = { userName = it }, label = {

                Text(
                    "اسم المستخدم",
                    style = MaterialTheme.typography.subtitle6,
                    textAlign = TextAlign.Right,
                    fontSize = 15.sp,
                    color = Pinkish_Gray
                )

            }, leadingIcon = {
                Image(
                    painterResource(id = R.drawable.icon_metro_user),
                    contentDescription = "icon_image"
                )
            }, modifier = Modifier
                .wrapContentSize()
                .height(60.dp)


                .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                colors = textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = PrimaryColor,
                    focusedIndicatorColor = PrimaryColor,
                    errorIndicatorColor = Red
                )
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "كلمة المرور",
                        style = MaterialTheme.typography.subtitle6,
                        textAlign = TextAlign.Right,
                        fontSize = 15.sp,
                        color = Pinkish_Gray,
                        lineHeight = 15.sp,
                        modifier = Modifier.absolutePadding(bottom = 16.dp)
                    )


                },

                leadingIcon = {
                    Image(
                        painterResource(id = R.drawable.icon_open_lock_locked),
                        contentDescription = "icon_image"
                    )
                },
                modifier = Modifier
                    .height(60.dp)


                    .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                colors = textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = PrimaryColor,
                    focusedIndicatorColor = PrimaryColor,
                    errorIndicatorColor = Red
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                Modifier
                    .width(240.dp)
                    .height(30.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.reload),
                    contentDescription = "reload",
                    modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.width(130.dp))
                var captchaInfo = retrofitBuilder.create(AccountApiService::class.java).getCaptcha()
             var d: String="hhh"
            lateinit var decodedImage:Bitmap

                captchaInfo.enqueue(object : Callback<Captcha> {

                                        @SuppressLint("SuspiciousIndentation")
                    override fun onResponse(call: Call<Captcha>, response: Response<Captcha>) {


                        d =response.body()?.captcha.toString()
                                            decode(d)
//                        val imageByte=Base64.decode(d,Base64.DEFAULT)
//                   decodedImage =BitmapFactory.decodeByteArray(imageByte,0,imageByte.size)

//Image(decodedImage.asImageBitmap(), contentDescription = "null")

                        Log.e("finish", "onFinish:"+d)


                    }

                    override fun onFailure(call: Call<Captcha>, t: Throwable) {
                        Log.e("Failure_GET", "onFailure:"+t.toString())
                    }


                })





                decode(d)?.asImageBitmap()?.let { Image(it, contentDescription = "captcha", modifier = Modifier.size(90.dp,22.dp)) }
           }


                OutlinedTextField(
                    value = captcha,
                    onValueChange = { captcha = it },

                    label = {
                        Text(
                            text = "اكتب كودالتحقق هنا",
                            fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                            fontWeight = FontWeight.Normal,
                            color = Pinkish_Gray,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            modifier = Modifier.absolutePadding(right = 60.dp)


                        )
                    },

                    modifier = Modifier
                        .height(60.dp)

                        .absolutePadding(right = 65.5.dp, left = 65.5.dp),
                    colors = textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = PrimaryColor,
                        focusedIndicatorColor = PrimaryColor,
                        errorIndicatorColor = Red
                    )
                )




                Spacer(modifier = Modifier.height(25.dp))


                CustomButton(
                    title = "تسجيل الدخول",
                    navController,
                    route = Screens.OptScreen.route,
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(right = 65.dp, left = 66.dp),
                    color = PrimaryColor
                )
                var login = Login("uat1", "asdf@mc100", "b2986410195949f392cded3cc6c47a09", "rrh2e")
                var captchaInfow =
                    retrofitBuilder.create(AccountApiService::class.java).postLogin(login)
                captchaInfow.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        Log.e(TAG, "onResponse: " + response.body()?.uuid)
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e(TAG, "onFailu: " + t)
                    }

                })


            }
        }
    }

@Preview
@Composable
fun defaultPreview2() {
    LoginScreen(rememberNavController())


}

fun decode(d:String):Bitmap?{
    var decodeStr: ByteArray? = Base64.decode(d,Base64.DEFAULT)
    var decoded:Bitmap? = decodeStr?.let { BitmapFactory.decodeByteArray(decodeStr,0, it.size) }
return decoded
}
