package sa.gov.mc.data


import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.network.AccountApiService
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import kotlin.math.log

class LoginRemoteDataSource @Inject constructor(private val api:AccountApiService, private val dispatcher:CoroutineDispatcher=Dispatchers.IO) {



    suspend fun login(loginInfo: Login): LoginResponse =
      api.login(loginInfo)





}











