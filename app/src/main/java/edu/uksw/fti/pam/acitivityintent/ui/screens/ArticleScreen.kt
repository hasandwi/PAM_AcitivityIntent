package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.acitivityintent.R

@Composable
fun ArticleScreen() {
    var searchInput by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.DarkPurple)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.disney_hotstar),
            contentDescription = "Login Background",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,100.dp,0.dp,0.dp)
        )
        TextField(
            value = searchInput,
            onValueChange = { searchInput = it },
            label = { Text(text = stringResource(R.string.label_search)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search")},
            shape = RoundedCornerShape(15.dp)
        )
    }
}