package com.example.projekt6kot

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TwoStringItemActivity : AppCompatActivity() {

    private lateinit var lvLanguages: ListView
    private lateinit var languages: Array<String>
    private lateinit var helloPhrases: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_string_item)
        lvLanguages=findViewById(R.id.lvLanguages)
        initResources()
        initLanguagesListView()
    }
    private fun initResources() {
        val res = resources
        languages = res.getStringArray(R.array.languages)
        helloPhrases = res.getStringArray(R.array.hello_phrases)
    }

    private fun initLanguagesListView() {
        var adapter = CustomArrayAdapter(this, languages, helloPhrases)
        lvLanguages.adapter = adapter
        lvLanguages.onItemClickListener =
            OnItemClickListener { parent, v, pos, id ->
                Toast.makeText(
                    applicationContext,
                    helloPhrases[pos] + '\n' +
                            languages[pos],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}
