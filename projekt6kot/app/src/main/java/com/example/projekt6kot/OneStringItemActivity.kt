package com.example.projekt6kot

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OneStringItemActivity : AppCompatActivity() {
    private lateinit var lvLanguages: ListView
    private lateinit var languages: Array<String>
    private lateinit var helloPhrases: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_string_item)
        lvLanguages = findViewById<View>(R.id.lvLanguages) as ListView
        initResources()
        initLanguagesListView()
    }

    private fun initResources() {
        val res = resources
        languages = res.getStringArray(R.array.languages)
        helloPhrases = res.getStringArray(R.array.hello_phrases)
    }

    private fun initLanguagesListView() {
        lvLanguages!!.adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            languages
        )
        lvLanguages!!.onItemClickListener =
            OnItemClickListener { parent, v, pos, id ->
                Toast.makeText(
                    applicationContext,
                    helloPhrases[pos],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}