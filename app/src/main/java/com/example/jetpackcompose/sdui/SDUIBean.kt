package com.example.jetpackcompose.sdui

data class SDUIBean(
        val componentGroups: List<ComponentGroup>,
        val name: String
)

data class ComponentGroup(
        val components: List<Component>,
        val name: String
)

data class Component(
        val entitySideEffects: List<EntitySideEffect>,
        val name: String,
        val parameters: Parameters,
        val type: String
)

data class EntitySideEffect(
        val entity: String,
        val idType: String,
        val verb: String
)

data class Parameters(
        val icon: String,
        val lowerText: String,
        val text: String,
        val title: String,
        val upperText: String
)