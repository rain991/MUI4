package com.example.mui4.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mui4.data.Contact

@Composable
fun BillingsScreen(paddingValues: PaddingValues, dataSet1: List<Contact>, dataSet2: List<Contact>) {
    var currentDataSet by remember {
        mutableStateOf(dataSet1)
    }
    var currentSelectedContact by remember { mutableStateOf<Contact?>(null) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Billings",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Billings list 1",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.clickable { currentDataSet = com.example.mui4.data.dataSet1 })
            Text(
                text = "Billings list 2",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.clickable { currentDataSet = com.example.mui4.data.dataSet2 })
        }
        Spacer(modifier = Modifier.height(16.dp))
        BillingsList(dataSet = currentDataSet, onContactSelected = { currentSelectedContact = it })
    }
}

@Composable
fun BillingsList(dataSet: List<Contact>, onContactSelected: (Contact) -> Unit) {
    val state = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxWidth(), state = state) {
        items(count = dataSet.size) { itemIndex ->
            val currentItem = dataSet[itemIndex]
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = currentItem.phoneNumber,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.clickable { onContactSelected(currentItem) })
            }
        }
    }
}

@Composable
fun ContactDetails(contact: Contact) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Name: ${contact.credentials.name}")
        Text(text = "Surname: ${contact.credentials.surname}")
        Text(text = "Billing starts : ${contact.startDate}")
        Text(text = "Billing ends : ${contact.endDate}")
    }
}