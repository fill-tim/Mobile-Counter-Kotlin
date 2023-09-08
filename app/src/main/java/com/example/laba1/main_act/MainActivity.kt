package com.example.laba1.main_act

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.laba1.Keys
import com.example.laba1.R
import com.example.laba1.second_act.ResultActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    private lateinit var valueTextView: TextView
    private lateinit var addedValueTextInput: TextInputEditText
    private lateinit var settings: SharedPreferences
    private lateinit var pref: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Laba1)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initAllElements()
    }

    private fun initAllElements() {
        valueTextView = findViewById(R.id.textView)
        addedValueTextInput = findViewById(R.id.value)

        setInitData()
    }

    private fun setInitData() {
        settings = getSharedPreferences(Keys.BOX, MODE_PRIVATE)
        pref = settings.edit()
        valueTextView.text = settings.getString(Keys.SAVED_VALUE, "0")
    }

    private fun saveData() {
        pref.putString(Keys.SAVED_VALUE, valueTextView.text.toString())
        pref.apply()
    }


    fun onClickPlus(view: View) {

        val oldValue = Value.getIntValueFromCountView(valueTextView)
        val addedValues = Value.getIntValueFromInput(addedValueTextInput)
        val result = (oldValue + addedValues).toString()
        valueTextView.text = result
        saveData()
    }


    fun onClickMinus(view: View) {
        val oldValue = Value.getIntValueFromCountView(valueTextView)
        val addedValues = Value.getIntValueFromInput(addedValueTextInput)
        val result = (oldValue - addedValues).toString()
        valueTextView.text = result
        saveData()
    }

    fun onClickGoSecondAct(view: View) {
        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra(Keys.TOTAL_VALUE, valueTextView.text.toString())

        startActivity(intent)
    }

}

