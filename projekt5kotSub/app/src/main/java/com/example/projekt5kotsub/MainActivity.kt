package com.example.projekt5kotsub

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var inputIntent=getIntent()
        var number1=inputIntent.getIntExtra("First number",0)
        var number2=inputIntent.getIntExtra("Second number",0)
        if (number1 == 0 && number2 == 0) {
            Toast.makeText(this, "No arguments.", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, "Arguments:"+number1+number2, Toast.LENGTH_LONG).show()
            var resultAdd=number1-number2
            val operation="Substraction"
            var launchIntent : Intent?=getPackageManager().getLaunchIntentForPackage("com.example.projekt5kot")
            launchIntent?.putExtra("Result",resultAdd)
            launchIntent?.putExtra("Operation",operation)
            if(launchIntent!=null){
                setResult(Activity.RESULT_OK,launchIntent)
                finish()
            }

        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
