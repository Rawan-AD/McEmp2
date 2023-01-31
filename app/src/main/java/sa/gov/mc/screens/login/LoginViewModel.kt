package sa.gov.mc.screens.login


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.interaction.DragInteraction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.internal.wait
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.repository.CaptchaRepository
import sa.gov.mc.repository.LoginRepository
import sa.gov.mc.utility.AccountApiStatus
import sa.gov.mc.utility.State

import javax.inject.Inject


@HiltViewModel

class LoginViewModel @Inject constructor(
    private val captchaRepository: CaptchaRepository,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _status = MutableLiveData<AccountApiStatus>()
    val status: LiveData<AccountApiStatus> = _status
    private var _captchaInfo = MutableLiveData<Captcha>()
    private var _lofinInfo = MutableLiveData<LoginResponse>()
    val captchaInfo: LiveData<Captcha> = _captchaInfo
    val captcha = MutableLiveData<String>()
    var result = Captcha("", "")
   val loginStateFlow: MutableStateFlow<State> = MutableStateFlow(State.Empty)
    val _loginStateFlow: StateFlow<State> = loginStateFlow

    private val _errorEnableMsg = MutableLiveData("")
    val errorEnableMsg: LiveData<String> get() = _errorEnableMsg


    fun getCaptchaInfo() {
        viewModelScope.launch {
            _status.value = AccountApiStatus.LOADING

            try {
//           _captchaInfo.value=AccountApi.retrofitServer.getCaptcha()
                result = captchaRepository.captchaLogin()
                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
                _captchaInfo.value = Captcha("vvvvvvvvvvvvvvvvvvvvvv", "vvvvvvvvvvvvvvv")


            }


        }
    }


    @SuppressLint("SuspiciousIndentation")
    fun login(login: Login): State {
        viewModelScope.launch {
            loginStateFlow.value = State.Loading
            loginRepository.login(login)
                .catch { e ->
                    loginStateFlow.value = State.Failure(e)
                }.collect { data ->

                    loginStateFlow.value = State.Success(data)
                    Log.e("coll", "${data.requestId}")
                }
        }

        return loginStateFlow.value

    }


    private fun isUserNameEmpty(username: String): Boolean {
        return if (username.isEmpty()) {
            _errorEnableMsg.value += "name"
            false
        } else true

    }

    private fun isUserPasswordEmpty(userPassword: String): Boolean {
        return if (userPassword.isEmpty()) {
            _errorEnableMsg.value += "password"
            false
        } else true

    }

//    private fun isUserInfoForLoginNotEmpty(userName:String,password:String,captcha:String):Boolean{
//        return if(isUserPasswordEmpty(password)){
//            if(isUserNameEmpty(userName)){}}
//        return false
//    }

}



