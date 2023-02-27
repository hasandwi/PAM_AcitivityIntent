package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.acitivityintent.R


@Composable
fun TopNavigation(
){
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Icon(
                    painter = painterResource(id = R.drawable.disney_toolbar),
                    contentDescription = "Disney+ Toolbar",
                    modifier = Modifier.size(120.dp,50.dp))
            },
            backgroundColor = colorResource(id = R.color.DarkPurple),
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Menu, "Menu")
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Person, "Akun")
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Info, "Info")
                }
            })
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopNavigationMainScreenView(){
    TopNavigation()
}