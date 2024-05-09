package com.example.knownyc.util

import com.example.knownyc.data.local.provider.AssetsProvider
import com.example.knownyc.data.local.provider.AssetsProviderImpl
import com.example.knownyc.data.local.repositories.BoroughsRepositoryImpl
import com.example.knownyc.domain.repositories.BoroughsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent:: class)
abstract  class AppProviderModule{

    //Local Assets
    @Binds
    @Singleton
    abstract fun localAssetsProvider(impl: AssetsProviderImpl): AssetsProvider

    //Repo
    @Binds
    @Singleton
    abstract fun boroughRepositoryProvider(impl: BoroughsRepositoryImpl): BoroughsRepository

}

