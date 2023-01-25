package sa.gov.mc.data


import android.util.Log
import kotlinx.coroutines.*
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.network.AccountApiService
import kotlin.math.log

class LoginRemoteDataSource(private val api: AccountApiService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {


    suspend fun login(login:Login):LoginResponse=
        withContext(dispatcher) {api.login(login)

        }




}