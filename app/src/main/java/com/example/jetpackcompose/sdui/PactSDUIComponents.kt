package com.example.jetpackcompose.sdui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Composable
fun IconAndTextCta() {

}

@Composable
fun PrimaryCtaSlider() {

}

@Composable
fun SummaryEditCell() {

}

@Composable
fun SingleSelect() {

}

@Composable
fun H1(displayText:String) {
    SDUICustomStyledText(
        displayText = displayText,
        style = TextStyle(
            color = PactColor.H1,
            fontSize = PactDimens.H1,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun H2(displayText:String) {
    SDUICustomStyledText(
        displayText = displayText,
        style = TextStyle(
            color = PactColor.H2,
            fontSize = PactDimens.H2,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun H3(displayText:String) {
    SDUICustomStyledText(
        displayText = displayText,
        style = TextStyle(
            color = PactColor.H3,
            fontSize = PactDimens.H3,
            textAlign = TextAlign.Center
        )
    )
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SDUICustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    // We should think of composable functions to be similar to lego blocks - each composable
    // function is in turn built up of smaller composable functions. Here, the Text() function is
    // pre-defined by the Compose UI library; you call that function to declare and render text
    // in your app.
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}

/**
 * Android Studio lets you preview your composable functions within the IDE itself, instead of
 * needing to download the app to an Android device or emulator. This is a fantastic feature as you
 * can preview all your custom components(read composable functions) from the comforts of the IDE.
 * The main restriction is, the composable function must not take any parameters. If your composable
 * function requires a parameter, you can simply wrap your component inside another composable
 * function that doesn't take any parameters and call your composable function with the appropriate
 * params. Also, don't forget to annotate it with @Preview & @Composable annotations.
 */
@Preview
@Composable
fun SDUICustomStyledTextPreview() {
    SDUICustomStyledText(
        "This is preview text",
        maxLines = 2,
        style = TextStyle(
            color = Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify
        )
    )
}