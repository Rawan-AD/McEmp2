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


    suspend fun login(login: Login) :Flow<LoginResponse> = flow {
emit(loginRemoteDataSource.login(login))}






}


