package com.pos.pucpr.webservicehomework.models.xml

data class CepResponse(
    val district: String = "",
    val cep: String = "",
    val complement: String = "",
    val gia: String = "",
    val ibge: String = "",
    val locale: String = "",
    val street: String = "",
    val uf: String = "",
    val unity: String = ""
)