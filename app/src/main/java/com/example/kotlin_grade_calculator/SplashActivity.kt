package com.example.kotlin_grade_calculator

// Import necessary Android and Kotlin libraries
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Define the SplashActivity class, which extends AppCompatActivity
class SplashActivity : AppCompatActivity() {
    // Override the onCreate method from AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the superclass's onCreate method with the savedInstanceState
        super.onCreate(savedInstanceState)
        // Set the content view to the splash activity layout
        setContentView(R.layout.activity_splash)

        // Create a new Handler to post a delayed Runnable to the main thread
        Handler(Looper.getMainLooper()).postDelayed({
            // Inside the Runnable, start the MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            // Finish the SplashActivity so the user can't go back to it
            finish()
        }, 3000) // Delay the Runnable by 3000 milliseconds (3 seconds)
    }
}