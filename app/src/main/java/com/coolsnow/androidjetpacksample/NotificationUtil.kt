package com.coolsnow.androidjetpacksample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat


/**
 *  File: NotifactionUtil
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/25 18:51
 *  Description:
 *
 */
class NotificationUtil {
    companion object {
        fun show(context: Context, title: String, message: String) {
            val channelId = 123;
            val manager: NotificationManager =
                context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    "my_notification",
                    "my_notification",
                    NotificationManager.IMPORTANCE_HIGH
                )
                manager.createNotificationChannel(notificationChannel)
            }
            val builder = NotificationCompat.Builder(context, "my_notification")
            builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
            manager.notify(channelId, builder.build())
        }
    }
}