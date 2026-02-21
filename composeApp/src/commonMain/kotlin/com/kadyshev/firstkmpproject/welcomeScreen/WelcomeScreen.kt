package com.kadyshev.firstkmpproject.welcomeScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kadyshev.firstkmpproject.theme.AppBrushes
import com.kadyshev.firstkmpproject.theme.AppPalette
import firstkmpproject.composeapp.generated.resources.Res
import firstkmpproject.composeapp.generated.resources.get_started
import firstkmpproject.composeapp.generated.resources.placeholder
import firstkmpproject.composeapp.generated.resources.placeholder_text
import firstkmpproject.composeapp.generated.resources.welcome_description
import firstkmpproject.composeapp.generated.resources.welcome_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private const val imageUrl = "https://lp.jetbrains.com/static/2021/03/23/155113-0.15265793.png"

@Composable
fun WelcomeScreen(
    modifier: Modifier,
    onClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(brush = AppBrushes.MainGradient)
            .verticalScroll(state = rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = stringResource(Res.string.placeholder_text),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f),
            contentScale = ContentScale.Fit,
            error = painterResource(Res.drawable.placeholder),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(Res.string.welcome_title),
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(Res.string.welcome_description),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { onClick() },
            modifier = Modifier.fillMaxWidth(0.6f),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppPalette.Purple500,
                contentColor = Color.White
            ),
        ) {
            Text(
                text = stringResource(Res.string.get_started),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}
