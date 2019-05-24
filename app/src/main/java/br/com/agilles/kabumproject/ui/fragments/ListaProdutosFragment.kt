package br.com.agilles.kabumproject.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.kabumproject.R
import br.com.agilles.kabumproject.models.Produto
import br.com.agilles.kabumproject.retrofit.ProdutoResponse
import br.com.agilles.kabumproject.retrofit.client.ProdutoWebClient
import br.com.agilles.kabumproject.ui.adapter.ProdutosAdapter
import kotlinx.android.synthetic.main.fragment_lista_produtos.*

class ListaProdutosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_produtos, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Por ter enviado a interface como parâmetro, agora consigo sobrescrever o método aqui
         * que vai ser chamado sempre que houver sucesso na requisição
         */
        ProdutoWebClient().listarProdutos(object :ProdutoResponse{
            override fun sucess(produtos: List<Produto>) {
                configuraLista(produtos)
            }

        })
    }


    fun configuraLista(produtos: List<Produto>) {
        val recyclerView = lista_produtos_recycler_view
        with(recyclerView) {
            context?.let {
                recyclerView.adapter = ProdutosAdapter(produtos, context)

            }
        }


    }

    private fun produtos() {

    }

}
