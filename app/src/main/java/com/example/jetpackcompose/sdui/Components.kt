package com.example.jetpackcompose.sdui

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Composable
fun SDUI_IconAndTextCta(iconAndTextCta: PactSDUIBaseComponent) {
    SDUIOutlinedButtonComponent(iconAndTextCta.parameterTypes.text.examples[0])
}

@Composable
fun SDUI_PrimaryCtaSlider(primaryCtaSlider: PactSDUIBaseComponent) {

}

@Composable
fun SDUI_SummaryEditCell(summaryEditCell: PactSDUIBaseComponent) {
//    TextField(
//        value = summaryEditCell.parameterTypes.lowerText.examples[0],
//        onValueChange = { },
//        label = { Text(summaryEditCell.parameterTypes.upperText.examples[0]) },
//        placeholder = { Text(text = summaryEditCell.parameterTypes.lowerText.examples[0]) },
//        modifier = Modifier.padding(6.dp).fillMaxWidth(),
//        backgroundColor = Color.White
//    )
}

@Composable
fun SDUI_SingleSelect(singleSelect: PactSDUIBaseComponent) {

}

@Composable
fun SDUI_H1(h1: PactSDUIBaseComponent) {
    SDUICustomStyledText(
        displayText = h1.parameterTypes?.text?.description.toString(),
        style = TextStyle(
//            fontFamily = Res_H1_Default.fontFamily,
            fontWeight = Res_H1_Default.fontWeight,
            fontSize = Res_H1_Default.fontSize,
            color = Res_H1_Default.color,
            lineHeight = TextUnit(Res_H1_Default.lineHeight),
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun SDUI_H2(h2: PactSDUIBaseComponent) {
    SDUICustomStyledText(
        displayText = h2.parameterTypes?.text?.description.toString(),
        style = TextStyle(
//            fontFamily = Res_H2_Default.fontFamily,
            fontWeight = Res_H2_Default.fontWeight,
            fontSize = Res_H2_Default.fontSize,
            color = Res_H2_Default.color,
            lineHeight = TextUnit(Res_H2_Default.lineHeight),
            textAlign = TextAlign.Left
        )
    )
}

@Composable
fun SDUI_H3(h3: PactSDUIBaseComponent) {
    SDUICustomStyledText(
        displayText = h3.parameterTypes?.text?.description.toString(),
        style = TextStyle(
//            fontFamily = Res_H3_Default.fontFamily,
            fontWeight = Res_H3_Default.fontWeight,
            fontSize = Res_H3_Default.fontSize,
            color = Res_H3_Default.color,
            lineHeight = TextUnit(Res_H3_Default.lineHeight),
            textAlign = TextAlign.Left
        )
    )

    Divider(color = Color.White, modifier = Modifier.height(10.dp))
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
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp).fillMaxWidth(),
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

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SDUITextInputComponent(label: String, value: String) {
    var textValue by state { TextFieldValue("") }

    // TextField is a composable that is capable of accepting text user input. It renders the
    // value that you pass to the "value" field. In order to update this as the user is
    // typing a new string, we make use of the state delegate. Reacting to state changes is
    // the core behavior of Compose. Any composable that reads the value of the textValue
    // field will recompose whenever this value is changed. In this example, since the
    // TextField is reading the value from the textValue value, and that's also the value
    // that we update as the user types (through the onValueChange lambda), this composable
    // is redrawn and updated with the latest value.

    // In particular, the FilledTextField is a Material Design implementation of the
    // Material Filled TextField - https://material.io/components/text-fields/#filled-text-field
    // It also gives us the ability to provide some placeholder text.

    // We also pass it a modifier. You can think of Modifiers as implementations of the decorators
    // pattern that are used to modify the composable that its applied to. In this example, we
    // assign a padding of 16dp and ask the FilledTextField composable to occupy the entire
    // available width.
    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(text = label) },
        placeholder = { Text(text = value) },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SDUIRoundedCornerButtonComponent(text: String) {
    // Button is a pre-defined Material Design implementation of a contained button -
    // https://material.io/design/components/buttons.html#contained-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        // Provide a custom shape for this button. In this example. we specify the button to have
        // round corners of 16dp radius.
        shape = RoundedCornerShape(6.dp),
        elevation = 5.dp
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = text, modifier = Modifier.padding(16.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SDUIOutlinedButtonComponent(text: String) {
    // Button is a pre-defined Material Design implementation of a outlined button -
    // https://material.io/design/components/buttons.html#outlined-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        backgroundColor = PactColor.GREEN
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = text,
            modifier = Modifier.padding(6.dp),
            color = Color.White,
            fontSize = PactDimens.H2
        )
    }
}