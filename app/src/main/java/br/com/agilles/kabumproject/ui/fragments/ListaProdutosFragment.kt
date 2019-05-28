package br.com.agilles.kabumproject.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import br.com.agilles.kabumproject.R
import br.com.agilles.kabumproject.models.Produto
import br.com.agilles.kabumproject.retrofit.ProdutoResponse
import br.com.agilles.kabumproject.retrofit.client.ProdutoWebClient
import br.com.agilles.kabumproject.ui.adapter.EndlessScroll
import br.com.agilles.kabumproject.ui.adapter.ProdutosAdapter
import kotlinx.android.synthetic.main.fragment_lista_produtos.*


class ListaProdutosFragment : Fragment() {
    private var pagina = 1
    private val listaProdutos: MutableList<Produto> = mutableListOf()
    private var criado: Boolean = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_produtos, container, false)
        setHasOptionsMenu(true)
        carregaListaProdutos(pagina)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraToolbar()
        mostraProgressBar()

    }

    private fun carregaListaProdutos(pagina: Int) {
        ProdutoWebClient().listarProdutos(object : ProdutoResponse {
            override fun sucess(produtos: List<Produto>) {
                listaProdutos.addAll(produtos)
                configuraLista(listaProdutos)
            }

            override fun falha(msg: String) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
        }, 1, pagina)
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
        mostraRecyclerView()
        lista_produtos_recycler_view.adapter?.notifyDataSetChanged()
        configuraRecyclerView(produtos)
    }

    private fun configuraRecyclerView(produtos: List<Produto>) {
        val recyclerView = lista_produtos_recycler_view
        if (criado == false) {
            context?.let {
                recyclerView.adapter = ProdutosAdapter(produtos, it)
            }
            criado = true
        }
        adicionaScrollListener(recyclerView)

    }

    private fun adicionaScrollListener(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : EndlessScroll() {
            override fun carregaMaisItens() {
                Toast.makeText(context, "Carregando...", Toast.LENGTH_SHORT).show()
                pagina++
                carregaListaProdutos(pagina)
            }
        })

    }


    private fun mostraRecyclerView() {
        if (lista_produtos_progress_bar.visibility == View.VISIBLE && lista_produtos_texto_loading.visibility == View.VISIBLE) {
            lista_produtos_progress_bar.visibility = View.GONE
            lista_produtos_texto_loading.visibility = View.GONE
            lista_produtos_recycler_view.visibility = View.VISIBLE
            bottom_menu.visibility = View.VISIBLE
        }
    }

    private fun mostraProgressBar() {
        if (lista_produtos_progress_bar.visibility == View.GONE && lista_produtos_texto_loading.visibility == View.GONE) {
            lista_produtos_progress_bar.visibility = View.VISIBLE
            lista_produtos_texto_loading.visibility = View.VISIBLE
            lista_produtos_recycler_view.visibility = View.GONE
        }
    }
}




