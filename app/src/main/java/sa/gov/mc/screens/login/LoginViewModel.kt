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

    val captcha = MutableLiveData<String>()

  var result =MutableLiveData<Captcha>()
   val loginStateFlow: MutableStateFlow<State> = MutableStateFlow(State.Empty)


    private val _errorEnableMsg = MutableLiveData("")
    val errorEnableMsg: LiveData<String> get() = _errorEnableMsg


    fun getCaptchaInfo() {
        viewModelScope.launch {
            _status.value = AccountApiStatus.LOADING

            try {
                result.value= captchaRepository.captchaLogin()
                captcha.value=result.value?.captcha
                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
result.value= Captcha("","")


            }


        }
    }


    @SuppressLint("SuspiciousIndentation")
    fun login(userName:String,password:String,id:String,captcha:String): State {
        viewModelScope.launch {
            loginStateFlow.value = State.Loading
            Log.e("before", "${loginStateFlow.value}")
            loginRepository.login(userName,password,id,captcha)
                .catch { e ->
                    loginStateFlow.value = State.Failure(e)
                    Log.e("catch", "${e.localizedMessage}")
                }.collect { data ->

                    loginStateFlow.value = State.Success(data)
                    Log.e("coll", "${"ggg"}")
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



