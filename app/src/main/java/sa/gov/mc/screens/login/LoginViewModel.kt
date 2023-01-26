package sa.gov.mc.screens.login


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.interaction.DragInteraction
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.repository.CaptchaRepository
import sa.gov.mc.repository.LoginRepository
import sa.gov.mc.utility.AccountApiStatus

import javax.inject.Inject



@HiltViewModel

class LoginViewModel @Inject constructor(private val captchaRepository:CaptchaRepository,private val loginRepository: LoginRepository) : ViewModel() {

    private val _status = MutableLiveData<AccountApiStatus>()
    val status: LiveData<AccountApiStatus> = _status
    private var _captchaInfo = MutableLiveData<Captcha>()
    private var _lofinInfo = MutableLiveData<LoginResponse>()
    val captchaInfo: LiveData<Captcha> = _captchaInfo
    val captcha = MutableLiveData<String>()
    var result = Captcha("", "")
    var loginResponse: Any = Any()

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
    fun login(login: Login) {


        viewModelScope.launch {
            _status.value = AccountApiStatus.LOADING
            try {
                loginResponse = loginRepository.login(login)
                Log.e("tagViewModel", "$loginResponse")
                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
                _lofinInfo.value = LoginResponse(0, "")
                Log.e("ERROR ViewModel", "$e")


            }


        }
//        Log.e("tagViewModel", "$loginResponse")


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



