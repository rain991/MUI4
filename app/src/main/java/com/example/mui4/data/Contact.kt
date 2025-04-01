package com.example.mui4.data

import java.util.Date

data class Contact(
    val phoneNumber: String,
    val credentials: Credentials,
    val startDate: Date,
    val endDate: Date
) {
    data class Credentials(val name: String, val surname: String)
}

fun createDate(year: Int, month: Int, day: Int): Date {
    val calendar = java.util.Calendar.getInstance()
    calendar.set(year, month - 1, day)
    return calendar.time
}
