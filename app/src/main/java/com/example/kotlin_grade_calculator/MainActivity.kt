package com.example.kotlin_grade_calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMarks = findViewById<EditText>(R.id.inputMarks)
        val outputGrade = findViewById<TextView>(R.id.outputGrade)
        val calButton = findViewById<Button>(R.id.calButton)
        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        outputGrade.visibility = View.GONE

        calButton.setOnClickListener {
            val marks = inputMarks.text.toString().toIntOrNull()
            val spacer = findViewById<View>(R.id.spacer)

            if (marks != null) {
                val grade = calculateGrade(marks)
                outputGrade.text = grade
                outputGrade.visibility = View.VISIBLE
                spacer.layoutParams.height = 0
                Toast.makeText(this, "Grade calculated successfully", Toast.LENGTH_SHORT).show()
            } else {
                spacer.layoutParams.height = 50
                Toast.makeText(this, "Invalid input. Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateGrade(marks: Int): String {
        return when {
            marks >= 85 -> "A+"
            marks >= 70 -> "A"
            marks >= 65 -> "A-"
            marks >= 60 -> "B+"
            marks >= 55 -> "B"
            marks >= 50 -> "B-"
            marks >= 45 -> "C+"
            marks >= 40 -> "C"
            marks >= 35 -> "C-"
            marks >= 30 -> "D+"
            marks >= 25 -> "D"
            else -> "E"
        }
    }
}