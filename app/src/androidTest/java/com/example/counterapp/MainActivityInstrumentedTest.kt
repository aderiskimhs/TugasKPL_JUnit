package com.example.counterapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    /*
     * Kasus uji 1: Memverifikasi bahwa mengklik tombol tambah akan meningkatkan nilai penghitung
     * Pengujian ini memastikan bahwa ketika pengguna mengklik tombol tambah,
     * teks penghitung diperbarui untuk menampilkan nilai yang bertambah.
     * Kita mulai dengan nilai penghitung default 0, klik tombol sekali,
     * dan mengharapkan penghitung menampilkan "1".
     */
    @Test
    fun testIncrementButton() {
        // Meluncurkan aktivitas
        ActivityScenario.launch(MainActivity::class.java)

        // Memverifikasi bahwa nilai awal penghitung adalah 0
        onView(withId(R.id.counter_text)).check(matches(withText("0")))

        // Klik tombol tambah
        onView(withId(R.id.increment_button)).perform(click())

        // Memverifikasi bahwa penghitung telah bertambah menjadi 1
        onView(withId(R.id.counter_text)).check(matches(withText("1")))
    }

    /*
     * Kasus uji 2: Memverifikasi bahwa mengklik tombol kurang akan mengurangi nilai penghitung
     * Pengujian ini memastikan bahwa ketika pengguna mengklik tombol kurang,
     * teks penghitung diperbarui untuk menampilkan nilai yang berkurang.
     * Kita mulai dengan nilai penghitung default 0, klik tombol sekali,
     * dan mengharapkan penghitung menampilkan "-1".
     */
    @Test
    fun testDecrementButton() {
        // Meluncurkan aktivitas
        ActivityScenario.launch(MainActivity::class.java)

        // Memverifikasi bahwa nilai awal penghitung adalah 0
        onView(withId(R.id.counter_text)).check(matches(withText("0")))

        // Klik tombol kurang
        onView(withId(R.id.decrement_button)).perform(click())

        // Memverifikasi bahwa penghitung telah berkurang menjadi -1
        onView(withId(R.id.counter_text)).check(matches(withText("-1")))
    }
}
