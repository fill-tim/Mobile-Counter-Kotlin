package com.example.laba1.main_act

import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


class Value {
    companion object {
        fun getIntValueFromCountView(valueTextView: TextView): Int {
            println(valueTextView)
            return Integer.parseInt(valueTextView.text.toString())
        }

        fun getIntValueFromInput(addedValueTextView: TextInputEditText): Int {
            return Integer.parseInt(addedValueTextView.text.toString())
        }
    }
}

