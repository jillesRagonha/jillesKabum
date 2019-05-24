package br.com.agilles.kabumproject.retrofit.services

import br.com.agilles.kabumproject.dto.ProdutosDTO
import retrofit2.Call
import retrofit2.http.GET

/**
 * Para implementar o servico do retrofit,
 * crio uma classe q vai representar qual tipo de serviço ele vai consumir
 */
interface ProdutosService {
    @GET("produto?app=1&limite=4&pagina=1")
    fun list(): Call<ProdutosDTO>}