package com.example.newsblog

import android.app.Application
import com.example.newsblog.di.netWorkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApp() : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(netWorkModule))
        }

    }
}