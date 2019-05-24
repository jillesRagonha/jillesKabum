package br.com.agilles.kabumproject.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import br.com.agilles.kabumproject.R
import br.com.agilles.kabumproject.models.Produto
import br.com.agilles.kabumproject.retrofit.ProdutoResponse
import br.com.agilles.kabumproject.retrofit.client.ProdutoWebClient
import br.com.agilles.kabumproject.ui.adapter.ProdutosAdapter
import kotlinx.android.synthetic.main.fragment_lista_produtos.*

class ListaProdutosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_produtos, container, false)
        setHasOptionsMenu(true)
        return view
    }

    private fun mostraProgressBar() {
        if (lista_produtos_progress_bar.visibility == View.GONE && lista_produtos_texto_loading.visibility == View.GONE) {
            lista_produtos_progress_bar.visibility = View.VISIBLE
            lista_produtos_texto_loading.visibility = View.VISIBLE
            lista_produtos_recycler_view.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraToolbar()
        mostraProgressBar()

        /**
         * Por ter enviado a interface como parâmetro, agora consigo sobrescrever o método aqui
         * que vai ser chamado sempre que houver sucesso na requisição
         */
        ProdutoWebClient().listarProdutos(object : ProdutoResponse {
            override fun sucess(produtos: List<Produto>) {
                configuraLista(produtos)
            }

        })
    }

    private fun configuraToolbar() {
        if (activity is AppCompatActivity) {
            with(activity as AppCompatActivity) {
                toolbar.title = ""
                setSupportActionBar(toolbar)


            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    fun configuraLista(produtos: List<Produto>) {
        val recyclerView = lista_produtos_recycler_view
        with(recyclerView) {
            context?.let {
                adapter = ProdutosAdapter(produtos, context)
            }
        }
        mostraRecyclerView()
    }

    private fun mostraRecyclerView() {
        if (lista_produtos_progress_bar.visibility == View.VISIBLE && lista_produtos_texto_loading.visibility == View.VISIBLE) {
            lista_produtos_progress_bar.visibility = View.GONE
            lista_produtos_texto_loading.visibility = View.GONE
            lista_produtos_recycler_view.visibility = View.VISIBLE
        }
    }

}
