package com.luckyfrog.ecommerceapp.core.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper

@HiltAndroidApp
class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}