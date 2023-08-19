package com.example.vegetableapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.VegetableAppTheme

@Composable
fun HomeScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ){
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_small)))
        TextOnTheTop(logoText = R.string.choose_products)
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_large)))
        ProductCard(DataSource().productList[0])

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview(){
    VegetableAppTheme(useDarkTheme = true){
        HomeScreen()
    }
}

@Composable
fun ProductCard(product: Product){
    Card(
        modifier = Modifier.padding(10.dp)
    ){
        Column(
            modifier = Modifier
                .size(width = 400.dp, height = 320.dp)
                .padding(15.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                CardImage(product.productImage)
                Spacer(Modifier.width(dimensionResource(id = R.dimen.spacer_width_small)))
                CardText(
                    product.productName,
                    product.price,
                    product.poundsOrEach
                )
            }
            Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_medium)))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ){
                CardButton(buttonText = R.string.add_button)
                Spacer(Modifier.width(dimensionResource(id = R.dimen.spacer_width_medium)))
                CardButton(buttonText = R.string.order_button)
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview(){
    VegetableAppTheme(useDarkTheme = true){
        ProductCard(Product(R.string.apple, R.drawable.apple, 2.31, R.string.per_pound))
    }
}

@Composable
fun CardImage(@DrawableRes productImage: Int){
    Image(
        painter = painterResource(productImage),
        contentDescription = null,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_size))
    )
}

@Preview
@Composable
fun CardImagePreview(){
    VegetableAppTheme(useDarkTheme = true){
        CardImage(R.drawable.apple)
    }
}

@Composable
fun CardText(
    @StringRes productName: Int,
    price: Double,
    @StringRes poundOrEach: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.height(dimensionResource(id = R.dimen.image_size))
    ){
        Text(
            text = stringResource(id = productName),
            style = TextStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(dimensionResource(id = R.dimen.spacer_height_small)))
        Text(
            text = "$" + price.toString() + " " +stringResource(id = poundOrEach),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

        )
    }
}

@Preview
@Composable
fun CardTextPreview(){
    VegetableAppTheme(useDarkTheme = true){
        CardText(
            R.string.banana,
            2.31,
            R.string.per_pound
        )
    }
}

@Composable
fun CardButton(@StringRes buttonText: Int){
    Button(
        onClick = {/*TODO*/},
        modifier = Modifier
            .size(
                dimensionResource(id = R.dimen.button_width),
                dimensionResource(id = R.dimen.button_height)
            )
    ){
        Text(
            text = stringResource(id = buttonText),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),

        )
    }
}

@Preview
@Composable
fun CardButtonPreview(){
    VegetableAppTheme(useDarkTheme = true){
        CardButton(R.string.add_button)
    }
}