package com.mirandafelipe.themoviedb.ui.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.convertDate(outputRegex: String): String {

    val universal = arrayOf(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss.SSSX",
        "yyyy-MM-dd'T'HH:mm:ss",
        "yyyy-MM-dd"
    )

    for (i in 0..universal.size) {
        return try {
            val simpleDateFormatUniversal = SimpleDateFormat(universal[i], Locale.getDefault())
            val date = simpleDateFormatUniversal.parse(this)
            SimpleDateFormat(outputRegex, Locale("pt", "BR")).format(date)
        } catch (exceptionOne: Exception) {
            continue
        }
    }

    throw Exception("Cannot convert this date")
}

fun TimeZone.daysBetween(from: Date, to: Date): Int {
    val offset = rawOffset + dstSavings
    return ((to.time + offset) / 86400000).toInt() - ((from.time + offset) / 86400000).toInt()
}