package br.com.agilles.kabumproject.retrofit.client

import android.util.Log
import br.com.agilles.kabumproject.dto.ProdutosDTO
import br.com.agilles.kabumproject.retrofit.ProdutoResponse
import br.com.agilles.kabumproject.retrofit.RetrofitInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Classe responsável por lidar com requisições referentes a produto
 */
class ProdutoWebClient {

    /**
     * Mando uma interface como parâmetro no método
     * que vai retornar sucess
     */
    fun listarProdutos(produtoResponse: ProdutoResponse){
        val call = RetrofitInit().produtoService().list(app = 1, limite = 5, pagina = 2)
        call.enqueue(object : Callback<ProdutosDTO>{
            override fun onResponse(call: Call<ProdutosDTO>, response: Response<ProdutosDTO>) {
                response.body()?.let {
                    val produtos = it.produtos
                    produtoResponse.sucess(produtos)
                }
            }
            override fun onFailure(call: Call<ProdutosDTO>, t: Throwable) {
                Log.e("onFailure error", t.message)
            }
        })

    }
}