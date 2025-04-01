package com.example.mui4.presentation

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mui4.data.Contact

@Composable
fun BillingsScreen(paddingValues : PaddingValues, dataSet1 : List<Contact>, dataSet2 : List<Contact>){
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues)){
        Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Billings", style = MaterialTheme.typography.headlineMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun BillingsList(dataSet : List<Contact>){
    val state = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxWidth(), state = state) {
        items(count = dataSet.size){

        }
    }
}