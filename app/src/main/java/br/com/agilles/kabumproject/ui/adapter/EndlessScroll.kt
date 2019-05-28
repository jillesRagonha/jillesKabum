package br.com.agilles.kabumproject.ui.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log


abstract class EndlessScroll : RecyclerView.OnScrollListener() {

    private var quantidadeTotalItens: Int = 0
    private var quantidadeItensVisiveis: Int = 0
    private var primeiroItemVisivel: Int = 0
    private var totalAnterior = 0
    private lateinit var layoutManager: LinearLayoutManager
    private var carregando = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        super.onScrolled(recyclerView, dx, dy)
        layoutManager = recyclerView.layoutManager as LinearLayoutManager
        quantidadeTotalItens = layoutManager.itemCount
        quantidadeItensVisiveis = recyclerView.childCount
        primeiroItemVisivel = layoutManager.findFirstVisibleItemPosition()
        var indiceLimiteParaCarregar = quantidadeTotalItens - quantidadeItensVisiveis - 3

        if (carregando) {
            if (quantidadeTotalItens > totalAnterior) {
                carregando = false
                totalAnterior = quantidadeTotalItens
            }
        }

        if (!carregando && primeiroItemVisivel >= indiceLimiteParaCarregar) {
            carregaMaisItens()
            carregando = true
        }
    }

    abstract fun carregaMaisItens()


}
