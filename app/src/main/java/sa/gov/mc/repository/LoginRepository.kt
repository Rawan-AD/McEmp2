package sa.gov.mc.repository


import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.internal.wait


import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.utility.State
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class LoginRepository @Inject constructor (private val loginRemoteDataSource: LoginRemoteDataSource) {


    suspend fun login(userName:String,password:String,id:String,captcha:String) :Flow<LoginResponse> = flow {
        var login=Login(username = userName, password = password,uuid=id, answer = captcha)
       emit(loginRemoteDataSource.login(login))
    }






}


