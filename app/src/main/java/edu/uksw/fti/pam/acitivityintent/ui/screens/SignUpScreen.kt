package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.datastore.StoreUserFirstName
import edu.uksw.fti.pam.acitivityintent.datastore.StoreUserLastName
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import kotlinx.coroutines.launch

@Composable
fun SignUpForm(
    btnOnClickAction: (String?) -> Unit
) {

    // context
    val context = LocalContext.current
    // scope
    val scope = rememberCoroutineScope()
    // datastore First Name, Last Name
    val dataStore = StoreUserFirstName(context)
    val dataStore1 = StoreUserLastName(context)

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var firstNameInput by remember { mutableStateOf("") }
    var lastNameInput by remember { mutableStateOf("") }
    var confirmPasswordInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.DarkPurple)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.btn_title_signup),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.disney_hotstar),
            contentDescription = "Sign Up Background",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp)) {
            OutlinedTextField(
                value = firstNameInput,
                onValueChange = {firstNameInput = it},
                label = {
                    Text(text = stringResource(R.string.label_first_name))
                },
                modifier = Modifier.requiredWidth(170.dp),
                shape = RoundedCornerShape(15.dp)
            )
            OutlinedTextField(
                value = lastNameInput,
                onValueChange = {lastNameInput = it},
                label = {
                    Text(text = stringResource(R.string.label_last_name))
                },
                modifier = Modifier.requiredWidth(170.dp),
                shape = RoundedCornerShape(15.dp)
            )
        }
        OutlinedTextField(
            value = usernameInput,
            onValueChange = {usernameInput = it},
            label = {
                Text(text = stringResource(id = R.string.label_username))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp),
            shape = RoundedCornerShape(15.dp)
        )
        OutlinedTextField(
            value = passwordInput,
            onValueChange = {passwordInput = it},
            label = {
                Text(text = stringResource(id = R.string.label_password))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp),
            shape = RoundedCornerShape(15.dp)
        )
        OutlinedTextField(
            value = confirmPasswordInput,
            onValueChange = {confirmPasswordInput = it},
            label = {
                Text(text = stringResource(R.string.label_confirm_password))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp),
            shape = RoundedCornerShape(15.dp)
        )
        Button(
            onClick = {
                btnOnClickAction(usernameInput)
                scope.launch {
                    dataStore.saveFirstName(firstNameInput)
                    dataStore1.saveLastName(lastNameInput)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 20.dp, 0.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = stringResource(R.string.btn_title_signup))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpFormPreview() {
    PAMAcitivityIntentTheme {
        SignUpForm({})
    }
}