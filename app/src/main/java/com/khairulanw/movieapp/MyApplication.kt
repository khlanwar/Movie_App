package com.khairulanw.movieapp

import android.app.Application
import com.khairulanw.movieapp.core.di.databaseModule
import com.khairulanw.movieapp.core.di.networkModule
import com.khairulanw.movieapp.core.di.repositoryModule
import com.khairulanw.movieapp.di.useCaseModule
import com.khairulanw.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}