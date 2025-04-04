package com.example.mui4.data

internal val dataSet2 = listOf(
    Contact(
        phoneNumber = "1-555-111-2222",
        credentials = Contact.Credentials(name = "Frank", surname = "Miller"),
        startDate = createDate(2022, 3, 10),
        endDate = createDate(2027, 3, 10)
    ),
    Contact(
        phoneNumber = "48-555-333-444",
        credentials = Contact.Credentials(name = "Grace", surname = "Anderson"),
        startDate = createDate(2022, 6, 5),
        endDate = createDate(2023, 6, 5)
    ),
    Contact(
        phoneNumber = "44-20-7946-0000",
        credentials = Contact.Credentials(name = "Henry", surname = "Moore"),
        startDate = createDate(2022, 9, 1),
        endDate = createDate(2029, 9, 1)
    ),
    Contact(
        phoneNumber = "33-1-42-34-56-99",
        credentials = Contact.Credentials(name = "Isabelle", surname = "Garcia"),
        startDate = createDate(2022, 11, 15),
        endDate = createDate(2026, 11, 15)
    ),
    Contact(
        phoneNumber = "49-30-9998887",
        credentials = Contact.Credentials(name = "Jack", surname = "Schmidt"),
        startDate = createDate(2022, 4, 20),
        endDate = createDate(2026, 4, 20)
    )
)