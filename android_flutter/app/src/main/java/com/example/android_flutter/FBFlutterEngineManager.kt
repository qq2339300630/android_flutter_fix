package com.example.android_flutter

import android.content.Context
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

object FBFlutterEngineManager {
    fun flutterEngine(context: Context, engineID: String, entryPoint: String): FlutterEngine {
        var engine = FlutterEngineCache.getInstance().get(engineID)
        if (engine == null) {
            val dartEntrypoint = DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(), entryPoint
            )
            engine = APP.engineGroup.createAndRunEngine(context, dartEntrypoint)
            FlutterEngineCache.getInstance().put(engineID,engine)
        }
        return engine!!
    }
}