package com.example.jetpackcompose.sdui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PactSDUIScreenActivity : AppCompatActivity() {
    var sduiBean: SDUIBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sduiBean = intent.getSerializableExtra(Constants.SDUI_BEAN) as SDUIBean

        setContent {
            NewStory(sduiBean)
        }
    }
}

@Composable
fun NewStory(sduiBean: SDUIBean?) {
    Scaffold(
        topBar = {
            NavigationBar()
        },
        bodyContent = {
            Content(sduiBean)
        }
    )
}

@Composable
fun NavigationBar() {
    Text(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        text = "Pact",
        textAlign = TextAlign.Center,
        color = Color(0xFF11A665),
        fontSize = PactDimens.H1
    )
}

@Composable
fun Content(sduiBean: SDUIBean?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        sduiBean?.componentGroups?.forEach { _it ->
            _it.components.forEach {
                when (it.type) {
                    Constants.H1 -> {
                        val h1 = PactSDUIBaseComponent()
                        h1.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H1(h1)
                    }
                    Constants.H2 -> {
                        val h2 = PactSDUIBaseComponent()
                        h2.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H2(h2)
                    }
                    Constants.H3 -> {
                        val h3 = PactSDUIBaseComponent()
                        h3.parameterTypes?.text?.description = it.parameters.text
                        SDUI_H3(h3)
                    }
                    Constants.ICON_AND_TEXT_CTA -> {
                        val iconAndTextCta = PactSDUIBaseComponent()
                        iconAndTextCta.parameterTypes.text.examples.add(it.parameters.text)
                        SDUI_IconAndTextCta(iconAndTextCta)
                    }
                    Constants.PRIMARY_CTA_SLIDER -> {
                        val primaryCtaSlider = PactSDUIBaseComponent()
                        SDUI_PrimaryCtaSlider(primaryCtaSlider)
                    }
                    Constants.SUMMARY_EDIT_CELL -> {
                        val summaryEditCell = PactSDUIBaseComponent()
                        summaryEditCell.parameterTypes?.upperText?.examples?.add(it.parameters.upperText)
                        summaryEditCell.parameterTypes?.lowerText?.examples?.add(it.parameters.lowerText)
                        SDUI_SummaryEditCell(summaryEditCell)
                    }
                    Constants.SINGLE_SELECT -> {
                        val singleSelect = PactSDUIBaseComponent()
                        SDUI_SingleSelect(singleSelect)
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalGravity = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                val summaryEditCell = PactSDUIBaseComponent()
                summaryEditCell.parameterTypes.upperText.examples.add("State")
                summaryEditCell.parameterTypes.lowerText.examples.add("OH")
                SDUI_SummaryEditCell(summaryEditCell)
            }

            Divider(
                modifier = Modifier.height(20.dp).width(0.2.dp),
                color = Color.Gray
            )

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                val summaryEditCell = PactSDUIBaseComponent()
                summaryEditCell.parameterTypes.upperText.examples.add("Zip")
                summaryEditCell.parameterTypes.lowerText.examples.add("45202")
                SDUI_SummaryEditCell(summaryEditCell)
            }
        }

        SDUIRoundedCornerButtonComponent("Continue")
    }
}