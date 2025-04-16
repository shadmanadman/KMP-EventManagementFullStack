package org.kmp.playground.event.management.full.stack.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmp_eventmanagementfullstack.composeapp.generated.resources.Raleway_VariableFont_wght
import kmp_eventmanagementfullstack.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


class MyApplicationColors(
    val mainColor: Color,
    val black: Color,
    val background: Color,
    val cardTitle: Color,
    val title6E6E6E: Color,
    val moreButtonsD3D3D3: Color,
    val freeItem: Color,
    val offColor: Color,
    val white: Color,
    val grayFBFBFB: Color,
    val blue005EEB: Color,
    val redF02D56: Color,
    val yellowFCBA03: Color,
    val whiteABABAB: Color,
    val green1C9445: Color,
    val grayF0F0F0: Color,
    val redDE284E: Color,
    val whiteF6FEFF: Color,
    val black201F20: Color,
    val black000000: Color,
    val grayFAFAFA: Color
)


data class MyApplicationTypography(
    val body12: TextStyle,
    val body13: TextStyle,
    val body14: TextStyle,
    val title15: TextStyle,
    val title16: TextStyle,
    val title17: TextStyle,
    val title18: TextStyle,
    val headline19: TextStyle,
    val headline20: TextStyle,
    val headline21: TextStyle,
    val headline22: TextStyle,
    val headline23: TextStyle,
    val headline26: TextStyle

)

@Composable
fun AppTypography(): MyApplicationTypography {
    val appFontRegular = FontFamily(Font(Res.font.Raleway_VariableFont_wght, weight = FontWeight.Normal))
    return MyApplicationTypography(
        body12 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
        body13 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ),
        body14 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        title15 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        ),
        title16 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        title17 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        ),
        title18 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        headline19 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 19.sp
        ),
        headline20 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        headline21 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 21.sp
        ),
        headline22 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        ),
        headline23 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 23.sp
        ),
        headline26 = TextStyle(
            fontFamily = appFontRegular,
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp
        )
    )
}

/**
 * This is the definition of current app colors:
 * @return An instance of [MyApplicationColors]
 *
 * In White Mode:
 * [MyApplicationColors.mainColor] is #FFA500
 * [MyApplicationColors.black] is #6E6E6E
 * [MyApplicationColors.background] is #F6FEFF
 * [MyApplicationColors.cardTitle] is #201F20
 * [MyApplicationColors.title6E6E6E] is #6E6E6E
 * [MyApplicationColors.moreButtonsD3D3D3] is #D3D3D3
 */
@Composable
fun AppColors(darkTheme: Boolean = isSystemInDarkTheme()): MyApplicationColors {
    return if (darkTheme) {
        MyApplicationColors(
            mainColor = Color(0xFFFFA500),
            black = Color(0xFF6E6E6E),
            background = Color(0xFFF6FEFF),
            cardTitle = Color(0xFF201F20),
            title6E6E6E = Color(0xFF6E6E6E),
            moreButtonsD3D3D3 = Color(0xFFD3D3D3),
            freeItem = Color(0xFF1C9445),
            offColor = Color(0xFFFF0000),
            white = Color(0xFFFFFFFF),
            grayFBFBFB = Color(0xFFFBFBFB),
            blue005EEB = Color(0xFF005EEB),
            redF02D56 = Color(0xFFF02D56),
            yellowFCBA03 = Color(0xFFfcba03),
            whiteABABAB = Color(0xFFABABAB),
            green1C9445 = Color(0xFF1C9445),
            grayF0F0F0 = Color(0xFFF0F0F0),
            redDE284E = Color(0xFFDE284E),
            whiteF6FEFF = Color(0xFFF6FEFF),
            black201F20 = Color(0xFF201F20),
            grayFAFAFA = Color(0xFFFAFAFA),
            black000000 = Color(0xFF000000)
        )
    } else {
        MyApplicationColors(
            mainColor = Color(0xFFFFA500),
            black = Color(0xFF6E6E6E),
            background = Color(0xFFF6FEFF),
            cardTitle = Color(0xFF201F20),
            title6E6E6E = Color(0xFF6E6E6E),
            moreButtonsD3D3D3 = Color(0xFFD3D3D3),
            freeItem = Color(0xFF1C9445),
            offColor = Color(0xFFFF0000),
            white = Color(0xFFFFFFFF),
            grayFBFBFB = Color(0xFFFBFBFB),
            blue005EEB = Color(0xFF005EEB),
            redF02D56 = Color(0xFFF02D56),
            yellowFCBA03 = Color(0xFFfcba03),
            whiteABABAB = Color(0xFFABABAB),
            green1C9445 = Color(0xFF1C9445),
            grayF0F0F0 = Color(0xFFF0F0F0),
            redDE284E = Color(0xFFDE284E),
            whiteF6FEFF = Color(0xFFF6FEFF),
            black201F20 = Color(0xFF201F20),
            grayFAFAFA = Color(0xFFFAFAFA),
            black000000 = Color(0xFF000000)
        )
    }
}