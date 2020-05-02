package com.example.projekt3kot

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Chronometer
import kotlin.system.exitProcess

class MainActivity : LifecycleActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lifeTimer: Chronometer = findViewById(R.id.lifeTimer)
        lifeTimer.start()
    }
    fun goToSecond(view :View){
        val intent=Intent(this,SecondActivity::class.java)
         startActivity(intent)
    }
    fun exitApp(view: View){
        finish()
        exitProcess(0)
    }
}
