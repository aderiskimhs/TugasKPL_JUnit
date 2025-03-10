package com.example.counterapp

/**
 * Repository class for storing and retrieving counter value
 */
class CounterRepository {
    private var counter = 0

    /**
     * Get the current counter value
     * @return current counter value
     */
    fun getCounter(): Int {
        return counter
    }

    /**
     * Save a new counter value
     * @param value the new counter value to save
     */
    fun saveCounter(value: Int) {
        counter = value
    }

    /**
     * Ensures the counter value is within a valid range
     * @param value the counter value to validate
     * @return true if value is valid, false otherwise
     */
    fun isValidCounter(value: Int): Boolean {
        // For demonstration, we'll consider a valid counter to be between -100 and 100
        return value in -100..100
        }
}
