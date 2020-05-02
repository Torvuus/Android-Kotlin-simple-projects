package com.example.projekt6kot

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SimpleItemLayoutActivity : AppCompatActivity() {

    private lateinit var lvLanguages:ListView
    private lateinit var languages:Array<String>
    private lateinit var helloPhrases:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_item_layout)
        lvLanguages=findViewById(R.id.lvLanguagesChanged)
        initResources()
        initLanguagesListView()
    }
    private fun initResources() {
        var res= resources
        languages = res.getStringArray(R.array.languages)
        helloPhrases=res.getStringArray(R.array.hello_phrases)
    }
    private fun initLanguagesListView(){
        lvLanguages.adapter=ArrayAdapter(
            applicationContext,
            R.layout.row_layout,R.id.label,
            languages
        )

        lvLanguages.onItemClickListener =
            OnItemClickListener { parent, v, pos, id ->
                Toast.makeText(
                    applicationContext,
                    helloPhrases[pos],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}
