package com.example.projekt3kot

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*

open class LifecycleActivity : Activity() {
    private var notifyManager: NotificationManager? = null
    var CHANNEL_ID = "1"
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        makeNotification("onCreate")
        createNotificationChannel()
    }

    override fun onStart() {
        makeNotification("onStart")
        super.onStart()
    }

    override fun onResume() {
        makeNotification("onResume")
        super.onResume()
    }

    override fun onPause() {
        makeNotification("onPause")
        super.onPause()
    }

    override fun onStop() {
        makeNotification("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        makeNotification("onDestroy")
        super.onDestroy()
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        makeNotification("onSaveInstanceState")
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        makeNotification("onRestoreInstanceState")
    }

    val dateTime: String
        get() {
            val currentTimeMillis = System.currentTimeMillis()
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = currentTimeMillis
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH] + 1
            val day = calendar[Calendar.DAY_OF_MONTH]
            val hours = calendar[Calendar.HOUR]
            val minutes = calendar[Calendar.MINUTE]
            val seconds = calendar[Calendar.SECOND]
            return String.format(
                Locale.getDefault(), "%04d-%02d-%02d %02d:%02d:%02d:%03d",
                year, month, day, hours, minutes, seconds, currentTimeMillis % 1000
            )
        }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "Toast channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    protected fun makeNotification(methodName: String) {
        val stringTime = dateTime
        val stringClassName = javaClass.simpleName
        val notify = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(stringClassName)
            .setContentText("$methodName: $stringTime")
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(id, notify.build())
        id++
    }

    protected fun makeToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}