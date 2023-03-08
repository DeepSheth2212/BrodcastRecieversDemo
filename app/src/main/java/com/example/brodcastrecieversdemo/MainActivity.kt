package com.example.brodcastrecieversdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var reciever: AriplaneModeChangedReciever
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reciever = AriplaneModeChangedReciever()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(reciever,it)
        }
    }


    //to prevent memory leak
    //because if we don't unregisterReceiver it holds our activity's context even if app is not live which can cause memory leak...
    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciever)
    }
}