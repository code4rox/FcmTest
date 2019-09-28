package com.code4rox.fcmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nined.fcm.services.FcmFireBaseInstanceIDService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FcmFireBaseInstanceIDService.subscribeToTopic()
    }
}
