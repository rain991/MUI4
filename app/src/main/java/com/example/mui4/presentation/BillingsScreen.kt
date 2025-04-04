package com.example.mui4.presentation

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mui4.data.Contact
import com.example.mui4.data.formatDateWithYear

@Composable
fun BillingsScreen(paddingValues: PaddingValues, dataSet1: List<Contact>, dataSet2: List<Contact>) {
    var currentDataSet by remember {
        mutableStateOf(dataSet1)
    }
    var currentSelectedContact by remember { mutableStateOf<Contact?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
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
        if (currentSelectedContact != null) {
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        AnimatedVisibility(visible = currentSelectedContact != null) {
            ContactDetails(currentSelectedContact!!)
        }
    }
}

@Composable
fun BillingsList(dataSet: List<Contact>, onContactSelected: (Contact) -> Unit) {
    val state = rememberLazyListState()
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp), state = state) {
        items(count = dataSet.size) { itemIndex ->
            val currentItem = dataSet[itemIndex]
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = currentItem.phoneNumber,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.clickable { onContactSelected(currentItem) })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ContactDetails(contact: Contact) {
    val formattedStartDate = contact.startDate.formatDateWithYear()
    val formattedEndDate = contact.endDate.formatDateWithYear()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Name: ${contact.credentials.name}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Surname: ${contact.credentials.surname}",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Billing starts : $formattedStartDate",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Billing ends : $formattedEndDate",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        if (contact.endDate.time < System.currentTimeMillis()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Billing expired",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Red,
                        fontWeight = FontWeight.W600
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}