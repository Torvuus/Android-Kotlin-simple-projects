package com.example.projekt4kot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        val intent=getIntent()
        var layoutId=intent.getIntExtra("NameOfLayout",0)
        setContentView(layoutId)
    }
}
