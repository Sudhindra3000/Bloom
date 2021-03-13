package com.sudhindra.bloom.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sudhindra.bloom.R

val fontFamily = FontFamily(
    fonts = listOf(
        Font(
            R.font.nunito_sans_bold,
            weight = FontWeight.Bold
        ),
        Font(
            R.font.nunito_sans_light,
            weight = FontWeight.Light
        ),
        Font(
            R.font.nunito_sans_semi_bold,
            weight = FontWeight.SemiBold
        )
    )
)

val Typography = Typography(
    defaultFontFamily = fontFamily,
    h1 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.15.sp
    ),

    subtitle1 = TextStyle(
        fontSize = 16.sp,
        letterSpacing = 0.sp
    ),

    body1 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    body2 = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.sp
    ),

    button = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.sp
    )
)
