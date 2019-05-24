package br.com.agilles.kabumproject.models

import com.google.gson.annotations.SerializedName

data class Fabricante (
    @SerializedName("codigo")val codigo: Long,
    @SerializedName("img")val image: String,
    @SerializedName("nome")val nome: String
)