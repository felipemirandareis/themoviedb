package com.mirandafelipe.themoviedb

import com.mirandafelipe.themoviedb.ui.extensions.daysBetween
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class ExtDateTest {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }

    @Test
    fun test1() {
        val initialDate = simpleDateFormat.parse("2000-01-01 00:00:00")!!
        val finalDate = simpleDateFormat.parse("2000-01-02 00:00:00")!!

        assert(TimeZone.getTimeZone("GMT").daysBetween(initialDate, finalDate) == 1)
    }

    @Test
    fun test2() {
        val initialDate = simpleDateFormat.parse("2000-02-28 22:59:59")!!
        val finalDate = simpleDateFormat.parse("2000-02-28 23:00:00")!!

        assert(TimeZone.getTimeZone("GMT").daysBetween(initialDate, finalDate) == 0)
    }

    @Test
    fun test3() {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd").apply {
            timeZone = TimeZone.getTimeZone("GMT")
        }

        val initialDate = simpleDateFormat.parse("2000-01-01")!!
        val finalDate = simpleDateFormat.parse("2000-01-30")!!

        assert(TimeZone.getTimeZone("GMT").daysBetween(initialDate, finalDate) == 29)
    }

    @Test
    fun test4() {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd").apply {
            timeZone = TimeZone.getTimeZone("GMT")
        }

        val initialDate = simpleDateFormat.parse("2020-08-15")!!
        val finalDate = Date()

        assert(
            TimeZone.getTimeZone("GMT").daysBetween(initialDate, finalDate) == 3
        )
    }
}