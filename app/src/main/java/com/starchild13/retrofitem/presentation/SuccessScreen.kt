package com.starchild13.retrofitem.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.starchild13.retrofitem.domain.Quote



@Composable
fun SuccessScreen(quoteList: List<Quote>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(7.dp)) {
        items(quoteList) { quote ->
            SuccessCard(quote = quote)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SuccessCard(quote: Quote) {

    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(3.dp)) {

        Row(
            modifier = Modifier.padding(7.dp)
        ) {
            GlideImage(
                model = quote.image,
                contentDescription = "The Simpsons Image",
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(7.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(

                ) {
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Name: ")
                        }
                        append(text = quote.character)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Character Direction: ")
                        }
                        append(text = quote.characterDirection)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Quote: ")
                        }
                        append(text = quote.quote)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                }
            }

        }

    }

}