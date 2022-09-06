package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage.from}")

        /* // Check if message contains a data payload.
         if (remoteMessage.data.isNotEmpty()) {
             Log.d(TAG, "Message data payload: ${remoteMessage.data}")

             if (*//* Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use WorkManager.
                scheduleJob()
            } else {
                // Handle message within 10 seconds
                handleNow()
            }
        }
*/
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")

            sendNotification(it.body!!)


        }


        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private fun sendNotification(body: String) {
//        TODO("Not yet implemented")
        val notificationManager = ContextCompat.getSystemService(applicationContext,NotificationManager::class.java)as NotificationManager
        notificationManager.sendNotification(body,applicationContext)
    }



    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
//        TODO("Not yet implemented")
    }
}