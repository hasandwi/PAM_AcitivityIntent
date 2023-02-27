package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.model.ListModel
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    lateinit var courseList: List<ListModel>
    courseList = ArrayList<ListModel>()

    courseList = courseList + ListModel("Beauty And The Beast", R.drawable.image5)
    courseList = courseList + ListModel("Turning Red", R.drawable.image4)
    courseList = courseList + ListModel("Modok", R.drawable.image3)
    courseList = courseList + ListModel("Wakanda", R.drawable.image2)
    courseList = courseList + ListModel("Teluh Darah", R.drawable.image1)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.DarkPurple)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = "Teluh Darah",
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp, 0.dp, 470.dp)
        )
    }

    LazyRow {
        itemsIndexed(courseList) { index, item ->
            Card(
                modifier = Modifier
                    .padding(8.dp,300.dp,8.dp,0.dp)
                    .width(200.dp)
                    .background(colorResource(id = R.color.DarkPurple)),
                elevation = 6.dp
            )
            {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.DarkPurple)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = painterResource(id = courseList[index].languageImg),
                        contentDescription = "img",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),

                        alignment = Alignment.Center
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PAMAcitivityIntentTheme {
        HomeScreen()
    }
}
