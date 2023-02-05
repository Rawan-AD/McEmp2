package sa.gov.mc.screens.login


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import okhttp3.internal.wait
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse
import sa.gov.mc.data.model.OtpResponse
import sa.gov.mc.domain.ValidatePassword
import sa.gov.mc.domain.ValidateUserName
import sa.gov.mc.repository.CaptchaRepository
import sa.gov.mc.repository.CheckOtpRepository
import sa.gov.mc.repository.LoginRepository
import sa.gov.mc.utility.AccountApiStatus
import sa.gov.mc.utility.State
import java.security.PrivateKey

import javax.inject.Inject


@HiltViewModel

class LoginViewModel @Inject constructor(
    private val captchaRepository: CaptchaRepository,
    private val loginRepository: LoginRepository,
    private val checkOtpRepository: CheckOtpRepository

) : ViewModel() {
//    private val validateUserName:ValidateUserName= ValidateUserName()
//    private val validatePassword:ValidatePassword= ValidatePassword()
    private val _status = MutableLiveData<AccountApiStatus>()
    val captcha = MutableLiveData<String>()
//    var state by mutableStateOf(LoginFormState())
  var result =MutableLiveData<Captcha>()
   val loginStateFlow: MutableStateFlow<State> = MutableStateFlow(State.Empty)
//private var validateionEventChannel = Channel<ValidationEvent>()
//    val validationEvents=validateionEventChannel.receiveAsFlow()

    private val _errorEnableMsg = MutableLiveData("")
    val errorEnableMsg: LiveData<String> get() = _errorEnableMsg

//fun onEvent(event:LoginFormEvent){
//    when(event) {
//        is LoginFormEvent.UserNameChanged -> {
//state=state.copy(userName = event.userName)
//        }
//        is LoginFormEvent.PasswordChanged -> {
//            state=state.copy(password = event.password)
//        }
//        is LoginFormEvent.Submit ->{
//            submitData()
//        }
//
//    }
//
//
//
//
//}

//    private fun submitData() {
//     val userName=validateUserName.execute(state.userName)
//        val password=validatePassword.execute(state.password)
//        val hasError =listOf(userName,password).any{!it.successful}
//
//        if(hasError){
//            state=state.copy(userNameError = userName.errorMessage!!, passwordError = password.errorMessage!!)
//            return
//        }
////        viewModelScope.launch {
////validateionEventChannel.send(ValidationEvent.Success)
////        }
//    }

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
//sealed class ValidationEvent{
//    object Success:ValidationEvent()
//}

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

    fun checkOtp(){

        val otpResponse = MutableLiveData<OtpResponse>()
        viewModelScope.launch {
            _status.value = AccountApiStatus.LOADING

            try {

                otpResponse.value= checkOtpRepository.checkOtp()

                _status.value = AccountApiStatus.DONE


            } catch (e: Exception) {
                _status.value = AccountApiStatus.ERROR
                otpResponse.value= OtpResponse("","")


            }


        }

    }

    fun getCaptcha(): LiveData<String> = captcha




}



