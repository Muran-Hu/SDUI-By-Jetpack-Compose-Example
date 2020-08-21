package com.example.jetpackcompose.sdui

import java.io.Serializable

data class SDUIBean(
        val name: String,
        val componentGroups: List<ComponentGroup>,
) : Serializable

data class ComponentGroup(
        val name: String,
        val components: List<Component>,
) : Serializable

data class Component(
        val name: String,
        val type: String,
        val parameters: Parameters,
        val entitySideEffects: List<EntitySideEffect>,
) : Serializable

data class Parameters(
        val icon: String,
        val lowerText: String,
        val text: String,
        val title: String,
        val upperText: String
) : Serializable

data class EntitySideEffect(
        val entity: String,
        val idType: String,
        val verb: String
) : Serializable