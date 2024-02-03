package com.starchild13.retrofitem.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    @SerialName("quote") val quote: String,
    @SerialName("character") val character: String,
    @SerialName("image") val image: String,
    @SerialName("characterDirection") val characterDirection: String
)
