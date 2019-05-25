package br.com.agilles.kabumproject.retrofit

import br.com.agilles.kabumproject.models.Produto

interface ProdutoResponse {
    fun sucess(produtos: List<Produto>)
}