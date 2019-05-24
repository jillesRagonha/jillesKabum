package br.com.agilles.kabumproject.dto

import br.com.agilles.kabumproject.models.Produto
import com.google.gson.annotations.SerializedName

data class ProdutosDTO(
    @SerializedName("produtos") val produtos: List<Produto>
)