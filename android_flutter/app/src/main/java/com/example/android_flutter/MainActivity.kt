package com.example.android_flutter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_flutter.databinding.ActivityMainBinding
import io.flutter.embedding.android.FlutterFragment
import io.flutter.plugin.common.MethodChannel


class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.btnClick.setOnClickListener {
            val engine = FBFlutterEngineManager.flutterEngine(this, R.id.main_fl.toString(), "main")
            val channel = MethodChannel(engine.dartExecutor.binaryMessenger,"cjj.page1")
            channel.setMethodCallHandler { call, result ->
                when(call.method) {
                    "showTab" -> {
                        this@MainActivity.actionBar?.hide()
                        result.success("null")
                    }

                    "hideTab" -> {
                        this@MainActivity.actionBar?.show()
                        result.success("null")
                    }
                    else -> {
                        result.notImplemented()
                    }
                }
            }
            val flutterFragment = FlutterFragment.withCachedEngine(R.id.main_fl.toString()).build<FlutterFragment>()
            supportFragmentManager.beginTransaction().replace(R.id.main_fl,flutterFragment).commit()
        }

    }
}