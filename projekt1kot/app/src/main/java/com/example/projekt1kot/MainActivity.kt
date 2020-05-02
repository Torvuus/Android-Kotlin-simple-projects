package com.example.projekt1kot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
const val EXTRA_MESSAGE = "com.example.projekt1kot.MESSAGE"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
    }
    fun sendMessage(view: View){
        val editText=findViewById<EditText>(R.id.textInput)
        val message=editText.text.toString()
        val intent= Intent(this,DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE,message)
        }
        startActivity(intent)
    }
}
