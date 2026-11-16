package com.krypton.myjetpackcompose

import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krypton.myjetpackcompose.ui.theme.MyjetpackComposeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                UserScreen()
            }
        }
    }
}

// 1. Data model for your list items
data class User(val id:Int, val name: String, val role:String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen() {
     val context = LocalContext.current
    // 2. Static dataset (equivalent to items passed to an adapter)
    val userList = listOf(
        User(1,"Mahesh","Android Department"),
        User(2,"Varape","Android Department"),
        User(3,"Patil","Android Department"),
        User(4,"Magare","Android Department")
    )

    // 1. Scaffold handles the placement of the TopAppBar and content padding
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Team Members") },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Menu clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Search clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    )
    { innerPadding ->
        // 2. Pass innerPadding to the LazyColumn so content doesn't hide behind the TopAppBar

        // 3. LazyColumn acts as the RecyclerView container
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = userList,
                key = { user -> user.id }
            ) { user ->
                UserCard(user = user) { clickedUser ->
                    Toast.makeText(context, "Clicked: ${clickedUser.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

// 4. Custom ViewHolder layout equivalent (Card Item)
@Composable
fun UserCard(user: User,onItemClick:(User)->Unit){
    Card (
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(user) },// Handle click events easily
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = user.role,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
    }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        // Updated Preview Function
        // Comment from GitHub
        UserScreen()
    }
}
