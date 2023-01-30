package sa.gov.mc.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class LoginRepository @Inject constructor (private val loginRemoteDataSource: LoginRemoteDataSource) {
    lateinit var loginResponse:LoginResponse


    suspend fun login(login: Login): LoginResponse {
        withContext(Dispatchers.IO) {
            try {
                loginResponse = loginRemoteDataSource.login2(login)
                Log.e("tag-repo", "$loginResponse")

            } catch (e: Exception) {
                Log.e("catch repo", e.localizedMessage)
                loginResponse = LoginResponse(1, "ww") } }

            return loginResponse
        }








}


