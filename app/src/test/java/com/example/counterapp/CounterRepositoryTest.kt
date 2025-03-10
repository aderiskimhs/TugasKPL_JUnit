package com.example.counterapp

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class CounterRepositoryTest {

    private lateinit var counterRepository: CounterRepository

    @Before
    fun setup() {
        counterRepository = CounterRepository()
    }

    /*
     * Test case 1: Verifies that the counter value is correctly saved and retrieved
     * This test ensures that when we save a counter value using saveCounter() method,
     * the getCounter() method returns the same value, confirming the basic functionality
     * of the CounterRepository class is working as expected.
     */
    @Test
    fun testSaveAndGetCounter() {
        // Given a counter repository with default value
        assertEquals(0, counterRepository.getCounter())

        // When we save a new counter value
        val newValue = 10
        counterRepository.saveCounter(newValue)

        // Then the getCounter method should return the saved value
        assertEquals(newValue, counterRepository.getCounter())
    }

    /*
     * Test case 2: Verifies that the isValidCounter method correctly identifies valid and invalid counter values
     * This test checks the boundary conditions of our validation logic,
     * ensuring values within the range -100 to 100 are considered valid,
     * while values outside this range are considered invalid.
     */
    @Test
    fun testIsValidCounter() {
        // Valid counter values should return true
        assertTrue(counterRepository.isValidCounter(0))
        assertTrue(counterRepository.isValidCounter(100))
        assertTrue(counterRepository.isValidCounter(-100))
        assertTrue(counterRepository.isValidCounter(50))

        // Invalid counter values should return false
        assertFalse(counterRepository.isValidCounter(101))
        assertFalse(counterRepository.isValidCounter(-101))
        assertFalse(counterRepository.isValidCounter(1000))
        assertFalse(counterRepository.isValidCounter(-1000))
        }
}
