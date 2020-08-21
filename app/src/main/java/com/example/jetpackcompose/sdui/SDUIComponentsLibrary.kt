package com.example.jetpackcompose.sdui

data class PactSDUIBaseComponent(
    val type: String,
    val category: String,
    val description: String,
    val parameterTypes: ParameterTypes,
    val defaultStyle: DefaultStyle?
) {
    constructor() : this("", "", "", ParameterTypes(), DefaultStyle())
}

data class ParameterTypes(
    val icon: ParameterType,
    val text: ParameterType,
    val title: ParameterType,
    val upperText: ParameterType,
    val lowerText: ParameterType,
    val selectables: ParameterType
) {
    constructor() : this(
        ParameterType(),
        ParameterType(),
        ParameterType(),
        ParameterType(),
        ParameterType(),
        ParameterType()
    )
}

data class ParameterType(
    val dataType: String,
    val required: Boolean,
    var description: String,
    var examples: MutableList<String>
) {
    constructor() : this("", false, "", mutableListOf<String>())
}

data class DefaultStyle(
    val properties: Properties
) {
    constructor() : this(Properties())
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