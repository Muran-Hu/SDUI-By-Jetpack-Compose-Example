package com.example.jetpackcompose.sdui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.nativeClass

class Res_H1_Default {
    companion object {
        val fontFamily = PactFontFamily.Sofia_Pro
        val fontWeight = PactFontWeight.NORMAL
        val fontSize = PactDimens.H1
        val lineHeight = PactLineHeight.Percent_100
        val color = PactColor.H1
    }
}

class Res_H2_Default {
    companion object {
        val fontFamily = PactFontFamily.Sofia_Pro
        val fontWeight = PactFontWeight.BOLD
        val fontSize = PactDimens.H2
        val lineHeight = PactLineHeight.Percent_100
        val color = PactColor.H2
    }
}

class Res_H3_Default {
    companion object {
        val fontFamily = PactFontFamily.Sofia_Pro
        val fontWeight = PactFontWeight.NORMAL
        val fontSize = PactDimens.H3
        val lineHeight = PactLineHeight.Percent_100
        val color = PactColor.H3
    }
}

class PactColor {
    companion object {
        val H1 = Color(0xFF2C2D36)
        val H2 = Color(0xFF2C2D36)
        val H3 = Color(0xFF94949E)
        val GREEN = Color(0xFF11A665)
    }
}

class PactDimens {
    companion object {
        val H1 = 28.sp
        val H2 = 17.sp
        val H3 = 17.sp
    }
}

class PactFontFamily {
    companion object {
        const val Sofia_Pro = "Sofia Pro"
    }
}

class PactFontWeight {
    companion object {
        val NORMAL = FontWeight.Normal
        val BOLD = FontWeight.Bold
    }
}

class PactLineHeight {
    companion object {
        const val Percent_100 = 1L
    }
}