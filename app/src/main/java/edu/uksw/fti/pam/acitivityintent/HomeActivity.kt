package edu.uksw.fti.pam.acitivityintent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import edu.uksw.fti.pam.acitivityintent.ui.screens.BottomNavigationMainScreenView
import edu.uksw.fti.pam.acitivityintent.ui.screens.HomeScreen
import edu.uksw.fti.pam.acitivityintent.ui.screens.TopNavigationMainScreenView
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme

class HomeActivity : AppCompatActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMAcitivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                    BottomNavigationMainScreenView()
                    TopNavigationMainScreenView()
                }
            }
        }
    }
}