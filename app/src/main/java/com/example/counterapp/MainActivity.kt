package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private var counter = 0
    private val counterRepository = CounterRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        counterTextView = findViewById(R.id.counter_text)
        incrementButton = findViewById(R.id.increment_button)
        decrementButton = findViewById(R.id.decrement_button)

        // Load the saved counter value
        counter = counterRepository.getCounter()
        updateCounterDisplay()

        // Set click listeners
        incrementButton.setOnClickListener {
            incrementCounter()
        }

        decrementButton.setOnClickListener {
            decrementCounter()
        }
    }

    private fun incrementCounter() {
        counter++
        counterRepository.saveCounter(counter)
        updateCounterDisplay()
    }

    private fun decrementCounter() {
        counter--
        counterRepository.saveCounter(counter)
        updateCounterDisplay()
    }

    private fun updateCounterDisplay() {
        counterTextView.text = counter.toString()
        }
}
