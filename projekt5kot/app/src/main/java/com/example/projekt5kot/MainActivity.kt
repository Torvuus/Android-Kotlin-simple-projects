package com.example.projekt5kot

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var mathResult=0
    var operation: String?=""
    var CUSTOM_ACTION="com.example.projekt5kot"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val resultView=findViewById<TextView>(R.id.result_created_text)
                val operationView=findViewById<TextView>(R.id.op_type_text)
                if (data != null) {
                    mathResult=data.getIntExtra("Result",0)
                    operation=data.getStringExtra("Operation")
                }
                if(operation!=null){
                    resultView.text=mathResult.toString()
                    operationView.setText(operation)
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) { //Write your code if there's no result
            }
        }
    } //onActivityResult

    fun sendNumbers(view:View){
        var launchIntent = Intent()
        launchIntent.action = CUSTOM_ACTION
        var number1=findViewById<EditText>(R.id.first_number)
        var number2=findViewById<EditText>(R.id.second_number)
        var temp=number1.getText().toString();
        var num1=0
        if("" != temp){
            num1 = temp.toInt()
        }
        temp=number2.text.toString()
        var num2=0
        if("" != temp){
            num2=temp.toInt()
        }
        launchIntent.putExtra("First number",num1)
        launchIntent.putExtra("Second number",num2)
        if(launchIntent?.resolveActivity(getPackageManager()) != null){
            startActivityForResult(launchIntent,1)
        }
    }
}
