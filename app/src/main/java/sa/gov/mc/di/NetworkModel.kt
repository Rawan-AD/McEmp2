package sa.gov.mc.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.network.AccountApiService
import sa.gov.mc.repository.CaptchaRepository
import sa.gov.mc.repository.LoginRepository
import sa.gov.mc.utility.AccountApiStatus
import sa.gov.mc.utility.Constants
import sa.gov.mc.utility.Instance
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {



  @Provides
  @Singleton
  fun provideRetrofit():Retrofit=
    Retrofit.Builder().baseUrl(Constants.Base_Url).addConverterFactory(
        GsonConverterFactory.create())
        .client(Instance.getUnsafeOkHttpClient())
        .build()



    @Provides
  fun provideDispatcher():CoroutineDispatcher= Dispatchers.IO

@Provides


fun provideCaptchaRemoteDataSource(accountApiService: AccountApiService) =
    CaptchaRemoteDataSource(accountApiService, provideDispatcher())







    @Provides
    @Singleton
    fun provideCaptchaRepository(accountApiService: AccountApiService):CaptchaRepository =
        CaptchaRepository(provideCaptchaRemoteDataSource(accountApiService))



    @Provides


    fun provideLoginRemoteDataSource(accountApiService: AccountApiService) =
        LoginRemoteDataSource(accountApiService, provideDispatcher())







    @Provides
    @Singleton
    fun provideLoginRepository(accountApiService: AccountApiService): LoginRepository =
LoginRepository(provideLoginRemoteDataSource(accountApiService))
}
