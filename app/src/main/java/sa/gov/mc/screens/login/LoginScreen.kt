package sa.gov.mc.screens.login


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.*

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.data.SessionManager
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.network.AccountApiService
import sa.gov.mc.repository.CaptchaRepository


import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Background
import sa.gov.mc.utility.Constants.retrofitBuilder

import sa.gov.mc.utility.CustomButton
import java.security.AccessController.getContext
import javax.inject.Inject
 var captchText=""
@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {

//val state=loginViewModel.state

var context= LocalContext.current
captchText= getCaptcha(context,loginViewModel = loginViewModel)
//    val context = LocalContext.current
//  lateinit var sessionManager: SessionManager
//    sessionManager = SessionManager(context)
//    private lateinit var apiClient: ApiClient
    Background()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {


        Image(
            painter = painterResource(R.drawable.group_72),
            contentDescription = null,
            modifier = Modifier

                .size(170.dp, 120.dp),
            contentScale = ContentScale.Fit
        )


        Spacer(Modifier.height(25.dp))

//        getCaptcha(loginViewModel)
//       loginViewModel.getCaptchaInfo()
//        val captcha = loginViewModel.result.value?.captcha
        LoginTextField(navController,loginViewModel)

    }


}

@Composable
fun getCaptcha(context:Context,loginViewModel: LoginViewModel):String{
    loginViewModel.getCaptchaInfo()
if(loginViewModel.result.value!=null)  captchText= loginViewModel.captcha.value!!
return captchText

}

@Composable
fun LoginTextField(navController: NavController, loginViewModel: LoginViewModel){
var isError by rememberSaveable{ mutableStateOf(false) }
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
                    .width(200.dp)
                    .height(90.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painterResource(id = R.drawable.reload),
                    contentDescription = "reload",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {

                        })

                            decode(captchText)
                                ?.asImageBitmap()
                                ?.let {
                                    Image(
                                        it,
                                        contentDescription = "captcha",
                                        modifier = Modifier.size(200.dp, 100.dp)
                                    )
                                }

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
                color = PrimaryColor,
                onClick = {
                    var s=loginViewModel.result.value!!.uuid
                    loginViewModel.login2("uat1","asdf@mc100",s,captcha)
                   var f=loginViewModel.checkOtp()
                    Log.e("screen", "$captcha")


                }
            )
//       val lifecycleOwner = LocalLifecycleOwner.current
//            val exampleEntitiesFlowLifecycleAware = remember(loginViewModel.loginStateFlow,lifecycleOwner){
//              loginViewModel.loginStateFlow.flowWithLifecycle(lifecycleOwner.lifecycle,Lifecycle.State.STARTED)}



            }



//
//            var d = loginViewModel.login(
//                Login(
//                    "uat1",
//                    "asdf@mc100",
//                    loginViewModel.result.uuid,
//                    captcha
//                )
//            )
//

        }
//    Log.e("screen", "${loginViewModel.loginStateFlow}")
    }



//fun reload(loginViewModel: LoginViewModel) {
//    val c= loginViewModel.getCaptchaInfo()
//    val d2= loginViewModel.result.captcha
//    decode(d2)
//}



fun decode(d: String): Bitmap? {
    var decodeStr: ByteArray? = Base64.decode(d, Base64.DEFAULT)
    var decoded: Bitmap? = decodeStr?.let { BitmapFactory.decodeByteArray(decodeStr, 0, it.size) }
    return decoded
}


