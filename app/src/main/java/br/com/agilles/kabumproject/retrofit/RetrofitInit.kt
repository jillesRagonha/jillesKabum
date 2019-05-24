package br.com.agilles.kabumproject.retrofit

import br.com.agilles.kabumproject.retrofit.services.ProdutosService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://servicespub.prod.api.aws.grupokabum.com.br/home/v1/home/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun produtoService() = retrofit.create(ProdutosService::class.java)
}