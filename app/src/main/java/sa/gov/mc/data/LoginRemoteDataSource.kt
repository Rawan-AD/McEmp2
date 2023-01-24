package sa.gov.mc.data


import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.network.AccountApiService
import kotlin.math.log

class LoginRemoteDataSource(private val api: AccountApiService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

lateinit var s:LoginResponse
    suspend fun login(login:Login){

        withContext(dispatcher) {
//          login_.username=login.username
//            login_.password=login.password
//            login_.uuid=login.uuid
//            login_.answer=login.answer

  s= api.login(login)


        }

        Log.e("datasource response", "$s")

}
}