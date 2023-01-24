package sa.gov.mc.screens.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
    val captchaInfo: LiveData<Captcha> = _captchaInfo
    val captcha = MutableLiveData<String>()
    var result = Captcha("", "")
 var loginResponse=LoginResponse("","")




//    init {
//        getCaptchaInfo()
//    }

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


    fun login(login: Login){


        _status.value = AccountApiStatus.LOADING
        viewModelScope.launch {
         try{
         loginRepository.login(login)

             _status.value = AccountApiStatus.DONE


         }
         catch (e:Exception){
             _status.value = AccountApiStatus.ERROR


         }




        }

    }
}
