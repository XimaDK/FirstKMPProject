package com.kadyshev.firstkmpproject.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kadyshev.firstkmpproject.theme.AppBrushes
import com.kadyshev.firstkmpproject.theme.AppPalette
import firstkmpproject.composeapp.generated.resources.Res
import firstkmpproject.composeapp.generated.resources.dont_have_account
import firstkmpproject.composeapp.generated.resources.enter_email
import firstkmpproject.composeapp.generated.resources.enter_password
import firstkmpproject.composeapp.generated.resources.forgot_password
import firstkmpproject.composeapp.generated.resources.login_hint
import firstkmpproject.composeapp.generated.resources.login_title
import firstkmpproject.composeapp.generated.resources.password_hint
import firstkmpproject.composeapp.generated.resources.sign_in_title
import firstkmpproject.composeapp.generated.resources.sing_up
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    modifier: Modifier,
    onLoginClick: (String, String) -> Unit,
) {
    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(brush = AppBrushes.MainGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(48.dp))
            InputCard(
                login = login,
                onLoginChange = { login = it },
                password = password,
                onPasswordChange = { password = it }
            )
            Spacer(modifier = Modifier.height(12.dp))
            ForgotPasswordText(
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(24.dp))
            SignInButton(
                enabled = login.isNotBlank() && password.isNotBlank(),
                onClick = { onLoginClick(login, password) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            SignUpRow()
        }
    }
}

@Composable
private fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.login_title),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = stringResource(Res.string.sign_in_title),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun InputCard(
    login: String,
    onLoginChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.1f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            AppTextField(
                value = login,
                onValueChange = onLoginChange,
                label = Res.string.login_hint,
                placeholder = Res.string.enter_email,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = Res.string.password_hint,
                placeholder = Res.string.enter_password,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                visualTransformation = PasswordVisualTransformation()
            )
        }
    }
}

@Composable
private fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: StringResource,
    placeholder: StringResource,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        placeholder = { Text(stringResource(placeholder)) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = textFieldColors(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        singleLine = true
    )
}

@Composable
private fun ForgotPasswordText(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(Res.string.forgot_password),
        color = AppPalette.Purple500,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .clickable { /* TODO: forgot password */ }
    )
}

@Composable
private fun SignInButton(
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppPalette.Purple500,
            contentColor = Color.White,
            disabledContainerColor = AppPalette.Purple500.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(16.dp),
        enabled = enabled
    ) {
        Text(
            text = stringResource(Res.string.sign_in_title),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun SignUpRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(Res.string.dont_have_account),
            color = Color.White.copy(alpha = 0.7f)
        )
        Text(
            text = stringResource(Res.string.sing_up),
            color = AppPalette.Purple500,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { /* TODO: sign up */ }
        )
    }
}

@Composable
private fun textFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    focusedIndicatorColor = AppPalette.Purple500,
    unfocusedIndicatorColor = Color.White.copy(alpha = 0.3f),
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White,
    cursorColor = AppPalette.Purple500,
    focusedLabelColor = AppPalette.Purple500,
    unfocusedLabelColor = Color.White.copy(alpha = 0.7f)
)