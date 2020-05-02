package com.example.projekt3kot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondActivity : LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
    fun goToThird(view: View){
        val intent= Intent(this,ThirdActivity::class.java)
        startActivity(intent)
    }
}
