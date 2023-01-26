package sa.gov.mc.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.interaction.DragInteraction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class LoginRepository @Inject constructor (private val loginRemoteDataSource: LoginRemoteDataSource) {
    lateinit var loginResponse: Any


    suspend fun login(login: Login): Any {
        withContext(Dispatchers.IO) {
            try {
                loginResponse = loginRemoteDataSource.login(login)
                Log.e("tagrepo","$login")
                return@withContext loginResponse
            } catch (e: Exception) {
                Log.e("catch repo","${e.cause}")
                loginResponse= LoginResponse(2,"111")

            }

        }

        return loginResponse
    }


}


