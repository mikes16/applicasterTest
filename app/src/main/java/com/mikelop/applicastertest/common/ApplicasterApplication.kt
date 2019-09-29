package com.mikelop.applicastertest.common

import android.app.Application
import com.mikelop.applicastertest.common.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class ApplicasterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@ApplicasterApplication)
            modules(appModule)
        }
    }
}