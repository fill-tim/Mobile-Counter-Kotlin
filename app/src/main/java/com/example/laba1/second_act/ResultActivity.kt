package com.example.laba1.second_act

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.laba1.Keys
import com.example.laba1.R
import com.example.laba1.main_act.MainActivity


class ResultActivity : AppCompatActivity() {
    private lateinit var valueTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        inItAllElements()
        inItAllValues()
    }

    private fun inItAllElements() {
        valueTextView = findViewById(R.id.textViewResult)
    }

    private fun inItAllValues() {
        valueTextView.text = intent.getStringExtra(Keys.TOTAL_VALUE)
    }

    fun onClickGoMainAct(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}