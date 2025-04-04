package com.example.mui4.data

internal val dataSet1 = listOf(
    Contact(
        phoneNumber = "1-555-123-4567",
        credentials = Contact.Credentials(name = "Alice", surname = "Smith"),
        startDate = createDate(2023, 1, 15),
        endDate = createDate(2024, 1, 15)
    ),
    Contact(
        phoneNumber = "1-555-987-6543",
        credentials = Contact.Credentials(name = "Bob", surname = "Johnson"),
        startDate = createDate(2014, 5, 20),
        endDate = createDate(2021, 5, 20)
    ),
    Contact(
        phoneNumber = "44-20-7946-0987",
        credentials = Contact.Credentials(name = "Charlie", surname = "Brown"),
        startDate = createDate(2023, 10, 1),
        endDate = createDate(2027, 10, 1)
    ),
    Contact(
        phoneNumber = "33-1-42-34-56-78",
        credentials = Contact.Credentials(name = "David", surname = "Wilson"),
        startDate = createDate(2023, 2, 28),
        endDate = createDate(2029, 2, 28)
    ),
    Contact(
        phoneNumber = "49-30-1234567",
        credentials = Contact.Credentials(name = "Emily", surname = "Davis"),
        startDate = createDate(2023, 7, 10),
        endDate = createDate(2030, 7, 10)
    )
)