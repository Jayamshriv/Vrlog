package com.example.vrlog.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.vrlog.domain.model.post.BlogsPostItemModel
import com.example.vrlog.presentation.ui.theme.Purple40

@Composable
fun BlogsPostCard(
    modifier: Modifier = Modifier,
    post: BlogsPostItemModel,
    onClick: (String) -> Unit,
) {
    val animatable = remember {
        Animatable(0.75f)
    }
    LaunchedEffect(key1 = true) {
        animatable.animateTo(1f, tween(300, easing = FastOutLinearInEasing))
    }

    if (post != null) {
        Card(
            colors = CardColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .graphicsLayer {
                    this.scaleX = animatable.value
                    this.scaleY = animatable.value
                }
                .clip(shape = RoundedCornerShape(12.dp))
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent
                )
                .padding(8.dp)
                .border(
                    BorderStroke(
                        0.4.dp, color = Purple40
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
            ,
            onClick = {
                onClick(post.link)
            }

        ) {
            Column(
            ) {
                SubcomposeAsyncImage(
                    model = post.jetpackFeaturedMediaUrl,
                    loading = {
                        CenteredCircularProgress()
                    },
                    contentDescription = "image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)


                )

                Text(
                    text = post.title.rendered,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp)

                )


            }

        }
    } else {
        CenteredCircularProgress()
    }
}

