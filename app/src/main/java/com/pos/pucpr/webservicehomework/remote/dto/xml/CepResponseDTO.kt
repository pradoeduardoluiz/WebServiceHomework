package com.pos.pucpr.webservicehomework.remote.dto.xml

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "xmlcep")
data class CepResponseDTO @JvmOverloads constructor(
    @field:Element(name = "cep")
    var cep: String? = "",
    @field:Element(name = "logradouro")
    var street: String? = "",
    @field:Element(name = "complemento", required = false)
    var complement: String? = "",
    @field:Element(name = "bairro")
    var district: String? = "",
    @field:Element(name = "localidade")
    var locale: String? = "",
    @field:Element(name = "uf")
    var uf: String? = "",
    @field:Element(name = "unidade", required = false)
    var unity: String? = "",
    @field:Element(name = "ibge")
    var ibge: String? = "",
    @field:Element(name = "gia", required = false)
    var gia: String? = ""

)