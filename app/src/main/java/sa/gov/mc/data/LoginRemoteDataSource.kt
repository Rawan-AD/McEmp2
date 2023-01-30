package sa.gov.mc.data


import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
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


    suspend fun login(login:Login):Any=
        withContext(dispatcher) {var d=api.login(login)


            Log.e("data","$d")
            delay(2000)
        }





  suspend fun login2(credentials: Login): LoginResponse {
        var result= LoginResponse(0,"")

        val getData: Call<LoginResponse> = api.login(credentials)

        getData.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        result = response.body()!!
                        Log.e("data","${result}")
                    } else {

                        result = LoginResponse(-1, "not successful")
                        Log.e("else","notfpund")
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable) {
                result = LoginResponse(-1, "failure")
            }

        })
        return result
    }


}


