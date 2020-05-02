package com.example.projekt3kot

import android.content.res.Configuration
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : LifecycleActivity() {
    var count : Int =0
    var txt : String =""
    lateinit var counter : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        counter=findViewById(R.id.counter)
        val eText: EditText=findViewById(R.id.txtField)
        txt = eText.text.toString()
        count=-1
        counter.text = count.toString()
        if(lastNonConfigurationInstance !=null){
            count = lastNonConfigurationInstance as Int
            eText.setText(txt)
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("textfield",txt)
        Toast.makeText(this,"onSave",Toast.LENGTH_SHORT).show()
        onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        txt=savedInstanceState.getString("textfield")
        Toast.makeText(this,"onRestore",Toast.LENGTH_SHORT).show()
    }
    override fun onConfigurationChanged(newConfig: Configuration){
        super.onConfigurationChanged(newConfig)
    }

    override fun onRetainNonConfigurationInstance(): Any {
        return (count)
    }

    override fun onResume() {
        count++
        if(counter==null){
            counter=findViewById(R.id.counter)
        }
        counter.text=count.toString()
        super.onResume()
    }
}
