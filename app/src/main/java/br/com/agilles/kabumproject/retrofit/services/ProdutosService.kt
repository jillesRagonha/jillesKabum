package br.com.agilles.kabumproject.retrofit.services

import br.com.agilles.kabumproject.dto.ProdutosDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Para implementar o servico do retrofit,
 * crio uma classe q vai representar qual tipo de serviço ele vai consumir
 */
interface ProdutosService {
    @GET("produto")
    fun list(
        @Query("app") app: Int,
        @Query("limite") limite: Int,
        @Query("pagina") pagina: Int
    ): Call<ProdutosDTO>
}