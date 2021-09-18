package com.example.android_flutter

import android.app.Application
import io.flutter.embedding.engine.FlutterEngineGroup

class APP : Application() {

    override fun onCreate() {
        super.onCreate()
        engineGroup = FlutterEngineGroup(this)
        mContext = this
    }

    companion object {
        lateinit var mContext: APP
        lateinit var engineGroup: FlutterEngineGroup
    }
}