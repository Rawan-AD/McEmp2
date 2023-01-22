package sa.gov.mc.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import sa.gov.mc.EmployeeApplication
import sa.gov.mc.model.Captcha
import sa.gov.mc.utility.AccountApi
import sa.gov.mc.utility.AccountApiStatus
import javax.inject.Inject



@HiltViewModel

class LoginViewModel @Inject constructor() : ViewModel(){

    private val _status=MutableLiveData<AccountApiStatus>()
    val status:LiveData<AccountApiStatus> =_status
   private val _captchaInfo=MutableLiveData<Captcha>()
    val captchaInfo:LiveData<Captcha> = _captchaInfo
    val captcha=MutableLiveData<String>()


    init{
        getCaptchaInfo()
    }

    private fun getCaptchaInfo() {
       viewModelScope.launch {
           _status.value=AccountApiStatus.LOADING

       try{
           _captchaInfo.value=AccountApi.retrofitServer.getCaptcha()
           _status.value=AccountApiStatus.DONE
           Log.e("TAG", "getCaptchaInfo: "+ captchaInfo.value?.captcha)

       }catch (e:Exception){
           _status.value=AccountApiStatus.ERROR
           _captchaInfo.value= Captcha("vvvvvvvvvvvvvvvvvvvvvv","vvvvvvvvvvvvvvv")
           Log.e("TAG", "getCaptchaInfo: "+ captchaInfo.value?.captcha)

       }


       }
    }
}

annotation class ViewModelInject
