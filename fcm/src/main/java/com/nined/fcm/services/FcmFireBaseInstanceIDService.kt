package com.nined.fcm.services

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.nined.fcm.BuildConfig

open class FcmFireBaseInstanceIDService {

    companion object {
        private const val RELEASE_TOPIC = "live_earth_map_imagineloft"
        private const val DEBUG_TOPIC = "test_app"
        fun subscribeToTopic(): Boolean {
            try {
                if (!FirebaseInstanceId.getInstance().id.isEmpty()) {
                    if (BuildConfig.DEBUG)
                        FirebaseMessaging.getInstance().subscribeToTopic(DEBUG_TOPIC)
                    else {
                        FirebaseMessaging.getInstance().subscribeToTopic(RELEASE_TOPIC)
                        FirebaseMessaging.getInstance().unsubscribeFromTopic(DEBUG_TOPIC)
                    }
                    return true
                }
                return false
            } catch (e: Exception) {
                Log.e("FirebaseMessaging", e.toString())
                return false
            }
        }
    }
}
