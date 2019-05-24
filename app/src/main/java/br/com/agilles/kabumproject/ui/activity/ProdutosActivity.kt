package br.com.agilles.kabumproject.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import br.com.agilles.kabumproject.R
import br.com.agilles.kabumproject.ui.fragments.ListaProdutosFragment

class ProdutosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)
        exibeFragment(ListaProdutosFragment(), false)
    }

    private fun exibeFragment(fragment: Fragment, empilhado: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            replace(R.id.produtos_frame_layout, fragment)
            if (empilhado) {
                addToBackStack(null)
            }
            commit()
        }



    }
}
