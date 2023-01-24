package sa.gov.mc.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sa.gov.mc.network.AccountApiService
import sa.gov.mc.network.ServiceBuilder
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {
    @Provides
    fun provideLoginService(serviceBuilder:ServiceBuilder):AccountApiService =serviceBuilder.buildService(AccountApiService::class.java)
}