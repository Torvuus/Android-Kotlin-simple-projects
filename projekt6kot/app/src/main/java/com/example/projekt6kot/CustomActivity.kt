package com.example.projekt6kot

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CustomActivity : AppCompatActivity() {
    private lateinit var lvLanguages: ListView
    private lateinit var languages: Array<String>
    private lateinit var helloPhrases: Array<String>
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
        lvLanguages = findViewById<View>(R.id.lvLanguagesChanged) as ListView
        initResources()
        initLanguagesListView()
    }

    private fun initResources() {
        val res = resources
        languages = res.getStringArray(R.array.languages)
        helloPhrases = res.getStringArray(R.array.hello_phrases)
    }

    private fun initLanguagesListView() {
        val adapter =
            CustomArrayAdapterCustomActivity(this, languages, helloPhrases)
        lvLanguages!!.adapter = adapter
        lvLanguages!!.onItemClickListener =
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
