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

        // Initialize the UI elements
        val inputMarks = findViewById<EditText>(R.id.inputMarks)
        val outputGrade = findViewById<TextView>(R.id.outputGrade)
        val calButton = findViewById<Button>(R.id.calButton)
        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)

        // Set the theme switch listener
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // If the switch is checked, set the theme to night mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // If the switch is not checked, set the theme to day mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // Initially hide the grade output
        outputGrade.visibility = View.GONE

        // Set the calculate button click listener
        calButton.setOnClickListener {
            // Try to convert the input marks to an integer
            val marks = inputMarks.text.toString().toIntOrNull()
            val spacer = findViewById<View>(R.id.spacer)

            if (marks != null) {
                // If the conversion is successful, calculate the grade
                val grade = calculateGrade(marks)
                // Display the grade
                outputGrade.text = grade
                outputGrade.visibility = View.VISIBLE
                // Remove the spacer
                spacer.layoutParams.height = 0
                // Show a success message
                Toast.makeText(this, "Grade calculated successfully", Toast.LENGTH_SHORT).show()
            } else {
                // If the conversion is not successful, show an error message
                spacer.layoutParams.height = 50
                Toast.makeText(this, "Invalid input. Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to calculate the grade based on the marks
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