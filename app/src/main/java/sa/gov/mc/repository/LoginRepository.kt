package sa.gov.mc.repository


import android.util.Log
import kotlinx.coroutines.*


import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.model.CheckOTP
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor (private val loginRemoteDataSource: LoginRemoteDataSource) {


    suspend fun login(login:Login) :LoginResponse  {

       var loginResponse= loginRemoteDataSource.login(login)
        delay(3000)
        Log.e("login", "login")
        return loginResponse
    }

    suspend fun checkOtp(checkOtp:CheckOTP){
        var otpInfo=CheckOTP( 3918,1234, "be7ca43c02664dacad0d3e85b169eb0d")

    }

    fun login2(login: (Login), result: (loginResponse:LoginResponse) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val loginResponse = async(Dispatchers.IO){
                Log.e("login2", "login2")
                loginRemoteDataSource.login(login)
                }

            Log.e("before response", "before response")
            var response=LoginResponse(1,"")
try {
    response = loginResponse?.await()
}
catch(e:Exception){

    Log.e("catch", "${e.message}")
}



            result(response)

        }}

    }









