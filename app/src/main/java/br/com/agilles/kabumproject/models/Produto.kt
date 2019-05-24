package br.com.agilles.kabumproject.models

import com.google.gson.annotations.SerializedName

data class Produto(
    @SerializedName("codigo") val codigo: Int,
    @SerializedName("img") val imagem: String,
    @SerializedName("nome") val nome: String,
    @SerializedName("preco") val preco: Double,
    @SerializedName("preco_prime") val precoPrime: Double,
    @SerializedName("preco_desconto") val precoDesconto: Double,
    @SerializedName("preco_desconto_prime") val precoDescontoPrime: Double,
    @SerializedName("preco_formatado") val precoFormatado: String,
    @SerializedName("preco_prime_formatado") val precoPrimeFormatado: String,
    @SerializedName("preco_desconto_formatado") val precoDescontoFormatado: String,
    @SerializedName("preco_desconto_prime_formatado") val precoDescontoPrimeFormatado: String,
    @SerializedName("avaliacao_numero") val avaliacaoNumero: Int,
    @SerializedName("avaliacao_nota") val avaliacaoNota: Int,
    @SerializedName("fabricante") val fabricante:Fabricante
)