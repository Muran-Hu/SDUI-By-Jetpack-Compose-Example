package com.example.jetpackcompose.sdui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent

class PactSDUIScreenActivity : AppCompatActivity() {
    var sduiBean: SDUIBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sduiBean = intent.getSerializableExtra(Constants.SDUI_BEAN) as SDUIBean

        setContent {
            CustomScreen(sduiBean)
        }
    }
}

@Composable
fun CustomScreen(sduiBean: SDUIBean?) {
    Column {
        sduiBean?.componentGroups?.forEach { _it ->
            _it.components.forEach {
                when (it.type) {
                    Constants.H1 -> {
                        val h1 = H1()
                        h1.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H1(h1)
                    }
                    Constants.H2 -> {
                        val h2 = H2()
                        h2.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H2(h2)
                    }
                    Constants.H3 -> {
                        val h3 = H3()
                        h3.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H3(h3)
                    }
                    Constants.ICON_AND_TEXT_CTA -> {
                        val iconAndTextCta = IconAndTextCta()
                        SDUI_IconAndTextCta(iconAndTextCta)
                    }
                    Constants.PRIMARY_CTA_SLIDER -> {
                        val primaryCtaSlider = PrimaryCtaSlider()
                        SDUI_PrimaryCtaSlider(primaryCtaSlider)
                    }
                    Constants.SUMMARY_EDIT_CELL -> {
                        val summaryEditCell = SummaryEditCell()
                        SDUI_SummaryEditCell(summaryEditCell)
                    }
                    Constants.SINGLE_SELECT -> {
                        val singleSelect = SingleSelect()
                        SDUI_SingleSelect(singleSelect)
                    }
                }
            }
        }
    }
}