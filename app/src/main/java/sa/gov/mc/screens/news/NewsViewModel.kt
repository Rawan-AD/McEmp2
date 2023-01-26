package sa.gov.mc.screens.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sa.gov.mc.repository.NewsRepository
import sa.gov.mc.utility.AccountApiStatus
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel(){

private val _status = MutableLiveData<AccountApiStatus>()
val status: LiveData<AccountApiStatus> = _status
private var _newsInfo = MutableLiveData<List<New>>()

    private lateinit var newsInfo :List<New>






fun getAllPublicNews(){
    viewModelScope.launch {

        _status.value = AccountApiStatus.LOADING

        try {
//           _captchaInfo.value=AccountApi.retrofitServer.getCaptcha()
           newsInfo = newsRepository.allPublicNews()
            _status.value = AccountApiStatus.DONE


        } catch (e: Exception) {
            _status.value = AccountApiStatus.ERROR
//            newsInfo = listOf(New("vvvvvvvvvvvvvvvvvvvvvv", "vvvvvvvvvvvvvvv",""))


        }


    }


    //remain new by id and images
}}