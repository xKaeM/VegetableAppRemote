package com.example.vegetableapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose.VegetableAppTheme

@Composable
fun LogoScreen(f: ()->Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_small)))
        TextOnTheTop(
            logoText = R.string.app_name
        )
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_medium)))
        LogoImage(
            logoImage = R.drawable.bananas
        )
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_large) * 2))
        NextButton(buttonText = R.string.next_button, f)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LogoScreenPreview(){
    VegetableAppTheme(useDarkTheme = true) {
        LogoScreen({})
    }
}

@Composable
fun LogoImage(
    @DrawableRes logoImage: Int,
){
    Box(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_logo_size))
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)
            .border(
                width = dimensionResource(id = R.dimen.border_small),
                color = MaterialTheme.colorScheme.tertiary,
                shape = CircleShape
            )
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ){
        Image(
            painter = painterResource(id = logoImage),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_logo_size))
        )
    }
}

@Preview
@Composable
fun LogoImagePreview(){
    VegetableAppTheme(useDarkTheme = true){
        LogoImage(
            logoImage = R.drawable.bananas
        )
    }
}

@Composable
fun NextButton(
    @StringRes buttonText: Int,
    f: () -> Unit
){
    Button(
        onClick = {f()},
        modifier = Modifier
            .size(
                width = dimensionResource(id = R.dimen.button_width),
                height = dimensionResource(id = R.dimen.button_height)
            )
    ) {
        Text(
            text = stringResource(id = buttonText),
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview
@Composable
fun NextButtonPreview(){
    VegetableAppTheme(useDarkTheme = true) {
        NextButton(buttonText = R.string.next_button, {})
    }
}