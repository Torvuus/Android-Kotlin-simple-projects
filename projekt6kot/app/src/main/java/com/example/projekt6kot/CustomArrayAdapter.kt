package com.example.projekt6kot

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomArrayAdapter(
    private val context: Activity,
    private val languages: Array<String>,
    private val helloPhrases: Array<String>
) :
    ArrayAdapter<String?>(context, R.layout.two_list_item, languages) {

    internal class ViewHolder {
        var tvLanguage: TextView? = null
        var tvHelloPhrases: TextView? = null
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val viewHolder: ViewHolder
        var rowView :View?= convertView
        if (rowView == null) {
            val layoutInflater = context.layoutInflater
            rowView = layoutInflater.inflate(R.layout.two_list_item, null, true)
            viewHolder = ViewHolder()
            viewHolder.tvLanguage =
                rowView.findViewById<View>(R.id.tvLanguage) as TextView
            viewHolder.tvHelloPhrases =
                rowView.findViewById<View>(R.id.tvHelloPhrases) as TextView
            rowView.tag = viewHolder
        } else {
            viewHolder = rowView.tag as ViewHolder
        }
        viewHolder.tvLanguage!!.text = languages[position]
        viewHolder.tvHelloPhrases!!.text = helloPhrases[position]
        return rowView
    }
}