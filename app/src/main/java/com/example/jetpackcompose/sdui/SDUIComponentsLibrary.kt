package com.example.jetpackcompose.sdui

data class SDUIComponentsLibrary(
    val H1: H1,
    val H2: H2,
    val H3: H3,
    val IconAndTextCta: IconAndTextCta,
    val PrimaryCtaSlider: PrimaryCtaSlider,
    val SingleSelect: SingleSelect,
    val SummaryEditCell: SummaryEditCell
)

data class H1(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", ParameterTypes(), "")
}

data class H2(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", ParameterTypes(), "")
}

data class H3(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", ParameterTypes(), "")
}

data class IconAndTextCta(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", ParameterTypes(), "")
}

data class PrimaryCtaSlider(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", ParameterTypes(), "")
}

data class SingleSelect(
    val category: String,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", "", ParameterTypes(), "")
}

data class SummaryEditCell(
    val category: String,
    val defaultStyle: DefaultStyle?,
    val description: String,
    val parameterTypes: ParameterTypes?,
    val type: String
) {
    constructor() : this("", DefaultStyle(), "", null, "")
}

data class DefaultStyle(
    val properties: Properties
) {
    constructor() : this(Properties())
}

data class ParameterTypes(
    var text: Text
) {
    constructor() : this(Text())
}

data class Properties(
    val color: String,
    val fontFamily: String,
    val fontSize: String,
    val fontWeight: String,
    val lineHeight: String
) {
    constructor() : this("", "", "", "", "")
}

data class Text(
    val dataType: String,
    var description: String,
    val examples: List<String>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(), false)
}

data class Icon(
    val dataType: String,
    val description: String,
    val examples: List<String>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(), false)
}

data class Title(
    val dataType: String,
    val description: String,
    val examples: List<String>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(), false)
}

data class Selectables(
    val dataType: String,
    val description: String,
    val examples: List<List<Example>>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(listOf(Example())), false)
}

data class Example(
    val label: String,
    val value: String
) {
    constructor() : this("", "")
}

data class LowerText(
    val dataType: String,
    val description: String,
    val examples: List<String>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(), false)
}

data class UpperText(
    val dataType: String,
    val description: String,
    val examples: List<String>,
    val required: Boolean
) {
    constructor() : this("", "", listOf(), false)
}