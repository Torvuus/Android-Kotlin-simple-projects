package com.example.projekt6kot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onSimpleItemLayout(view:View){
        val intent=Intent(this,SimpleItemLayoutActivity::class.java)
        startActivity(intent)
    }
    fun onOneStringItem(view:View){
        val intent=Intent(this,OneStringItemActivity::class.java)
        startActivity(intent)
    }
    fun onTwoStringItem(view:View){
        val intent=Intent(this,TwoStringItemActivity::class.java)
        startActivity(intent)
    }
    fun onCustom(view:View){
        val intent=Intent(this,CustomActivity::class.java)
        startActivity(intent)
    }
}
