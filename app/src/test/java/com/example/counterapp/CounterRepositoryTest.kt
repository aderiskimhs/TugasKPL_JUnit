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
     * Kasus uji 1: Memverifikasi bahwa nilai penghitung disimpan dan diambil dengan benar
     * Pengujian ini memastikan bahwa ketika kita menyimpan nilai penghitung menggunakan metode saveCounter(),
     * metode getCounter() akan mengembalikan nilai yang sama. Hal ini mengonfirmasi bahwa
     * fungsi dasar dari kelas CounterRepository bekerja sebagaimana mestinya.
     */
    @Test
    fun testSaveAndGetCounter() {
        // Diberikan sebuah repository penghitung dengan nilai awal default
        assertEquals(0, counterRepository.getCounter())

        // Ketika kita menyimpan nilai penghitung baru
        val newValue = 10
        counterRepository.saveCounter(newValue)

        // Maka metode getCounter harus mengembalikan nilai yang telah disimpan
        assertEquals(newValue, counterRepository.getCounter())
    }

    /*
     * Kasus uji 2: Memverifikasi bahwa metode isValidCounter dapat mengidentifikasi nilai penghitung yang valid dan tidak valid
     * Pengujian ini memeriksa batasan dari logika validasi,
     * memastikan bahwa nilai dalam rentang -100 hingga 100 dianggap valid,
     * sedangkan nilai di luar rentang tersebut dianggap tidak valid.
     */
    @Test
    fun testIsValidCounter() {
        // Nilai penghitung yang valid harus mengembalikan true
        assertTrue(counterRepository.isValidCounter(0))
        assertTrue(counterRepository.isValidCounter(100))
        assertTrue(counterRepository.isValidCounter(-100))
        assertTrue(counterRepository.isValidCounter(50))

        // Nilai penghitung yang tidak valid harus mengembalikan false
        assertFalse(counterRepository.isValidCounter(101))
        assertFalse(counterRepository.isValidCounter(-101))
        assertFalse(counterRepository.isValidCounter(1000))
        assertFalse(counterRepository.isValidCounter(-1000))
    }
}
