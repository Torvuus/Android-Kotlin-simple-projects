package com.example.projekt4kot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    val linearLayout=R.layout.linear_layout
    val frameLayout=R.layout.frame_layout
    val tableLayout=R.layout.table_layout
    val gridLayout=R.layout.grid_layout
    val relativeLayout=R.layout.relative_layout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onFrameLayout(view:View){
        val intent= Intent(this,ActivityLayout::class.java).apply {
            putExtra("NameOfLayout",frameLayout)
        }
        startActivity(intent)
    }
    fun onLinearLayout(view: View){
        val intent=Intent(this,ActivityLayout::class.java).apply {
            putExtra("NameOfLayout",linearLayout)
        }
        startActivity(intent)
    }
    fun onTableLayout(view: View){
        val intent=Intent(this,ActivityLayout::class.java).apply {
            putExtra("NameOfLayout",tableLayout)
        }
        startActivity(intent)
    }
    fun onGridLayout(view: View){
        val intent=Intent(this,ActivityLayout::class.java).apply {
            putExtra("NameOfLayout",gridLayout)
        }
        startActivity(intent)
    }
    fun onRelativeLayout(view: View){
        val intent=Intent(this,ActivityLayout::class.java).apply {
            putExtra("NameOfLayout",relativeLayout)
        }
        startActivity(intent)
    }
}
