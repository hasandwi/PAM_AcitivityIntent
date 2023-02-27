package edu.uksw.fti.pam.acitivityintent.ui.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.acitivityintent.HomeActivity
import edu.uksw.fti.pam.acitivityintent.contracts.SignUpContract
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import edu.uksw.fti.pam.acitivityintent.R
import edu.uksw.fti.pam.acitivityintent.SignUpActivity

internal fun doAuth(
    username: String,
    password: String,
): Boolean {
    return (username.equals("admin") && password.equals("admin"))
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    val getUsernameFromSignedUpForm = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { usernameInput = it!! })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.DarkPurple)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.btn_title_login),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(20.dp,20.dp,20.dp,0.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.disney_hotstar),
            contentDescription = "Login Background",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,5.dp,20.dp,0.dp)
        )
        TextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text(text = stringResource(R.string.label_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,20.dp,20.dp,0.dp),
            shape = RoundedCornerShape(15.dp)
        )
        TextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(text = stringResource(R.string.label_password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,20.dp,20.dp,0.dp),
            shape = RoundedCornerShape(15.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    val isAuthenticated = doAuth(usernameInput, passwordInput)
                    if (isAuthenticated) {
                        lContext.startActivity(
                            Intent(lContext, HomeActivity::class.java)
                                .apply {
                                    putExtra("username", usernameInput)
                                }
                        )
                    }
                },
                modifier = Modifier
                    .requiredWidth(200.dp)
                    .padding(20.dp,20.dp,30.dp,0.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = stringResource(R.string.btn_title_login))
            }
            Button(
                onClick = {
                    getUsernameFromSignedUpForm.launch("")
                },
                modifier = Modifier
                    .requiredWidth(200.dp)
                    .padding(20.dp,20.dp,30.dp,0.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = stringResource(R.string.btn_title_signup))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    PAMAcitivityIntentTheme {
        LoginForm()
    }
}