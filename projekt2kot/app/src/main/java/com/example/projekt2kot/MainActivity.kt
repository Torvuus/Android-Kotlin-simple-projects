package com.example.projekt2kot

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID="channelId"
    val text = "Incrementation : "
    var count=0
    var notificationId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun basicNotification(view:View){
        count++
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.hellothere)
            .setContentTitle("Notification")
            .setContentText(text+count)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
        notificationId++
    }
    fun customNotification(view: View){
        count++
        val notificationLayout = RemoteViews(packageName, R.layout.custom_notification)
        notificationLayout.setTextViewText(R.id.custom_not_message, text+count)
        val customNotification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.hellothere)
            .setContentText(text+count)
            .setColor(Color.BLACK)
            .setContent(notificationLayout);
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, customNotification.build())
        }
        notificationId++
    }
    fun basicToast(view: View){
        count++
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(applicationContext, text + count, duration).show()
    }
    fun customToast(view: View){
        count++
        val message=text+count
        val inflater = layoutInflater
        val container: ViewGroup? = findViewById(R.id.custom_toast_container)
        val layout: View = inflater.inflate(R.layout.custom_toast, container)
        val text: TextView = layout.findViewById(R.id.text)
        text.text = message
        with (Toast(applicationContext)) {
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = Toast.LENGTH_LONG
            setView(layout)
            show()
        }
    }
}
