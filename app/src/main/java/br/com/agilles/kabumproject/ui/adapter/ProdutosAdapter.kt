package br.com.agilles.kabumproject.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.kabumproject.R
import br.com.agilles.kabumproject.models.Produto
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_produto.view.*

class ProdutosAdapter(
    private val produtos: List<Produto> = listOf(),
    private val context: Context
) : RecyclerView.Adapter<ProdutosAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, posicao: Int) {
        val produto = produtos[posicao]
        holder.bindView(produto)
    }


    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(produto: Produto) {
            insereValores(produto)
            insereImagens(produto)
        }

        private fun insereValores(produto: Produto) {
            itemView.item_produto_nome.text = produto.nome
            itemView.item_produto_valor_avaliacao.text = produto.avaliacaoNumero.toString()
            itemView.item_produto_preco_desconto.text = produto.precoDescontoFormatado
            itemView.item_produto_preco_normal.text = produto.precoFormatado
            itemView.item_produto_avaliacao.rating = produto.avaliacaoNota.toFloat()
        }

        private fun insereImagens(produto: Produto) {
            Glide.with(itemView).load(produto.imagem).into(itemView.item_produto_imagem_produto)
            Glide.with(itemView).load(produto.fabricante.image).into(itemView.item_produto_imagem_fabricante)

        }

    }
}