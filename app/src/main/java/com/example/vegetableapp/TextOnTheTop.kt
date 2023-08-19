package com.example.vegetableapp

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose.VegetableAppTheme

@Composable
fun TextOnTheTop(
    @StringRes logoText: Int
){
    Text(
        text = stringResource(id = logoText),
        style = TextStyle(
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Preview
@Composable
fun TextOnTheTopPreview(){
    VegetableAppTheme(useDarkTheme = true){
        TextOnTheTop(
            logoText = R.string.app_name
        )
    }
}