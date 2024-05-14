package com.example.knownyc.presentation.parks


import android.content.ClipDescription
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.knownyc.R
import com.example.knownyc.presentation.boroughs.BoroughCard
import kotlin.math.sign

@Composable
fun NycParkCard(
    signname: String,
    location: String,
    waterfront: Boolean,
    parksLogo: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit ={}
) {
    val height: Dp = 148.dp
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = modifier
            .padding(6.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = MaterialTheme.colorScheme.surfaceTint
            )
            .requiredHeight(height)
            .clickable {
                onClick()
            }

    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color(220, 231, 200))
                .padding(10.dp)
        ){
            Box (
                modifier = modifier
                    .fillMaxSize()
                    .border(width = 2.dp, color = Color(111, 191, 115))
            ){
                Row (
                    modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ){
                    if(waterfront){
                        Image(
                            painter = painterResource(id = R.drawable.waves_24px),
                            contentDescription = "Has a waterfront",
                            modifier
                                .padding(10.dp),
                            colorFilter = ColorFilter.tint(color = Color.Cyan)
                        )
                    }

                    Image(
                        painter = parksLogo,
                        contentDescription = "NYC Parks Logo",
                        modifier
                            .fillMaxWidth(0.3f)
                            .align(Alignment.CenterVertically)
                    )
                    Column {
                        Text(
                            text = signname,
                            textAlign = TextAlign.Left,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text = location,
                            textAlign = TextAlign.Left,
                            fontSize = 16.sp,
                            modifier = modifier
                                .fillMaxWidth()
                        )
                    }

                }

            }



        }

    }

}

@Preview
@Composable
fun NycParkCardPreview(){
    NycParkCard(
        "The Park",
        "Chill Street",
        true,
        parksLogo = painterResource(id = R.drawable.nyc_parks_logo,
        ))
}