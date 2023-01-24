package sa.gov.mc.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class LoginRepository @Inject constructor(private val loginRemoteDataSource:LoginRemoteDataSource) {
    lateinit var loginResponse:LoginResponse

    suspend fun login(login: Login){

        withContext(Dispatchers.IO) {
            try {



    loginRemoteDataSource.login(login)
            Log.e("login repo","$loginResponse")

            } catch (e: Exception) {

            }
        }


    }



    }


