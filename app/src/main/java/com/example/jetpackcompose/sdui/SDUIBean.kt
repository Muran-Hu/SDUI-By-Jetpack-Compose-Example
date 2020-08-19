package com.example.jetpackcompose.sdui

import java.io.Serializable

data class SDUIBean(
        val componentGroups: List<ComponentGroup>,
        val name: String
) : Serializable

data class ComponentGroup(
        val components: List<Component>,
        val name: String
) : Serializable

data class Component(
        val entitySideEffects: List<EntitySideEffect>,
        val name: String,
        val parameters: Parameters,
        val type: String
) : Serializable

data class EntitySideEffect(
        val entity: String,
        val idType: String,
        val verb: String
) : Serializable

data class Parameters(
        val icon: String,
        val lowerText: String,
        val text: String,
        val title: String,
        val upperText: String
) : Serializable