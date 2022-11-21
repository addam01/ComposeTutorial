package com.addam.jetpackcomposetutorial

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by addam on 17/11/2022
 */
@HiltAndroidApp
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}