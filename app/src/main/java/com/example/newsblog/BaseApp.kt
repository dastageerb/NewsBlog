package com.example.newsblog

import android.app.Application
import com.example.newsblog.BuildConfig.DEBUG
import com.example.newsblog.di.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

@OptIn(ExperimentalSerializationApi::class)
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(
                listOf(
                    netWorkModule,
                    repositoryModule,
                    dispatchersModule,
                    viewModelModule,
                    mapperModule
                )
            )
        }
    }
}