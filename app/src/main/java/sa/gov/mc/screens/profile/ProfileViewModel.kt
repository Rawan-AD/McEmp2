package sa.gov.mc.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.User
import sa.gov.mc.repository.CaptchaRepository
import sa.gov.mc.repository.UserRepository
import sa.gov.mc.utility.AccountApiStatus
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {


    private val _status = MutableLiveData<AccountApiStatus>()
    val status: LiveData<AccountApiStatus> = _status
    private var user= User(0,"","","","","","",0,0,0,"","","","")

  fun userProfile(){

    viewModelScope.launch {
        _status.value = AccountApiStatus.LOADING

        try {
//           _captchaInfo.value=AccountApi.retrofitServer.getCaptcha()
           user = userRepository.userProfile()
            _status.value = AccountApiStatus.DONE


        } catch (e: Exception) {
            _status.value = AccountApiStatus.ERROR


        }


    }}



}