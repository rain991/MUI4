package com.example.mui4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mui4.data.DataSetProvider
import com.example.mui4.presentation.theme.MUI4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSet1 = DataSetProvider.provideDataSet1()
        val dataSet2 = DataSetProvider.provideDataSet2()
        enableEdgeToEdge()
        setContent {
            MUI4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BillingsScreen(
                        paddingValues = innerPadding,
                        dataSet1 = dataSet1,
                        dataSet2 = dataSet2
                    )
                }
            }
        }
    }
}
